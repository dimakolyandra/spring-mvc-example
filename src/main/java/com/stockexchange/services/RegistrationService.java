package com.stockexchange.services;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.stockexchange.dao.BrokerFirmDAO;
import com.stockexchange.dao.UserDAO;
import com.stockexchange.entites.BrokerFirm;
import com.stockexchange.entites.User;

@Service
public class RegistrationService {

    @Autowired
    @Qualifier("brokerFirmDAO")
    private BrokerFirmDAO brokerFirmDAO;
    
    @Autowired
    @Qualifier("userDAO")
    private UserDAO userDAO;

    private User currentTrader;
    private User chosenWorker;

    private final static Logger logger = LoggerFactory.getLogger(Logger.class);

    public User getCurentTrader() {
        return currentTrader;
    }

    public void setCurrentTrader(User curUser) {
        this.currentTrader = curUser;
    }

    public User getChosenWorker() {
        return chosenWorker;
    }

    public void setChosenWorker(User chosenWorker) {
        this.chosenWorker = chosenWorker;
    }
    
    public ArrayList<BrokerFirm> getAllFirms(){
        return brokerFirmDAO.getAll();
    }
    
    @Transactional(isolation=Isolation.READ_COMMITTED, 
                   propagation=Propagation.REQUIRES_NEW, 
                   readOnly=true)
    public User findLeastLoadedWorker(BigDecimal firmId){
        return userDAO.getLeastLoadedWorker(firmId);
    }
    
    @Transactional(isolation=Isolation.READ_COMMITTED, 
                   propagation=Propagation.REQUIRES_NEW, 
                   readOnly=false,
                   rollbackFor=Exception.class)
    public User finishRegistration(){
        userDAO.registerTrader(currentTrader, chosenWorker);
        return null;
    }
    
}
