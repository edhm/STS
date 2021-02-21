package com.example.ReadingFace.Services.Implement;

import java.util.List;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.stereotype.Service;

import com.example.ReadingFace.Model.Post;
import com.example.ReadingFace.Services.PostService;

@Service
public class PostServiceImpl implements com.example.ReadingFace.Services.PostService {
	private final Log log = LogFactory.getLog(getClass());
	public List<Post> validation(List<Post> posts) {
		
		log.info("One Service");
		// System.out.println("Primer Servicio");
		for (Post post : posts) {
			if (post.getTitulo() == null) {
				throw new NullPointerException("Ingresar el Título");
			}
		}
		return posts;
	}

	//
	//
	@Override
	public void addClass(Class clazz) {
		// TODO Auto-generated method stub

	}
}
