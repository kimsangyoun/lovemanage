package com.lovemanager.lmservice.Exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/errors")
public class ExceptionController {
 
    @RequestMapping(value = "/handling.do", method = RequestMethod.GET)
    public ModelAndView sampleTest(HttpServletRequest request) {
    	System.out.println("¿©±âµµÂø2");
        String msg = (String) request.getAttribute("msg");
        ModelAndView mv = new ModelAndView("/500");
        mv.addObject("msg", msg);
        return mv;
    }
 
    @RequestMapping(value = "/ajaxhandling.do", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    public ResponseEntity<String> handleCustomException(HttpServletRequest request) {

    	String msg =  (String) request.getAttribute("msg");
    	System.out.println("µµÂø"+msg);
        return new ResponseEntity<String>(msg, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
