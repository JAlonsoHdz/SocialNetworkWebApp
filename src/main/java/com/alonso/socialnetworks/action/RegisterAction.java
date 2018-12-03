package com.alonso.socialnetworks.action;

import org.apache.commons.lang3.StringUtils;

import com.alonso.socialnetworks.dao.UserDAO;
import com.alonso.socialnetworks.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport{
	
	private User user;
	
	@Override
	public void validate() {
		UserDAO dao = new UserDAO();
		
		
		if (StringUtils.isEmpty((user.getUserName()))) {
			addFieldError("user.userName", "Username Cannot be blank");
			return;
		}
		
		if (StringUtils.isEmpty((user.getPassword()))) {
			addFieldError("user.password", "Password Cannot be blank");
			return;
		}
		
//		if (StringUtils.isEmpty(password)) {
//			addFieldError("password", "Password cannot be blank");
//			return;
//		}
		
//		if (user.getUserName().equals(users.get(0).getUserName())) {
//			addFieldError("name", "User already exist!");
//			return;
//		}
		
		if(!dao.getUserByName(user.getUserName()).isEmpty()) {
			addFieldError("user.userName", "User Already Exists");
			return;
		}
		
		if(user.getUserName().length() > 64) {
			addFieldError("user.userName", "Username too long");
			return;
		}
		
		if(user.getPassword().length() > 64) {
			addFieldError("user.password", "Username too long");
			return;
		}
		
		dao.close();
		
		
	}
	
	@Override
	public String execute() {
		UserDAO dao = new UserDAO();
		dao.insertUser(user);
		dao.close();
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	
	
	
	
}
