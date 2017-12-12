package com.stockexchange.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stockexchange.dao.BaseDAO;
import com.stockexchange.dao.BrokerFirmDAO;
import com.stockexchange.entites.BrokerFirm;
import com.stockexchange.entites.User;

@Controller
public class ChooseBrokerController {

	private final static Logger logger = LoggerFactory.getLogger(Logger.class);
	
	@Autowired
	@Qualifier("brokerFirmDAO")
	private BrokerFirmDAO brokerFirmDAO;
	
	@RequestMapping(value="/choose-broker", method=RequestMethod.POST)
	public ModelAndView chooseBroker(@ModelAttribute("newUser") User user){
		ArrayList<BrokerFirm> firms = brokerFirmDAO.getAll();
		for (BrokerFirm firm: firms){
			firm.printBrokerFirm(logger);
		}
		return new ModelAndView("brokerlist", "newUser", user);
	}


}
