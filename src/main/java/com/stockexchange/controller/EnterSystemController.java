package com.stockexchange.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stockexchange.entites.User;

@Controller
public class EnterSystemController {

	private final static Logger logger = LoggerFactory.getLogger(Logger.class);

	@RequestMapping(value="/enter-system", method=RequestMethod.POST)
	public ModelAndView checkUser(@ModelAttribute("user") User user){
		logger.info("USERS PERSON CABINET VIEW");
		return new ModelAndView("main", "user", user);
	}
	

}
