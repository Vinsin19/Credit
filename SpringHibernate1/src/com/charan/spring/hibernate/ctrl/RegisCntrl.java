package com.charan.spring.hibernate.ctrl;
 
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.charan.spring.hibernate.pojo.customer;
import com.charan.spring.hibernate.service.AuthUser;
 
@Component
@Controller
public class RegisCntrl {
 
    @Autowired
    private AuthUser authenticateuser;            // This will auto-inject the authentication service into the controller.
 
    private static Logger log = Logger.getLogger(LoginCntrl.class);
    
    
    @RequestMapping(value = "/regis")  
    public ModelAndView display(ModelAndView model)  
    {  
		 customer newuser = new customer();
		 System.out.println("In /controller of /newuser...");
		 ModelAndView mv = new ModelAndView();
         mv.setViewName("Regis");
         mv.addObject("newuser",newuser); 
        return mv;  
    }
                               
    @RequestMapping(value = "/validatenewuser", method = RequestMethod.POST)
    public ModelAndView validateNewUsr(@ModelAttribute customer newuser) {
    	System.out.println("in controller");
    	ModelAndView alu = new ModelAndView();
    	String isUser = authenticateuser.addUsertodb(newuser);
        
    	System.out.println(isUser);
    	
        if(isUser.equals("AlUser"))
    	{
    		alu.setViewName("exuser");
        	return alu;
    	}
        else
    	{
    		alu.setViewName("index");
    	   	return alu;
    	}        
   }
 }