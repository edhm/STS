package com.example.ReadingFace.Services.Implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ReadingFace.Model.Post;

	@Service("serviceDos")
	public class PostServiceImplDos {
			public List<Post> validadtion(List<Post> posts){
				System.out.println("Segundo Servicio");
				for(Post post: posts) {
					if(post.getId()==0) {
						throw new NullPointerException("Ingresa el ID");
					}
				}
				return posts;
			}
}

