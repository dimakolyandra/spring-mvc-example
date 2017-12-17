package com.stockexchange.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stockexchange.entites.User;


@Controller
public class MainController{
	
	private final static Logger logger = LoggerFactory.getLogger(Logger.class);
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView main(){
		return new ModelAndView("home", "user", new User());
	}
	
}
