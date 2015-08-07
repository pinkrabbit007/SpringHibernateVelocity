package shiyanlou.test.hibernate.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import shiyanlou.test.hibernate.controller.HomeController;

public class User {

    private int id;
    private String username;
    private String password;

	private String phonenum;
    private String IDcard;

	private String granted;
	
	private static final Logger logger = LoggerFactory.getLogger(User.class);
    
    public String getGranted() {
		return granted;
	}
	public void setGranted(String granted) {
		this.granted = granted;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getIDcard() {
		return IDcard;
	}
	public void setIDcard(String iDcard) {
		IDcard = iDcard;
	}
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}