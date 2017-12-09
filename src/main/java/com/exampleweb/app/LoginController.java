package com.exampleweb.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView main(){
		return new ModelAndView("home", "user", new User());
	}
	
	@RequestMapping(value="/enter-system", method=RequestMethod.POST)
	public ModelAndView checkUser(@ModelAttribute("user") User user){
		return new ModelAndView("main", "user", user);
	}
	
	@RequestMapping(value="/registration", method=RequestMethod.GET)
	public ModelAndView registration(){
		return new ModelAndView("registration");
	}
	
}
