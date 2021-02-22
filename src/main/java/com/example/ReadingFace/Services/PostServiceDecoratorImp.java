package com.example.ReadingFace.Services;

import java.util.List;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.ReadingFace.Model.Post;
import com.example.ReadingFace.Services.Implement.PostServiceImpl;
import com.example.ReadingFace.Services.Implement.PostServiceImplDos;

@Service("serviceDecorator")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class PostServiceDecoratorImp implements PostService {
	private final Log log = LogFactory.getLog(getClass());
	@Autowired
	private PostServiceImpl postServiceImpl;

	@Autowired
	private PostServiceImplDos postServiceImplDos;

	@Override
	public List<Post> validation(List<Post> posts) {
		log.debug(posts);
		//
		posts = postServiceImpl.validation(posts);
		posts = postServiceImplDos.validation(posts);
		for (Post post : posts) {
			if (post.getDescripcion() == null) {

				throw new NullPointerException("La descripción está vacía");
			}
			if (post.getFecha() == null) {
				throw new NullPointerException("La fecha está vacía");
			}
		}

		// System.out.println("Decorator Patterns");
		return posts;
	}

	@Override
	public void addClass(Class clazz) {
		System.out.println("Class Clazz\n" + clazz.getName());

	}

}
