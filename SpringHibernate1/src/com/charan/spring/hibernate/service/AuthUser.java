
package com.charan.spring.hibernate.service;

import java.util.List;
 
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
 
import com.charan.spring.hibernate.pojo.customer;
 
public class AuthUser {
 
    private HibernateTemplate hibernateTemplate;
    private static Logger log = Logger.getLogger(AuthService.class);
 
    private AuthUser() { }
 
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
 
    public void addUsertodb(customer newuser) {
          
    	hibernateTemplate.save(newuser);
    	System.out.println(newuser);
            
    }
}