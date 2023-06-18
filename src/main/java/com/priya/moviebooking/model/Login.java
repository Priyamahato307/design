package com.priya.moviebooking.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document(collection="Login")
@Component
public class Login {

@Id
private String customerId;
	private String email;
	private String password;
	private boolean loginStatus;
	
	public Login() {
		super();
	}
	public Login(String customerId,String email, String password, boolean loginStatus) {
		super();
		this.customerId=customerId;
		this.email = email;
		this.password = password;
		this.loginStatus = loginStatus;
	}
	

	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(boolean loginStatus) {
		this.loginStatus = loginStatus;
	}
	@Override
	public String toString() {
		return "Login [customerId=" + customerId + ", email=" + email + ", password=" + password + ", loginStatus="
				+ loginStatus + "]";
	}
}
