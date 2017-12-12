package com.stockexchange.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stockexchange.entites.User;

@Controller
public class RegistrationController {
	
	private final static Logger logger = LoggerFactory.getLogger(Logger.class);
	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public ModelAndView registration(){
		logger.info("REGISTRATION VEIEW");
		return new ModelAndView("registration", "newUser", new User());
	}
	
}
