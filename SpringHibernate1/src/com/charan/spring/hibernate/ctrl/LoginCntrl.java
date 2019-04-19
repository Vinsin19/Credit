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
import com.charan.spring.hibernate.service.AuthService;
import org.hibernate.*;
import org.hibernate.mapping.List;
 
@Component
@Controller
@RequestMapping("/user")
public class LoginCntrl {
 
    @Autowired
    private AuthService authenticateService;            // This will auto-inject the authentication service into the controller.
 
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
    public String validateUser(@RequestParam("first_name")String first_name, @RequestParam("last_name")String last_name, @RequestParam("gender")String gender 
    							,@RequestParam("age")int age, @RequestParam("contact")long contact, @RequestParam("uid")String uid,
    							@RequestParam("password")String password,@RequestParam("sec_que")String sec_que, @RequestParam("sec_ans")String sec_ans) {
        boolean isUserValid = authenticateService.findExUser(first_name, last_name, gender , age, contact , uid , password, sec_que, sec_ans);
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
    
    @RequestMapping("/apply")
    public String apply(){
    	return "front";
    }
    
    @RequestMapping("/check")
    public ModelAndView status() {
        
        
    	
    	ModelAndView mv = new ModelAndView();
    	mv = authenticateService.getStatus(userid);
    	mv.setViewName("status");
    	mv.addObject("uid", userid);
        mv.addObject("stat",appst);
        return mv;
    }
    
    }
