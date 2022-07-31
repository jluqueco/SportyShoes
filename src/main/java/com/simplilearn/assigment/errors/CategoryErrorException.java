package com.simplilearn.assigment.errors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryErrorException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CategoryErrorException(String description) {
		// TODO Auto-generated constructor stub
		super(description);
	}
}
