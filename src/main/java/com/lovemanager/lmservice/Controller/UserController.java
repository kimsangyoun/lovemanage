package com.lovemanager.lmservice.Controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lovemanager.lmservice.Dto.UserDto;
import com.lovemanager.lmservice.Service.MemberService;
import com.lovemanager.lmservice.Validator.MemberValidator;

/**
 * Handles requests for the application home page.
 */
@RequestMapping("/")
@Controller
public class UserController {
	@Autowired
	MemberService memberService;
	@Autowired
	MemberValidator validator;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	

	@RequestMapping("/login")
	public String form(Model model){
		System.out.println("여긴와");
	    model.addAttribute("user", new UserDto());
	    return "login";
	}
	
	@InitBinder
    private void initBinder(WebDataBinder binder){
        binder.setValidator(this.validator);
    }

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		 model.addAttribute("user", new UserDto());
		return "home/login";
	}
	
	@RequestMapping(value = "/signup.do", method = RequestMethod.GET)
	public String signup(Model model) {
		 model.addAttribute("user", new UserDto());
		return "home/signup";
	}

	@ResponseBody
	@RequestMapping(value = "/signup.do", method = RequestMethod.POST)
	public Map<String,Object> trysignup(@RequestBody @Validated UserDto user,BindingResult bindingResult) {
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
			
		if(bindingResult.hasErrors()){ //validation 에러가 있으면,
			resultMap.put("resultMsg", bindingResult.getAllErrors().get(0).getDefaultMessage());
			resultMap.put("resultCode", "100");
			return resultMap;
		}

		int result = memberService.insertUser(user);
			
		if(result <1) {
			resultMap.put("resultMsg", "회원가입 실패");
			resultMap.put("resultCode", "000");
			return resultMap;
		}else {
			result = memberService.insertBasicRole(user);
			if(result <1) {
				result = memberService.deleteUser(user);
				if(result <1) {
					//로깅
					System.out.println("삭제 -1");
				}
				resultMap.put("resultMsg", "회원가입 실패");
				resultMap.put("resultCode", "000");
				return resultMap;
			}
		}
			
			resultMap.put("resultMsg", "회원가입 성공");
			resultMap.put("resultCode", "200");

				
		return resultMap;
	}
	
	@RequestMapping(value = "/loginfail.do", method = RequestMethod.POST)
	public String loginfail(UserDto user,String error, Model model) 
	{
		model.addAttribute("user", user);
		model.addAttribute("id", user.getUserId());
		return "home/login";
	}
	
	@ResponseBody
	@RequestMapping(value = "/user/finduser.do", method = RequestMethod.POST)
	public Map<String,Object> findUser(@RequestBody UserDto user) {
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
			/*
		if(bindingResult.hasErrors()){ //validation 에러가 있으면,
			resultMap.put("resultMsg", bindingResult.getAllErrors().get(0).getDefaultMessage());
			resultMap.put("resultCode", "100");
			return resultMap;
		}*/
		UserDto curruser = (UserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println(curruser.getUserId());
		
		if(user ==null || user.getUserId().equals("")) {
			resultMap.put("resultMsg", "회원조회 실패");
			resultMap.put("resultCode", "000");
			return resultMap;
		}else if(user.getUserId().equals(curruser.getUserId())) {
			resultMap.put("resultMsg", "자신과 커플을 하실수 없습니다.");
			resultMap.put("resultCode", "100");
			return resultMap;
		}
		
		UserDto userDto = memberService.findMemberbyCouple(user);
			
		if(userDto ==null) {
			resultMap.put("resultMsg", "회원조회 실패");
			resultMap.put("resultCode", "000");
			return resultMap;
		}
		resultMap.put("resultMsg", "회원조회 성공");
		resultMap.put("resultCode", "200");
		resultMap.put("resultData", userDto);
				
		return resultMap;
	}
	
	@ResponseBody
	@RequestMapping(value = "/user/findrequest.do", method = RequestMethod.POST)
	public Map<String,Object> findRequest(@RequestBody UserDto user) {
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
			/*
		if(bindingResult.hasErrors()){ //validation 에러가 있으면,
			resultMap.put("resultMsg", bindingResult.getAllErrors().get(0).getDefaultMessage());
			resultMap.put("resultCode", "100");
			return resultMap;
		}*/

		List<UserDto> userList = memberService.findRequestUser(user);
			
		if(userList ==null && userList.size() ==0) {
			resultMap.put("resultMsg", "회원조회 실패 또는 없음.");
			resultMap.put("resultCode", "000");
			return resultMap;
		}
		resultMap.put("resultMsg", "회원조회 성공");
		resultMap.put("resultCode", "200");
		resultMap.put("resultData", userList);
				
		return resultMap;
	}
	
	@ResponseBody
	@RequestMapping(value = "/user/couplerequest.do", method = RequestMethod.POST)
	public Map<String,Object> coupleRequest(@RequestBody UserDto user) {
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
			/*
		if(bindingResult.hasErrors()){ //validation 에러가 있으면,
			resultMap.put("resultMsg", bindingResult.getAllErrors().get(0).getDefaultMessage());
			resultMap.put("resultCode", "100");
			return resultMap;
		}*/
		UserDto u = new UserDto();
		u.setUserId(user.getCoupleId());
		UserDto userDto = memberService.findMemberbyCouple(u);
			
		if(userDto ==null || userDto.getUserId().equals("")) {
			System.out.println("널이래?");
			resultMap.put("resultMsg", "커플신청 실패");
			resultMap.put("resultCode", "000");
			return resultMap;
		}
		int result = memberService.insertRequest(user);
		System.out.println("인서트?");
		if(result>0) {
			resultMap.put("resultMsg", "회원조회 성공");
			resultMap.put("resultCode", "200");
		}else {
			resultMap.put("resultMsg", "커플신청 실패");
			resultMap.put("resultCode", "000");
			return resultMap;
		}
				
		return resultMap;
	}
	
	@ResponseBody
	@RequestMapping(value = "/user/acceptrequest.do", method = RequestMethod.POST)
	public Map<String,Object> acceptRequest(@RequestBody UserDto user) {
		
		Map<String,Object> resultMap = new HashMap<String,Object>();
			/*
		if(bindingResult.hasErrors()){ //validation 에러가 있으면,
			resultMap.put("resultMsg", bindingResult.getAllErrors().get(0).getDefaultMessage());
			resultMap.put("resultCode", "100");
			return resultMap;
		}*/

	/*	UserDto userDto = memberService.findMemberbyCouple(u);
			
		if(userDto ==null || userDto.getUserId().equals("")) {
			System.out.println("널이래?");
			resultMap.put("resultMsg", "커플신청 실패");
			resultMap.put("resultCode", "000");
			return resultMap;
		}*/
		int result = memberService.insertCouple(user);
		System.out.println("인서트?");
		if(result>0) {
			resultMap.put("resultMsg", "회원조회 성공");
			resultMap.put("resultCode", "200");
		}else {
			resultMap.put("resultMsg", "커플신청 실패");
			resultMap.put("resultCode", "000");
			return resultMap;
		}
				
		return resultMap;
	}
	
	
	
}
