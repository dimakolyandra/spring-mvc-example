package com.stockexchange.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stockexchange.entites.User;


@Controller
public class MainController{
	
	private final static Logger logger = LoggerFactory.getLogger(Logger.class);
	
	@Autowired
	@Qualifier("jdbcTemplate")
	JdbcTemplate jdbc;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView main(){
		logger.info("ENTER VIEW");
		return new ModelAndView("home", "user", new User());
	}
	
	@RequestMapping(value="/enter-system", method=RequestMethod.POST)
	public ModelAndView checkUser(@ModelAttribute("user") User user){
		logger.info("USERS PERSON CABINET VIEW");
		return new ModelAndView("main", "user", user);
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public ModelAndView registration(){
		logger.info("REGISTRATION VEIEW");
		return new ModelAndView("registration", "newUser", new User());
	}
	
	@RequestMapping(value="/choose-broker", method=RequestMethod.POST)
	public ModelAndView chooseBroker(@ModelAttribute("newUser") User user){
		logger.info("CHOOSE BROKER");
		user.printUser(logger);
		return new ModelAndView("brokerlist", "newUser", user);
	}
}
