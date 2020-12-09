package com.cognixia.jump.steakhouse.dao.user;

public class User {
	
	private int user_id;
	private String username;
	private String password;
	private int is_admin;
	
	public User(int user_id, String username, String password, int is_admin) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.is_admin = is_admin;
	}

	public User(String username, String password, int is_admin) {
		super();
		this.username = username;
		this.password = password;
		this.is_admin = is_admin;
	}

	public User(String username, String password, int is_admin, int user_id) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.is_admin = is_admin;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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

	public int getIs_admin() {
		return is_admin;
	}

	public void setIs_admin(int is_admin) {
		this.is_admin = is_admin;
	}

	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", username=" + username + ", password=" + password + ", is_admin="
				+ is_admin + "]";
	}
}
