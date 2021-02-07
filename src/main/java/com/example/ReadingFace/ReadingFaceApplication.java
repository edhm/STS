package com.example.ReadingFace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.ReadingFace.Components.PostComponent;
import com.example.ReadingFace.Model.Conexion;
import com.example.ReadingFace.Services.PostService;
//import com.example.ReadingFace.Services.PostService;

@SpringBootApplication
public class ReadingFaceApplication implements CommandLineRunner {
	@Autowired
	@Qualifier("beanConexion")
	private Conexion conexion;

	@Autowired
	@Qualifier("com.example.ReadingFace.Components.postComponent")
	public PostComponent postComponent;

	@Autowired
	@Qualifier("serviceDecorator")
	public PostService postService;

	public static void main(String[] args) {
		SpringApplication.run(ReadingFaceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			postService.validation(postComponent.getPosts()).forEach((post) -> {
				System.out.println(post.getTitulo());
			});
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
