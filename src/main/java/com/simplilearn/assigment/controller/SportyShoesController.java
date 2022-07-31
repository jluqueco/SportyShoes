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
	
	
	
	@GetMapping(path="/users/products/showFormForAdd")
	public ModelAndView showFormForAddProducts() {
		System.out.println("Entering showFormForAddProducts");
		ModelAndView modelAndView = new ModelAndView("products-form");
		
		Product theProduct = new Product();
		
		modelAndView.addObject("products", theProduct);
		
		return modelAndView;
	}
	
	@PostMapping(path="users/products/saveProducts")
	public ModelAndView saveProduct(@ModelAttribute("products") Product theProduct) {
		System.out.println("Entering saveProduct with " + theProduct);
		ModelAndView modelAndView = new ModelAndView("redirect:/users/products");
		
		restTemplate.postForObject("http://localhost:8080/users/newproduct", theProduct, Product.class);
		
		return modelAndView;
	}
	
	@GetMapping(path="/users/users/showFormForAdd")
	public ModelAndView showFormForAddUsers() {
		System.out.println("Entering showFormForAddUsers");
		ModelAndView modelAndView = new ModelAndView("users-form");
		
		User theUser= new User();
		
		modelAndView.addObject("users", theUser);
		
		return modelAndView;
	}
	
	@PostMapping(path="/users/users/saveUsers")
	public ModelAndView saveUser(@ModelAttribute("users") User theUser) {
		System.out.println("Entering saveUser with " + theUser);
		ModelAndView modelAndView = new ModelAndView("redirect:/users/users");
		
		restTemplate.postForObject("http://localhost:8080/users/newuser", theUser, User.class);
		
		return modelAndView;
	}
	
	@GetMapping(path="/users/categories/showFormForAdd")
	public ModelAndView showFormForAddCategories() {
		System.out.println("Entering showFormForAddCategories");
		ModelAndView modelAndView = new ModelAndView("categories-form");
		
		Category theCategory= new Category();
		
		modelAndView.addObject("categories", theCategory);
		
		return modelAndView;
	}
	
	@PostMapping(path="/users/categories/saveCategories")
	public ModelAndView saveCategory(@ModelAttribute("categories") Category theCategory) {
		System.out.println("Entering saveCategory with " + theCategory);
		ModelAndView modelAndView = new ModelAndView("redirect:/users/categories");
		
		restTemplate.postForObject("http://localhost:8080/users/newcategory", theCategory, Category.class);
		
		return modelAndView;
	}
	
	
	@GetMapping(path="/users/categories/showFormForUpdate")
	public ModelAndView showFormForUpdateCategories(@RequestParam("categoryId") Long theId, Model theModel) {
		System.out.println("Entering showFormForUpdateCategory");
		
		Map<String, Long> params = new HashMap<>();
		params.put("theId", theId);
		
		Category theCategory = restTemplate.getForObject("http://localhost:8080/users/jluqueco/categories" + "/{theId}", Category.class, params);
		theModel.addAttribute("categories", theCategory);
		return new ModelAndView("categories-form");
	}
	
	@GetMapping(path="/users/categories/delete")
	public ModelAndView deleteCategories(@RequestParam("categoryId") Long theId) {
		System.out.println("Entering deleteCategories");
		
		Map<String, Long> params = new HashMap<>();
		params.put("theId", theId);
		
		restTemplate.delete("http://localhost:8080/users/jluqueco/categories"  + "/{theId}", params);
		
		return listOfCategories();
		
	}
	
	@GetMapping(path="/users/products/showFormForUpdate")
	public ModelAndView showFormForUpdateProducts(@RequestParam("productId") Long theId, Model theModel) {
		System.out.println("Entering showFormForUpdateProduct");
		
		Map<String, Long> params = new HashMap<>();
		params.put("theId", theId);
		
		Product theProduct = restTemplate.getForObject("http://localhost:8080/users/jluqueco/products" + "/{theId}", Product.class, params);
		theModel.addAttribute("products", theProduct);
		return new ModelAndView("products-form");
	}
	
	@GetMapping(path="/users/products/delete")
	public ModelAndView deleteProducts(@RequestParam("productId") Long theId) {
		System.out.println("Entering deleteProducts");
		
		Map<String, Long> params = new HashMap<>();
		params.put("theId", theId);
		
		restTemplate.delete("http://localhost:8080/users/jluqueco/products"  + "/{theId}", params);
		
		return listOfProducts();
		
	}
	
	@GetMapping(path="/users/users/showFormForUpdate")
	public ModelAndView showFormForUpdateUser(@RequestParam("userId") Long theId, Model theModel) {
		System.out.println("Entering showFormForUpdateUser");
		
		Map<String, Long> params = new HashMap<>();
		params.put("theId", theId);
		
		User theUser = restTemplate.getForObject("http://localhost:8080/users/jluqueco/users" + "/{theId}", User.class, params);
		theModel.addAttribute("users", theUser);
		return new ModelAndView("users-form");
	}
	
	@GetMapping(path="/users/categories/delete")
	public ModelAndView deleteUsers(@RequestParam("userId") Long theId) {
		System.out.println("Entering deleteUsers");
		
		Map<String, Long> params = new HashMap<>();
		params.put("theId", theId);
		
		restTemplate.delete("http://localhost:8080/users/jluqueco/users"  + "/{theId}", params);
		
		return listOfUsers();
		
	}
		
}
