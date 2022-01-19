package com.example.demo.domain;

public class UserDto {
	private Long id;
	private String userName;
	private String userId;
	private String userPassword;
	private String userEmail;
	private String userAddDate;
	private String userDeleteDate;
	private String userDeleteChk;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserAddDate() {
		return userAddDate;
	}
	public void setUserAddDate(String userAddDate) {
		this.userAddDate = userAddDate;
	}
	public String getUserDeleteDate() {
		return userDeleteDate;
	}
	public void setUserDeleteDate(String userDeleteDate) {
		this.userDeleteDate = userDeleteDate;
	}
	public String getUserDeleteChk() {
		return userDeleteChk;
	}
	public void setUserDeleteChk(String userDeleteChk) {
		this.userDeleteChk = userDeleteChk;
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", userName=" + userName + ", userId=" + userId + ", userPassword=" + userPassword
				+ ", userEmail=" + userEmail + ", userAddDate=" + userAddDate + ", userDeleteDate=" + userDeleteDate
				+ ", userDeleteChk=" + userDeleteChk + "]";
	}
	
	

}
