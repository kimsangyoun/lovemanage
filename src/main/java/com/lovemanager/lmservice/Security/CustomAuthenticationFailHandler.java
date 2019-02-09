package com.lovemanager.lmservice.Security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.lovemanager.lmservice.Exception.UserInvalidException;

public class CustomAuthenticationFailHandler implements AuthenticationFailureHandler {
    final static int BADCREDIT_ERROR = 1; //비번틀림
    final static int LOCK_ERROR = 2; //계정 락
    final static int USERNOTFIND_ERROR = 3; //아이디없음.
    final static int USERINVALID_ERROR = 4; //아이디없음.
    @Override
    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse res, AuthenticationException authenticationException)
            throws IOException, ServletException {
    	System.out.println("kkk onAuthenticationFailure");
    	int errorType = 0;
    	if(authenticationException instanceof AuthenticationServiceException){
    		errorType = 0;
		}else if(authenticationException instanceof BadCredentialsException){
			errorType = BADCREDIT_ERROR;
		}else if(authenticationException instanceof LockedException){
			errorType = LOCK_ERROR;
		}else if(authenticationException instanceof UsernameNotFoundException){
			errorType = USERNOTFIND_ERROR;
		}else if(authenticationException instanceof UserInvalidException) {
			errorType = USERINVALID_ERROR;
		}

    //	req.setAttribute("errorCode",Integer.toString(errorType) );
        req.setAttribute("userId", req.getParameter("userId"));
        req.getRequestDispatcher("/loginfail.do?error="+Integer.toString(errorType)).forward(req, res);
    }
 
}
//For example, if you receive your request on http://example.com/myapp/subdir,
//
//    RequestDispatcher dispatcher = 
//        request.getRequestDispatcher("index.jsp");
//    dispatcher.forward( request, response ); 
//Will forward the request to the page http://example.com/myapp/subdir/index.jsp.
//
//In any case, you can't forward request to a resource outside of the context.
