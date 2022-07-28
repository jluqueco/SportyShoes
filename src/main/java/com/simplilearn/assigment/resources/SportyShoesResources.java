package com.simplilearn.assigment.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.simplilearn.assigment.model.Category;
import com.simplilearn.assigment.model.Product;
import com.simplilearn.assigment.model.User;
import com.simplilearn.assigment.service.CategoryService;
import com.simplilearn.assigment.service.ProductService;
import com.simplilearn.assigment.service.UserService;


@RestController
public class SportyShoesResources {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path = "/users/{username}/products")
	public List<Product> getAllProducts(@PathVariable String username){
		List<Product> products = productService.findAll();
		System.out.println("Username: " + username + " Method: getAllProducts()");
		System.out.println(products);
		return products;
	}
	
	@GetMapping(path = "/users/{username}/categories")
	public List<Category> getAllCategories(@PathVariable String username){
		List<Category> categories = categoryService.findAll();
		System.out.println("Username: " + username + " Method: getAllCategories()");
		System.out.println(categories);
		return categories;
	}
	
	@GetMapping(path = "/users/{username}/users")
	public List<User> getAllUsers(@PathVariable String username){
		List<User> users = userService.findAll();
		System.out.println("Username: " + username + " Method: getAllUsers()");
		System.out.println(users);
		return users;
	}
	
	@PostMapping(path = "/users/{username}")
	public ResponseEntity createUser(@PathVariable String username, @Valid @RequestBody User theUser) {
		System.out.println("creating user: " + theUser.getUserID());
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userService.save(theUser).getUserID()).toUri();
		
		System.out.println(location.toString());
		
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping(path = "/users/newproduct")
	public ResponseEntity createProduct(@Valid @RequestBody Product theProduct) {
		System.out.println("creating Product: " + theProduct.getCategory());
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(productService.save(theProduct).getID()).toUri();
		
		System.out.println(location.toString());
		
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping(path = "/users/newuser")
	public ResponseEntity createUser(@Valid @RequestBody User theUser) {
		System.out.println("creating User: " + theUser.getName());
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userService.save(theUser).getUserID()).toUri();
		
		System.out.println(location.toString());
		
		return ResponseEntity.created(location).build();
	}
}
