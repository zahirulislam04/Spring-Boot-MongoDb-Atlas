package com.project.mongodb.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.querydsl.core.annotations.QueryEntity;

@QueryEntity
@Document(collection = "posts")
public class Post {
	@Id
	private String id;
	
	@Indexed(direction = IndexDirection.ASCENDING)
	private String title;
	private String body;
	private int views;
	private int likes;
	private Author author;
	private List<Review> reviews;
		
	public Post(String title, String body, int views, int likes, Author author, List<Review> reviews) {
		this.title = title;
		this.body = body;
		this.views = views;
		this.likes = likes;
		this.author = author;
		this.reviews = reviews;
}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", body=" + body + ", views=" + views + ", likes=" + likes
				+ ", author=" + author + ", reviews=" + reviews + "]";
	}
	
	
}
