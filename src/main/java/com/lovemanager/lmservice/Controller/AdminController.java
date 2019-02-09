package com.lovemanager.lmservice.Controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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
@RequestMapping("/admin")
@Controller
public class AdminController {
	@Autowired
	MemberService memberService;
	@Autowired
	MemberValidator validator;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		 //model.addAttribute("user", new UserDto());
		return "admin/index";
	}

}
