package com.example.demo;

public class UserInfo {
	
	private String userId;
	private String gitlabAccessToken;
	
	public UserInfo(String userId, String gitlabAccessToken) {
		this.userId = userId;
		this.gitlabAccessToken = gitlabAccessToken;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public String getGitlabAccessToken() {
		return gitlabAccessToken;
	}
	
	public void setUserID(String userId) {
		this.userId = userId;
	}
	
	public void setGitlabAccessToken(String gitlabAccessToken) {
		this.gitlabAccessToken = gitlabAccessToken;
	}
	
}
