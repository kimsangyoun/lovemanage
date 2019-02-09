package com.lovemanager.lmservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lovemanager.lmservice.Dao.MemberDao;
import com.lovemanager.lmservice.Dao.DaoImpl.MemberDaoImpl;
import com.lovemanager.lmservice.Dto.UserDto;

@Service("CustomUserDetails")
public class UserService implements UserDetailsService {
	@Autowired
	MemberDao memberDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
			UserDto user = memberDAO.selectMember(username);
			
			if(null == user) {
				throw new UsernameNotFoundException("User Not Found");
			}else {
				System.out.println(user.getUserId());
			}
			return user;
	}
	
}