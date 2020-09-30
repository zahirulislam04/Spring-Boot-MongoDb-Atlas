package com.project.mongodb;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.project.mongodb.model.Author;
import com.project.mongodb.model.Post;
import com.project.mongodb.model.Review;
import com.project.mongodb.repository.PostRepository;

@Component
public class DBPreLoad implements CommandLineRunner {

	@Autowired
	PostRepository repository;

	@Override
	public void run(String... args) throws Exception {

		Post techPost = new Post(
			"Spring Boot with MSSQL", "Body for Spring Boot post", 
			9, 
			5,
			new Author("Zahirul Islam", "bdsdf@gmail.com", "Frankfurt", "Germany"), 
			Arrays.asList(
				new Review("Rayhan", "Comments from Rayhan"), 
				new Review("Harry", "Comments from Harry")
			)
		);

		Post travelPost1 = new Post(
			"Visting paris", "Body for paris visit", 
			16, 
			9,
			new Author("Davis Mayhem", "dsdfs@gmail.com", "Paris", "France"),
			Arrays.asList(
					new Review("Islam", "Comments from Islam"), 
					new Review("karim", "Comments from Karim")
			)
		);

		Post travelPost2 = new Post(
			"Euro Trip", 
			"Body for Euro Trip", 
			50, 
			30,
			new Author("Miller", "msdfll@gmail.com", "Frankfurt", "Germany"),
			Arrays.asList(
					new Review("Corina", "Comments from Corina"),
					new Review("Catherin", "Comments from Catherin"),
					new Review("Michael", "Comments from Michael"), 
					new Review("Ikram", "Comments from Ikram")
			)
		);

		List<Post> posts = Arrays.asList(techPost, travelPost1, travelPost2);
		repository.deleteAll();
		repository.saveAll(posts);
	}

}
