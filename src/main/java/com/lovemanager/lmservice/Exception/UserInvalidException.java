package com.lovemanager.lmservice.Exception;

import org.springframework.security.core.AuthenticationException;

public class UserInvalidException extends AuthenticationException { 
    /**
	 * 
	 */
	private static final long serialVersionUID = -1643686041737124197L;

	public UserInvalidException(String errorMessage) {
        super(errorMessage);
    }
}
