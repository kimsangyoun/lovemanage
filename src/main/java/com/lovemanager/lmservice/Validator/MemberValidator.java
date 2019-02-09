package com.lovemanager.lmservice.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lovemanager.lmservice.Dto.UserDto;
@Component
public class MemberValidator implements Validator {
	
		String pwPattern = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,12}$";
		String idPattern = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";   
		

	   @Override
	   public boolean supports(Class<?> clazz) {
	      return UserDto.class.isAssignableFrom(clazz);
	   }

	   @Override
	   public void validate(Object target, Errors errors) {
		   UserDto user = (UserDto)target;
		   ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId",  "required.id","required");
		   ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPwd",  "required.pwd","required");
		   //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userNm",  "required.nm","required");
		   
		   Matcher matcher = Pattern.compile(idPattern).matcher(user.getUserId());
		   
		   if(!matcher.matches()) {
			   errors.rejectValue("userId", "invalidemail", "�ǹٸ� �̸��� ������ �ƴմϴ�.");
		   }
		   // = Pattern.compile(pwPattern).matcher(user.getPassword());
		   System.out.println("user.getPassword()" +user.getPassword());
		   Matcher pwmatcher = Pattern.compile(pwPattern).matcher(user.getPassword());
		   if(!pwmatcher.matches()) {
			   errors.rejectValue("userPwd", "invalidpattern", "��й�ȣ�� 8�� �̻� 12�� ���� �� �����ϸ� Ư������ �� ���� �����̿��߸� �մϴ�.");
		   }
		   
		   
	   }
	}