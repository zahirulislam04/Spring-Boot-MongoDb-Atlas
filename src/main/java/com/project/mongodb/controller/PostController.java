package com.project.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.mongodb.model.Post;
import com.project.mongodb.model.QPost;
import com.project.mongodb.repository.PostRepository;
import com.querydsl.core.types.dsl.BooleanExpression;

@RestController
@RequestMapping("/posts")
public class PostController {
	@Autowired
	PostRepository repository;
	
	// find all post
	@GetMapping
	public List<Post> getPosts(){
		return repository.findAll();
	}
	
	// create post
	@PostMapping
	public void createPost(@RequestBody Post post) {
		repository.insert(post);
	}
	
	// update post
	@PutMapping
	public void updatePost(@RequestBody Post post) {
		repository.save(post);
	}
	
	// delete post by id
	@DeleteMapping("/{id}")
	public void deletePost(@PathVariable ("id") String id) {
		repository.deleteById(id);		  
	}
	
	// find post by id
	@GetMapping("{id}")
	public Post getPostById(@PathVariable ("id") String id){
		return repository.findById(id).orElse(null);
	}
	
	// find post by title
	@GetMapping("/title/{title}")
	public Post getPostByTitle(@PathVariable ("title") String title){
		return repository.findByTitle(title);
	}
	
	
	// find post by likes
	@GetMapping("/like/{like}")
	public List<Post> getPostByLikesLessThan(@PathVariable("like") int like){
		return repository.findByLikesLessThan(like);
	}
	
	// find all post by view
	@GetMapping("/view/{view}")
	public List<Post> getPostByViewsGreaterThan(@PathVariable ("view") int view){
		return repository.findByViewsGreaterThan(view);
	}
	
	
	// find all posts where views between "from" and "to"
	@GetMapping("/view/between/{from}/{to}")
	public List<Post> getPostByViewsBetween(@PathVariable ("from") int from, @PathVariable("to") int to){
		return repository.findByViewsBetween(from, to);
	}
	
	// find all posts by country 
	@GetMapping("/country/{country}")
	public List<Post> getPostByCountry(@PathVariable("country") String country){
		// create query class for Post
		QPost post = new QPost("Post");
		
		// create filter
		BooleanExpression findByCountry = post.author.country.eq(country);
		
		// find posts by applying filter
		List<Post> posts = (List<Post>) repository.findAll(findByCountry);
		
		return posts;
	}
	
	// find popular post 
	@GetMapping("/popularpost")
	public List<Post> findPopularPost(){
		final int view = 40;
		final int like = 20;
		
		// create query class for post
		QPost post = new QPost("Post");
		
		// create two filter for like and view
		BooleanExpression filterByLike = post.likes.gt(like);
		BooleanExpression filterByView = post.views.gt(view);
		
		// apply filters
		List<Post> posts = (List<Post>) repository.findAll(filterByLike.and(filterByView));
		
		return posts;
	}
}
