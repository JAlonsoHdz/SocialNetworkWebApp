package com.alonso.socialnetworks.action;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.SessionFactory;

import com.alonso.socialnetworks.dao.UserDAO;
import com.alonso.socialnetworks.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class AddFriendsAction extends ActionSupport implements SessionAware {
	
	private Map<String, Object> userSession;	
	private String name;
	
	
	public void validate() {
		
		
		if (StringUtils.isEmpty(name)) {
			addFieldError("name", "Name cannot be blank");
			return;
		}
		
		UserDAO dao = new UserDAO();
		List<User> users = dao.getUserByName(name);
		User currentSession = (User) userSession.get("user");		
		System.out.println(users.size());
		
		System.out.println(currentSession.getUserName()+" currentSession");
		
		 try
	        { 
			 System.out.println(users.get(0).getUserName()+" users");
	        } 
	        catch(IndexOutOfBoundsException e) 
	        { 
	            addFieldError("name", "User doesn't exist exception handling!");
	        } 
		
		
		if (users.isEmpty()) {
			addFieldError("name", "User doesn't exist");
			return;
		}
		
		//Compares current session with friends captured from add friends form
		if (currentSession.getUserName().equals(users.get(0).getUserName())) {
			addFieldError("name", "You cannot add yourself dork!");
			return;
		}
		
//		for (User u: currentSession.getFriends()){
//			if (u.getUserName().equals(users.get(0).getUserName())) {
//				addFieldError("name", "this is already a friend of you!");
//				return;
//			}			
//		}
		
		dao.close();
		
	}
	
	public String execute() {
		UserDAO dao = new UserDAO();
		
		List<User> users = dao.getUserByName(name);
		
		User currentSession = (User) userSession.get("user");
		Set <User> friends = currentSession.getFriends();
		friends.add(users.get(0));
		currentSession.setFriends(friends);
		
		System.out.println(friends+" execute method");

		dao.update(currentSession);		
		dao.close();				
		return SUCCESS;
	}
	
	public AddFriendsAction() {
		super();
	}
	
	public AddFriendsAction(SessionFactory session, Map<String, Object> userSession, String name) {
		super();
		this.userSession = userSession;
		this.name = name;
	}

	public Map<String, Object> getUserSession() {
		return userSession;
	}

	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.userSession = session;
		
	}
	
	
}
