package com.charan.spring.hibernate.ctrl;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashCntrl {
	
	@RequestMapping(value = "/")
	   public String redirect() {
	      return "redirect:user/login";
	} 
    
    @RequestMapping("/login")
    public String login(){
    	return "index";
    }
}
