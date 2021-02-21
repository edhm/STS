package com.example.ReadingFace.Services.Implement;

import java.util.List;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.stereotype.Service;

import com.example.ReadingFace.Model.Post;

@Service("serviceDos")
public class PostServiceImplDos implements com.example.ReadingFace.Services.PostService {
	private final Log log = LogFactory.getLog(getClass());

	@Override

	public List<Post> validation(List<Post> posts) {
		log.info("Two Service");
//					System.out.println("Segundo Servicio");
		for (Post post : posts) {
			if (post.getId() == 0) {
				throw new NullPointerException("Ingresa el ID");
			}
		}
		return posts;
	}

	@Override
	public void addClass(Class clazz) {
		// TODO Auto-generated method stub
		System.out.println(clazz.getName());

	}
}
