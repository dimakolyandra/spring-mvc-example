package com.stockexchange.controller;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.stockexchange.dao.BrokerFirmDAO;
import com.stockexchange.dao.UserDAO;
import com.stockexchange.entites.BrokerFirm;
import com.stockexchange.entites.User;

@Controller
public class ChooseBrokerController {

	@Autowired
	@Qualifier("brokerFirmDAO")
	private BrokerFirmDAO brokerFirmDAO;
	
	@Autowired
	@Qualifier("userDAO")
	private UserDAO userDAO;

	private User newUser;
	private User leastLoadedWorker;
	private ArrayList<BrokerFirm> firmList;
	private final static Logger logger = LoggerFactory.getLogger(Logger.class);

	public User getNewUser() {
		return newUser;
	}

	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}
	
	private BrokerFirm findBrokerById(BigDecimal id){
		for (BrokerFirm firm: firmList){
			logger.info("?????????????????????");
			logger.info(firm.getId().toString());
			logger.info(id.toString());
			if (id.equals(firm.getId())){
				logger.info("!!!!!!!!!!!!!!!!!!!!!!!!!!");
				return firm;
			}
		}
		return null;
	}
	
	@RequestMapping(value="/choose-broker", method=RequestMethod.POST)
	public ModelAndView chooseBroker(@ModelAttribute("newUser") User user){
		firmList = brokerFirmDAO.getAll();		
		newUser = user;
		return new ModelAndView("brokerlist", "firmList", firmList);
	}
	
	@RequestMapping(value="/finish-registration", method=RequestMethod.GET)
	public ModelAndView getFinishReg(@RequestParam("id") String firmId){
		// TODO: Сделать дополнительное представление 
		//       для получения информации о брокере
		logger.info(firmId);
		BrokerFirm chosenFirm = findBrokerById(new BigDecimal(firmId));
		leastLoadedWorker = userDAO.getLeastLoadedWorker(new BigDecimal(firmId));
		chosenFirm.printBrokerFirm(logger);
		if (chosenFirm != null){
			newUser.addFirm(chosenFirm);	
			newUser.addBroker(leastLoadedWorker);
		}
		newUser.getFirms();
		return new ModelAndView("finish_registration", "worker", leastLoadedWorker);
	}
	
	@RequestMapping(value="/submit-registration", method=RequestMethod.GET)
	public ModelAndView submitReg(){
		newUser.printUser(logger);
		userDAO.insert(newUser);
		return new ModelAndView("main", "user", newUser);
	}
	
}
