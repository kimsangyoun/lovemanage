package com.lovemanager.lmservice.Exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class ExceptionControllerAdvice {
	
	  Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);
	    
	    @ExceptionHandler(Exception.class)
	    public String handleAnyException(HttpServletRequest request, HttpServletResponse response, Exception e) {
	       // ExceptionDto exception = new ExceptionDto("Exception on server occurred", e.toString(), ExceptionType.SERVER);
	    	
	    	String isAjax = request.getHeader("Ajax");
	    	System.out.println("error start");
			String forward ="handling";
	    	String type ="error";
	    	
			if(isAjax !=null && isAjax.equals("true")) {
	    		forward="ajaxhandling.do";
			}
	    	if(e instanceof DuplicateKeyException) {
	    		type="DuplicateKeyException";
	    	}
	    	
	        request.setAttribute("msg", type);
	        
	        logger.info(e.toString());
	        
	        return "forward:/errors/"+forward;
	    }
	
	 private String getExceptionMessage(Throwable e) {
	        String message = "";
	        while( e != null ) {
	            message += e.getMessage() + "\n";
	            e = e.getCause();
	        }
	        return message;
	  }
}
