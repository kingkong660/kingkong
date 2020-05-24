package com.lis.pojo;

public class User {
	
	private String Id;
	private String userId;
	private String userName;
	private String userTelephone;
	private String userPassword;
	private String userPhoto;
	private String userIntroduce;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserTelephone() {
		return userTelephone;
	}
	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserPhoto() {
		return userPhoto;
	}
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
	public String getUserintroduce() {
		return userIntroduce;
	}
	public void setUserintroduce(String userintroduce) {
		this.userIntroduce = userintroduce;
	}
	
}
