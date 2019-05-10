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

import com.charan.spring.hibernate.pojo.*;
import com.charan.spring.hibernate.service.*;

import org.hibernate.*;
import org.hibernate.mapping.List;
 
@Component
@Controller
@RequestMapping("/user")
public class LoginCntrl {
 
    @Autowired
    private AuthService authenticateService;            // This will auto-inject the authentication service into the controller.
 
    @Autowired
    private AuthUser authenticateuser;
    
    private static Logger log = Logger.getLogger(LoginCntrl.class);
    
    public String userid=" ";
 
    // Checks if the user credentials are valid or not.
    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public String validate(@RequestParam("uid")String uid, @RequestParam("password")String password) {
        boolean isValid = authenticateService.findUser(uid, password);
        log.info("Is user valid?= " + isValid);
        System.out.println(isValid);
        System.out.println("In the controller..");
 
        if(isValid){
        	userid = uid;
        	return "Dash";
        }
        else{
        	return "result";
        }
		
    }
    
    @RequestMapping(value = "/validateuser", method = RequestMethod.POST)
    public String validateUser(@RequestParam("first_name")String first_name, @RequestParam("last_name")String last_name, @RequestParam("uid")String uid,
    								@RequestParam("sec_que")String sec_que, @RequestParam("sec_ans")String sec_ans) {
        boolean isUserValid = authenticateService.findExUser(first_name, last_name , uid , sec_que, sec_ans);
        System.out.println(isUserValid);
        System.out.println("In the controller..");
 
        if(isUserValid){
        	return "Dash";
        }
        else{
        	return "result2";
        }
		
    }
    
    @RequestMapping("/reLogin")
	public String reLogin(){
		return "index";
    }
    
    @RequestMapping("/Dashboard")
	public String reDash(){
		return "Dash";
    }
    
    @RequestMapping("/apply")
    public ModelAndView apply(){
    	ModelAndView app = new ModelAndView();
    	String stat = authenticateService.getAppStatus(userid);
    	
    	System.out.println(stat);
    	if(stat.equals("Not Applied"))
    	{
    		app.setViewName("front");
        	return app;
    	}
    	
    	else if(stat.equals("Rejected"))
    	{
    	 	app.setViewName("front");
    	   	return app;
    	}
    	
    	else
    	{
    		app.setViewName("alapp");
    	   	return app;
    	}
    }
    
    @RequestMapping("/check")
    public ModelAndView status() {

    	ModelAndView mv = new ModelAndView();
    	mv = authenticateService.getStatus(userid);
    	mv.setViewName("status");
    	mv.addObject("uid", userid);
        return mv;
    }
    
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
    @RequestMapping("/login")
    public String login(){
    	return "index";
    }
    }
