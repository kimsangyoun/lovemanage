package com.lovemanager.lmservice.Security;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import com.lovemanager.lmservice.Dao.MemberDao;
import com.lovemanager.lmservice.Dto.UserDto;
import com.lovemanager.lmservice.Exception.UserInvalidException;
import com.lovemanager.lmservice.Service.MemberService;
import com.lovemanager.lmservice.Service.UserService;
import com.lovemanager.lmservice.Validator.MemberValidator;

public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    UserService customService;
    @Inject
    MemberValidator validator;
    
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    	UsernamePasswordAuthenticationToken authToken = (UsernamePasswordAuthenticationToken) authentication; //유저가 입력한 정보를 이이디비번으으로만든다.(로그인한 유저아이디비번정보를담는다)
    	System.out.println(authToken.toString()+"뭔대");
    	String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
       
        UserDto userdto = new UserDto();
        userdto.setUserId(username);
        userdto.setUserPwd(password);
        Errors errors = new BeanPropertyBindingResult(userdto, "user");
        System.out.println("kkk"+"authenticate start01");
        validator.validate(userdto, errors);
        if(errors.hasErrors()) {
        	System.out.println("kkk"+"authenticate start01 error"+errors.toString());
        	throw new UserInvalidException(errors.toString());
        }

        UserDto user = (UserDto) customService.loadUserByUsername(username);
        
        if(user ==null) {
        	throw new UsernameNotFoundException(username);
        }
        System.out.println("kkk"+"authenticate start03");
        System.out.println("kkk"+user.getAuthorities().toArray()[0].toString());
        
        if(!matchPassword(password, user.getPassword())) {
            throw new BadCredentialsException(username);
        }
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) user.getAuthorities();
        System.out.println("kkk"+"authenticate start04");
        return new UsernamePasswordAuthenticationToken(username, password, authorities);


    }
    @Override
    public boolean supports(Class<?> authentication) {
          return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
    private boolean matchPassword(String loginPwd, String password) {
        return loginPwd.equals(password);
    }


}

