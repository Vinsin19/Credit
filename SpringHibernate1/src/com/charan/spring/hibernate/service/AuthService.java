
package com.charan.spring.hibernate.service;

import java.util.*;
import java.text.*;
import java.time.*;
import org.hibernate.*; 
import org.apache.log4j.Logger;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.charan.spring.hibernate.pojo.*;
 
public class AuthService {
	 
    private HibernateTemplate hibernateTemplate;
    private static Logger log = Logger.getLogger(AuthService.class);
 
    private AuthService() { }
 
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
    
    Date dt = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddhhmmss");
    
    
 
    @SuppressWarnings( { "unchecked", "deprecation" } )
    public boolean findUser(String uid, String upwd) {
        log.info("Checking the user in the database");
        boolean isValidUser = false;
       // String sqlQuery = "from User where name='"+ uid + "' and password='"+ upwd+"'";
        String sqlQuery = "from customer u where u.uid=? and u.password=?";
       // String sqlQuery = "from customer c";
        System.out.println("In the authentication service...user entered data " + uid + " pwd "+upwd);
        
        try {
            List<customer> userObj = (List) hibernateTemplate.find(sqlQuery,uid,upwd);
        	// List<customer> userObj = (List) hibernateTemplate.find(sqlQuery);
           
        	 
       System.out.println();  	 
            
            if(userObj != null)
            {
            	System.out.println("userObject is not null... ");
            }
            if(userObj != null && userObj.size() > 0) {
                isValidUser = true;
            }
        } catch(Exception e) {
            isValidUser = false;
            log.error("An error occurred while fetching the user details from the database", e);    
        }
        return isValidUser;
    }
    
    @SuppressWarnings({ "deprecation", "unchecked" })
	public boolean findExUser(String fname, String lname, String gender, int age, long contact, String uid, String pwd, String sq, String sa) {
        log.info("Checking the existing user in the database");
        boolean isValidUser = false;
        String sqlQuery = "from customer u where u.first_name=? and u.last_name=? and u.gender=? and u.age=? and u.contact=? and u.uid=? and u.password=? and u.sec_que=? and u.sec_ans=?";
        // String sqlQuery = "from customer c";
         System.out.println("In the authentication service...user entered data " + fname + " " + lname+ " " + gender+ " " + age + " " + contact + " " + uid + " " + pwd + " " + sq + " " + sa);
         
         try {
             List<customer> userObj = (List) hibernateTemplate.find(sqlQuery,fname,lname,gender,age,contact,uid,pwd,sq,sa);
             
         	// List<customer> userObj = (List) hibernateTemplate.find(sqlQuery);
            
         	 
        System.out.println(userObj);  	 
             
             if(userObj != null && userObj.size() > 0) {
                 isValidUser = true;       
                 
                 status st = new status();
                 st.setuid(uid);
                 String DateTime = sdf.format(dt);
                 st.setapp_id(DateTime);
                 st.setapp_dt(dt.toString());
                 st.setstat("Submitted");
                 
                 hibernateTemplate.save(st);
                 
             }
         } catch(Exception e) {
             isValidUser = false;
             log.error("An error occurred while fetching the user details from the database", e);    
         }
         return isValidUser;
    }
    
    public ModelAndView getStatus(String uid)
    {
       Session session = hibernateTemplate.getSessionFactory().openSession();
       String sqlQuery1="from status where uid=? order by app_id desc";
       session.beginTransaction();
       Query q=session.createQuery(sqlQuery1);      
       q.setParameter(0, uid);
       List result=q.list();
       //String status="";
       /*for(int i=0;i<result.size();i++)
       {
              status=(String)result.get(0);
              
       }
       return status;*/
     
       List<status> resultStatusList=q.list();
       //for(int i=0;i<result.size();i++)
       status statusObjFirstRecord = resultStatusList.get(0);
       //for (status statusObj : resultStatusList)
      // {
       ModelAndView gs = new ModelAndView();
       gs.addObject("appid", statusObjFirstRecord.getapp_id());  
       gs.addObject("appdt", statusObjFirstRecord.getapp_dt());
       gs.addObject("appst", statusObjFirstRecord.getstat());
       
       System.out.println("Data : " + statusObjFirstRecord.getapp_id() + " "+ statusObjFirstRecord.getapp_dt()  + " " + statusObjFirstRecord.getstat());
              
       //}
       //request.getSession().setAttribute("Status", stat);  
       return gs;
       
        
    }

    
    
    
}