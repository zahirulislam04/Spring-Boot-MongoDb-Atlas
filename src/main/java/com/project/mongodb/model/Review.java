package com.project.mongodb.model;

public class Review {
	private String user;
	private String comments;
	public Review(String user, String comments) {
		super();
		this.user = user;
		this.comments = comments;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Review [user=" + user + ", comments=" + comments + "]";
	}
	
	
}
