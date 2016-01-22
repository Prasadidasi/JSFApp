package com.jsfapp.login;

import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ViewScoped;
//import javax.faces.bean.SessionScoped;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="userLogin")
@RequestScoped
public class userLogin {
	private String UserName;
	private String PassWord;
	public String getUserName(){
		return UserName;
	}
	public String getPassWord(){
		return PassWord;
	}
	public void setUserName(String UserName){
		this.UserName=UserName;
	}
	public void setPassWord(String PassWord){
		this.PassWord=PassWord;
	}
	public String login(){
		Boolean valid = DBLogin.validate(UserName,PassWord);
		if (valid)
			return "success";
		else
			return "failure";
	}
}
