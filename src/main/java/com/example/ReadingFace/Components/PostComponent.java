package com.example.ReadingFace.Components;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.ReadingFace.Model.Post;

@Component("com.example.ReadingFace.Components.postComponent")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PostComponent {
	public List<Post> getPosts() {
		ArrayList<Post> post = new ArrayList<>();
		post.add(new Post(1,
				"Aplicación de las capas: Aplicación Escritorio, Data Access Layer, Business Layer, APIs REST",
				"http://localhost:8080/img/asw.jpeg", new Date(), "Enterprise Solutions Architecture"));
		post.add(new Post(2,
				"Aplicación de las capas: Aplicación Escritorio, Data Access Layer, Business Layer, APIs REST",
				"http://localhost:8080/img/net.png", new Date(), "Net Business Architect"));
		post.add(new Post(3,
				"Aplicación de las capas: Aplicación Escritorio, Data Access Layer, Business Layer, APIs REST",
				"http://localhost:8080/img/java.png", new Date(), "Java Business Architect"));
		post.add(new Post(4,
				"Aplicación de las capas: Aplicación Escritorio, Data Access Layer, Business Layer, APIs REST",
				"http://localhost:8080/img/microservices.png", new Date(), "Microservices Architecture"));
		return post;
	}
}
