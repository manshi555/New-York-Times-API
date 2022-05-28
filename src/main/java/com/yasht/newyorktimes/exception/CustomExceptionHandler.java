package com.yasht.newyorktimes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.yasht.newyorktimes.exception.model.SectionNotFoundException;

import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class CustomExceptionHandler  {

	public static final String ERROR_PATH = "/error";
	
	@ExceptionHandler(SectionNotFoundException.class)
	public ModelAndView sectionNotFoundException(SectionNotFoundException exception) {
		ModelAndView modelAndView = new ModelAndView("ErrorPage");
	    modelAndView.addObject("section", exception.getMessage());
	    return modelAndView;
		//return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	  @ExceptionHandler(NoHandlerFoundException.class)
	  //ResourceHttpRequestHandler.java overriding for customizing whitelabel error
	  public ResponseEntity<String> pageNotFoundException(NoHandlerFoundException exception) { 
		  return new ResponseEntity<String>("This page was not found", HttpStatus.BAD_REQUEST); 
	}
	 
}
