package com.synchrony.rishal.valueobjects;

import java.util.Date;

/**
 * ValueObject for Login details
 * 
 * @author Rishal_singh
 *
 */
public class LoginVO {
	String userName;
	String userId;
	String userPassword;
	Date lastLoginTime;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	
}
