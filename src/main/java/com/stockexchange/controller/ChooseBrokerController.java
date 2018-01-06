package com.stockexchange.controller;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.stockexchange.entites.BrokerFirm;
import com.stockexchange.entites.User;
import com.stockexchange.exceptions.ExternalBrokerSystemException;
import com.stockexchange.services.RegistrationService;

@Controller
public class ChooseBrokerController {
    
    @Autowired
    @Qualifier("regServ")
    private RegistrationService regServ;
    
    private final static Logger logger = LoggerFactory.getLogger(Logger.class);
    
	@RequestMapping(value="/choose-broker", method=RequestMethod.POST)
	public ModelAndView chooseBroker(@ModelAttribute("newUser") User user){
	    ArrayList<BrokerFirm> firmList = regServ.getAllFirms();
	    regServ.setCurrentTrader(user);
		return new ModelAndView("brokerlist", "firmList", firmList);
	}
	
	@RequestMapping(value="/prepare-for-submit-registration", method=RequestMethod.GET)
	public ModelAndView getFinishReg(@RequestParam("id") String firmId){
	    User leastLoadedWorker = regServ.findLeastLoadedWorker(new BigDecimal(firmId));
	    regServ.setFirmId(new BigDecimal(firmId));
	    regServ.setChosenWorker(leastLoadedWorker);
	    return new ModelAndView("submit_registration", "worker", leastLoadedWorker);
	}
	
	@RequestMapping(value="/submit-registration", method=RequestMethod.GET)
	public ModelAndView submitReg() throws Exception{
	    try{
	        User newTrader = regServ.finishRegistration();
	        return new ModelAndView("main", "user", newTrader);
	    }
	    catch(DuplicateKeyException ex){
	        ModelAndView view = new ModelAndView("registration");
	        view.addObject("newUser", regServ.getCurentTrader());
	        view.addObject("isFirst", new Boolean(false));
	        return view;
	    }
	    catch(ExternalBrokerSystemException ex){
	        //TODO Сделать нормальную обработку
	        return new ModelAndView("error");    
	    }
	    catch(Exception ex){
	        return new ModelAndView("error");
	    }
	}
	
}
