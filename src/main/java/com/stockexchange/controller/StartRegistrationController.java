package com.stockexchange.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stockexchange.entites.User;

@Controller
public class StartRegistrationController {
	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView view = new ModelAndView("registration");
		view.addObject("newUser", new User());
		view.addObject("isFirst", new Boolean(true));
		return view;
	}

}
