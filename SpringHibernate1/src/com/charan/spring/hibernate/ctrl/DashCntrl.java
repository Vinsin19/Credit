package com.charan.spring.hibernate.ctrl;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.charan.spring.hibernate.pojo.customer;
import com.charan.spring.hibernate.service.AuthUser;

@Controller
public class DashCntrl {
	
	@RequestMapping("/")
    public String first(){
    	return "first";
    }
    
    @RequestMapping("/login")
    public String login(){
    	return "index";
    }
}
