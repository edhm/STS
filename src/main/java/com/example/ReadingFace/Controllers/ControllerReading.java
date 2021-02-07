package com.example.ReadingFace.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.ReadingFace.Components.PostComponent;
import com.example.ReadingFace.Configuration.Paginas;
import com.example.ReadingFace.Model.Post;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/home")
public class ControllerReading {

	/*
	 * public List<Post> getPosts(){
		ArrayList<Post> post=new ArrayList();
		post.add(new Post(1,"Aplicación de las capas: Aplicación Escritorio, Data Access Layer, Business Layer, APIs REST","http://localhost:8080/img/asw.jpeg",new Date(),"Enterprise Solutions Architecture"));
		post.add(new Post(2,"Aplicación de las capas: Aplicación Escritorio, Data Access Layer, Business Layer, APIs REST","http://localhost:8080/img/net.png",new Date(),"Net Business Architect"));
		post.add(new Post(3,"Aplicación de las capas: Aplicación Escritorio, Data Access Layer, Business Layer, APIs REST","http://localhost:8080/img/java.png",new Date(),"Java Business Architect"));
		post.add(new Post(4,"Aplicación de las capas: Aplicación Escritorio, Data Access Layer, Business Layer, APIs REST","http://localhost:8080/img/microservices.png",new Date(),"Microservices Architecture"));
		return post;
	}
	 * Se agregó 
	 * @Autowire
	 * private PostComponent
	 * */

	@Autowired
	private PostComponent _postComponent;
	
	@GetMapping(path={"/posts","/"})
	public String saludar(Model model) {
		model.addAttribute("posts",this._postComponent.getPosts());
		return "index";
	}
	
	
	/*
	 * //
	@GetMapping(path="/post")
	public ModelAndView getPostIndicidual(
			@RequestParam(defaultValue="1",name="id", required=false) int id
			) {
		ModelAndView modelAndView=new ModelAndView(Paginas.POST);
		List<Post> postfiltrado = this.getPosts().stream()
							.filter( (p)->{
								return p.getId()==id;
							}).collect(Collectors.toList() );
		modelAndView.addObject("post", postfiltrado.get(0));
		return modelAndView;
	}
	
	 * */
	

	@GetMapping(path= {"/post","/post/p/{post}"})
	public ModelAndView getPostIndicidual(
			@PathVariable(required=true, name="post") int id
			) {
		ModelAndView modelAndView=new ModelAndView(Paginas.POST);
		List<Post> postfiltrado = this._postComponent.getPosts()
							.stream()
							.filter( (p)->{
								return p.getId()==id;
							}).collect(Collectors.toList() );
		modelAndView.addObject("post", postfiltrado.get(0));
		return modelAndView;
	}
	
	@GetMapping("/postNew")
	public ModelAndView getForm() {
		return new ModelAndView("form").addObject("post", new Post());
	}
	
	@PostMapping(path= {"/addNewPost","/"})//sustituible SGDbase
	public String addNewPost(Post post,Model model) {
		List<Post> posts=this._postComponent.getPosts();
		posts.add(post);
		model.addAttribute("posts", posts);
		return "index";
	}
}
