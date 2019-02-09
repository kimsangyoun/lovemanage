package com.lovemanager.lmservice.Security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

public class CustomLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler implements LogoutSuccessHandler {
 
 /*   @Autowired
    private AuditService auditService; */
 
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
    	System.out.println("·Î±×¾Æ¿ô!");
       // String refererUrl = request.getHeader("Referer");
        response.setStatus(HttpServletResponse.SC_OK);
        //redirect to login
		response.sendRedirect(request.getContextPath()+"/login.do");
        //super.onLogoutSuccess(request, response, authentication);
    }
}
