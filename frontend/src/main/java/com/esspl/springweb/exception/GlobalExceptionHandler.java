package com.esspl.springweb.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNotFoundException() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("error title", "page is not constructed");
		mv.addObject("error description", "page is not found");
		mv.addObject("title", "404 not found");
		
		return mv;
	}
}
