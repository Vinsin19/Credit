
package com.charan.spring.hibernate.service;

import java.util.List;
 
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.charan.spring.hibernate.pojo.*;
 
public class AuthUser {
 
    private HibernateTemplate hibernateTemplate;
    private static Logger log = Logger.getLogger(AuthService.class);
 
    private AuthUser() { }
 
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
 
    public String addUsertodb(customer newuser) {
    	
    	String sqlQuery = "from customer u where u.first_name=? and u.last_name=? and u.gender=? and u.age=? and u.contact=? and u.uid=? and u.password=? and u.sec_que=? and u.sec_ans=?";
        // String sqlQuery = "from customer c";
        //System.out.println("In the authentication service...user entered data " + fname + " " + lname+ " " + gender+ " " + age + " " + contact + " " + uid + " " + sq + " " + sa);
         
         try {
             List<customer> userObj = (List) hibernateTemplate.find(sqlQuery,newuser.getfirst_name(),newuser.getlast_name(),newuser.getgender(),newuser.getage(),newuser.getcontact()
            		 												,newuser.getuid(),newuser.getpassword(),newuser.getsec_que(),newuser.getsec_ans());
             
             if(userObj != null && userObj.size() > 0) {
            	 return "AlUser";
             }
             else
             {
            	 hibernateTemplate.save(newuser);
            	 System.out.println(newuser);
    	
            	 status st = new status();
            	 st.setuid(newuser.getuid());
            	 st.setapp_id("N/A");
            	 st.setapp_dt("N/A");
            	 st.setstat("Not Applied");
        
            	 hibernateTemplate.save(st);
            	 
            	 return "";
            } 
          }
         catch(Exception e) {
             log.error("An error occurred while fetching the user details from the database", e);    
         }
         return "";
         }
}