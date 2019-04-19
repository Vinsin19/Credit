package com.charan.spring.hibernate.pojo;
 
import java.io.Serializable;
 

public class customer implements Serializable {
 
	private int id;
	private int age;
    private long contact;
    private String uid, password, first_name, last_name, gender, sec_que, sec_ans;
 
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
    public String getuid() {
        return uid;
    }
 
    public void setuid(String uid) {
        this.uid = uid;
    }
    
    public String getpassword() {
        return password;
    }
 
    public void setpassword(String password) {
        this.password = password;
    }
    
    public String getfirst_name() {
        return first_name;
    }
 
    public void setfirst_name(String first_name) {
        this.first_name = first_name;
    }
    
    public String getlast_name() {
        return last_name;
    }
 
    public void setlast_name(String last_name) {
        this.last_name = last_name;
    }
    
    public String getgender() {
        return gender;
    }
 
    public void setgender(String gender) {
        this.gender = gender;
    }
    
    public int getage() {
        return age;
    }
 
    public void setage(int age) {
        this.age = age;
    }
    
    public long getcontact() {
        return contact;
    }
 
    public void setcontact(long contact) {
        this.contact = contact;
    }
    
    public String getsec_que() {
        return sec_que;
    }
 
    public void setsec_que(String sec_que) {
        this.sec_que = sec_que;
    }
    
    public String getsec_ans() {
        return sec_ans;
    }
 
    public void setsec_ans(String sec_ans) {
        this.sec_ans = sec_ans;
    }
}