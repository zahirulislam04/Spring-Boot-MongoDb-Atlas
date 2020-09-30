package com.project.mongodb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
//import org.springframework.data.mongodb.repository.Query;
//import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import com.project.mongodb.model.Post;


@Repository
public interface PostRepository extends MongoRepository<Post, String>, QuerydslPredicateExecutor<Post> {
	Optional<Post> findById(String id);
	Post findByTitle(String title);	
	List<Post> findByTitleLike(String title);
	List<Post> findByLikesLessThan(int like);	
	List<Post> findByViewsGreaterThan(int view);
	List<Post> findByViewsBetween(int from, int to);
	
//	@Query("{'author.country': ?0}")
//	List<Post> findByAuthorCountry(String country);
}
