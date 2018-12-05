package com.alonso.socialnetworks.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@GenericGenerator(name = "inc", strategy = "increment")
	@GeneratedValue(generator = "inc")
	@Column(name = "Id")
	private Integer id;

	@Column(name = "name")
	private String userName;

	@Column(name = "password")
	private String password;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="users_users",
	 joinColumns=@JoinColumn(name="users_Id"),
	 inverseJoinColumns=@JoinColumn(name="friends_id")
	)
	private Set<User> friends;

	@ManyToMany
	@JoinTable(name="users_users",
	 joinColumns=@JoinColumn(name="friends_id"),
	 inverseJoinColumns=@JoinColumn(name="users_Id")
	)
	private Set<User> friendOf;

//	@OneToMany(fetch=FetchType.EAGER)
//	@JoinColumn(name="friends_id")
//	private Set<User> friends;
//
//	public Set<User> getFriends() {
//		return friends;
//	}
//
//	public void setFriends(Set<User> friends) {
//		this.friends = friends;
//	}

	public Set<User> getFriends() {
		return friends;
	}

	public void setFriends(Set<User> friends) {
		this.friends = friends;
	}

	public Set<User> getFriendOf() {
		return friendOf;
	}

	public void setFriendOf(Set<User> friendOf) {
		this.friendOf = friendOf;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
