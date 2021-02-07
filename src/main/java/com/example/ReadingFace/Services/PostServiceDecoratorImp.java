package com.example.ReadingFace.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ReadingFace.Model.Post;
import com.example.ReadingFace.Services.Implement.PostServiceImpl;
import com.example.ReadingFace.Services.Implement.PostServiceImplDos;

@Service("serviceDecorator")
public class PostServiceDecoratorImp implements PostService {

	@Autowired
	private PostServiceImpl postServiceImpl;

	@Autowired
	private PostServiceImplDos postServiceImplDos;

	@Override
	public List<Post> validation(List<Post> posts) {
		posts = postServiceImpl.validation(posts);
		posts = postServiceImplDos.validadtion(posts);
		for (Post post : posts) {
			if (post.getDescripcion() == null) {
				throw new NullPointerException("La descripción está vacía");
			}
			if (post.getFecha() == null) {
				throw new NullPointerException("El Id está vacía");
			}
		}
		System.out.println("Decorator Patterns");
		return posts;
	}

}
