package com.lovemanager.lmservice.Security;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

public class CustomAccessDenyHandler extends AccessDeniedHandlerImpl{
	@Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("여길왜와??");
        Iterator<? extends GrantedAuthority> iter = auth.getAuthorities().iterator(); 
        
       while (iter.hasNext()) { 
    	   GrantedAuthority autho = iter.next(); 
    	   System.out.println(autho.getAuthority()); 
    	}

        if (auth != null && !(auth instanceof AnonymousAuthenticationToken)) {
        	response.sendRedirect(request.getContextPath()+"/home/index.do");
        	
            //request.setAttribute("errMsg",ade.getMessage());
            //request.getRequestDispatcher("/WEB-INF/views/user/denied.jsp").forward(req, res);
        }
        
        super.handle(request, response, e);
    }
}
