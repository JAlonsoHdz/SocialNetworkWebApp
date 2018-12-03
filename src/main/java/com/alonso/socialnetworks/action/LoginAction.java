package com.alonso.socialnetworks.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.alonso.socialnetworks.dao.UserDAO;
import com.alonso.socialnetworks.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {	
	
	private User user;
	private Map<String, Object> userSession;	
	
	public Map<String, Object> getUserSession() {
		return userSession;
	}

	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}

	@Override
	public void validate () {
		if (StringUtils.isEmpty((user.getUserName()))) {
			addFieldError("user.userName", "Username Cannot be blank");
			return;
		}
		
		UserDAO dao = new UserDAO();
			List<User> users = dao.getUserByName(user.getUserName());
			
		if (users.isEmpty()) {
			addFieldError("user.password", "User not found");
			return;
		}
		
		if (!users.get(0).getPassword().equals(user.getPassword())) {																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																															
			addFieldError("user.password", "Password doesn't match");
			return;
		}		
		
		this.user = users.get(0);
		userSession.put("user", this.user);
		dao.close();
		
//		dao.insertUser(user);
		
	}
	
	@Override
	public String execute(){
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
		
		
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.userSession = session;
		
	}
}
