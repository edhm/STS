package com.example.ReadingFace;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.ReadingFace.Components.PostComponent;
import com.example.ReadingFace.Model.Conexion;
import com.example.ReadingFace.Services.PostService;

//import com.example.ReadingFace.Services.PostService;

@SpringBootApplication
public class ReadingFaceApplication implements CommandLineRunner {
	/*
	 * @Autowired
	 * 
	 * @Qualifier("beanConexion") private Conexion conexion;
	 * 
	 * @Autowired
	 * 
	 * @Qualifier("com.example.ReadingFace.Components.postComponent") public
	 * PostComponent postComponent;
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	 * @Autowired
	 * 
	 * @Qualifier("serviceDecorator") public PostService postService;
	 */

	public PostService postService;

	public ReadingFaceApplication() {
	}

	/*
	 * public PostService getPostService() { return postService; }
	 */

	/*
	 * @Autowired public void ReadingFaceApplication(@Qualifier("serviceDecorator")
	 * PostService postService) { this.postService = postService;
	 * 
	 * }
	 * 
	 * public static void main(String[] args) {
	 * SpringApplication.run(ReadingFaceApplication.class, args); }
	 */
	public static void main(String[] args) {
		SpringApplication.run(ReadingFaceApplication.class, args);
	}

	public void run(String... args) throws Exception {
		jdbcTemplate.execute("");	
	}

	/*
	 * @Override public void run(String... args) throws Exception { Log log =
	 * LogFactory.getLog(getClass()); // Log log = LogFactory.getLog(getClass());
	 * 
	 * try { postService.validation(postComponent.getPosts()).forEach((post) -> {
	 * log.info(post.getTitulo()); // System.out.println(post.getTitulo()); }); }
	 * catch (Exception e) { log.error(e); // System.out.println(e.getMessage()); }
	 * }
	 */
}
