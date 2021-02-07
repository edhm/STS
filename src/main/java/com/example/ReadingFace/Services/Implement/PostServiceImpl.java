package com.example.ReadingFace.Services.Implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ReadingFace.Model.Post;
//import com.example.ReadingFace.Services.PostService;

@Service
public class PostServiceImpl implements com.example.ReadingFace.Services.PostService {

	public List<Post> validation(List<Post> posts) {
		System.out.println("Primer Servicio");
		for(Post post: posts) {
			if(post.getTitulo()==null) {
				throw new NullPointerException("Ingresar el Título");
			}
		}
		return posts;
	}
}

