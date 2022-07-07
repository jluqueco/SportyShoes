package com.simplilearn.assigment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.assigment.model.Category;
import com.simplilearn.assigment.model.Product;
import com.simplilearn.assigment.model.User;

@Controller
public class SportyShoesController {
	private static final String BASE_URL = "http://localhost:8080/users/jluqueco/"; //users/jluqueco/products
	
	private RestTemplate restTemplate;
	
	@Autowired
	public SportyShoesController(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}
	
	@GetMapping(path="/users/products")
	public ModelAndView listOfProducts() {
		ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(BASE_URL+"products", HttpMethod.GET,null,new ParameterizedTypeReference<List<Product>>() {
		});
		
		List<Product> products= responseEntity.getBody();
		
		ModelAndView modelAndView = new ModelAndView("list-products");
		
		modelAndView.addObject("products",products);
		
		return modelAndView;
	}
	
	@GetMapping(path="/users/categories")
	public ModelAndView listOfCategories() {
		ResponseEntity<List<Category>> responseEntity = restTemplate.exchange(BASE_URL+"categories", HttpMethod.GET,null,new ParameterizedTypeReference<List<Category>>() {
		});
		
		List<Category> categories= responseEntity.getBody();
		System.out.println("Controller Categories: " + categories);
		ModelAndView modelAndView = new ModelAndView("list-categories");
		
		modelAndView.addObject("categories",categories);
		
		return modelAndView;
	}
	
	@GetMapping(path="/users/users")
	public ModelAndView listOfUsers() {
		ResponseEntity<List<User>> responseEntity = restTemplate.exchange(BASE_URL+"users", HttpMethod.GET,null,new ParameterizedTypeReference<List<User>>() {
		});
		
		List<User> users = responseEntity.getBody();
		
		ModelAndView modelAndView = new ModelAndView("list-users");
		
		modelAndView.addObject("users",users);
		
		return modelAndView;
	}
	
//	@GetMapping(path="/users/todos/showFormForAdd")
//	public ModelAndView showFormForAddTodos() {
//		System.out.println("Entering showFormForAddTodos");
//		ModelAndView modelAndView = new ModelAndView("todos-form");
//		
//		Todo theTodo = new Todo();
//		
//		modelAndView.addObject("todos", theTodo);
//		
//		return modelAndView;
//	}
//	
//	@PostMapping(path="/users/todos/saveTodos")
//	public ModelAndView saveTodo(@ModelAttribute("todos") Todo theTodo) {
//		System.out.println("Entering saveTodo");
//		ModelAndView modelAndView = new ModelAndView("redirect:/users/todos");
//		theTodo.setUsername("vinodh");
//		restTemplate.postForObject(BASE_URL, theTodo, Todo.class);
//		
//		return modelAndView;
//	}
//	
//	@GetMapping(path="/users/todos/showFormForUpdate")
//	public ModelAndView showFormForUpdateTodos(@RequestParam("todoId") Long theId, Model theModel) {
//		System.out.println("Entering showFormForUpdateTodos");
//		
//		Map<String, Long> params = new HashMap<>();
//		params.put("theId", theId);
//		
//		Todo theTodo = restTemplate.getForObject(BASE_URL + "/{theId}", Todo.class, params);
//		theModel.addAttribute("todos", theTodo);
//		return new ModelAndView("todos-form");
//	}
//	
//	@GetMapping(path="/users/todos/delete")
//	public ModelAndView deleteTodos(@RequestParam("todoId") Long theId) {
//		System.out.println("Entering deleteTodos");
//		
//		Map<String, Long> params = new HashMap<>();
//		params.put("theId", theId);
//		
//		restTemplate.delete(BASE_URL + "/{theId}", params);
//		
//		ResponseEntity<List<Todo>> responseEntity = restTemplate.exchange(BASE_URL, HttpMethod.GET,null,new ParameterizedTypeReference<List<Todo>>() {
//		});
//		
//		List<Todo> todos = responseEntity.getBody();
//		
//		ModelAndView modelAndView = new ModelAndView("list-todos");
//		
//		modelAndView.addObject("todos",todos);
//		
//		return modelAndView;
//	}
		
}
