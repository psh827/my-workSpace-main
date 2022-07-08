package com.varxyz.jv300.foodService.domain;

import java.util.List;

public class User {
	private String userId;
	private String passwd;
	private String nickname;
	private int point;
	private String grade;
	private List<Restaurant> saveResList;
	private Search search;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public List<Restaurant> getSaveResList() {
		return saveResList;
	}
	public void setSaveResList(List<Restaurant> saveResList) {
		this.saveResList = saveResList;
	}
	public Search getSearch() {
		return search;
	}
	public void setSearch(Search search) {
		this.search = search;
	}

	
	
}
