package com.example.demo;

import java.util.*;

public class Storage {
	private static Map<String, String> users = new HashMap<String, String>();
	
	public static void add(UserInfo userInfo) {
		users.put(userInfo.getUserId(), userInfo.getGitlabAccessToken());
	}
	
	public static Map getUsers() {
		return users;
	}
}
