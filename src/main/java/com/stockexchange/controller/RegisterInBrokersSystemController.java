package com.stockexchange.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stockexchange.dao.BrokerSystemDAO;
import com.stockexchange.pojo.BrokersSystemRegistrationRequest;

@RestController
public class RegisterInBrokersSystemController {
      
      @Autowired
      @Qualifier("brokerSystemMap")
      private HashMap<String, JdbcTemplate> brokerSystemsMap;
      
      @Autowired
      private BrokerSystemDAO brokerSystemDAO;
      
      private final static Logger logger = LoggerFactory.getLogger(Logger.class);
      
      public Map<String, JdbcTemplate> getBrokerSystemsMap() {
          return brokerSystemsMap;
      }

      public void setBrokerSystemsMap(HashMap<String, JdbcTemplate> brokerSystemsMap) {
          this.brokerSystemsMap = brokerSystemsMap;
      }

      @Transactional(isolation=Isolation.READ_COMMITTED, 
                     propagation=Propagation.REQUIRES_NEW, 
                     readOnly=false,
                     rollbackFor=Exception.class)
      @RequestMapping(value="/send-reg-request-in-broker-system", method=RequestMethod.POST)
      public void registerInBrokersSystem(
              @RequestBody BrokersSystemRegistrationRequest  registrationRequest){
          
          JdbcTemplate chosenSystem = brokerSystemsMap.get(registrationRequest.getBrokerFirmId());
          brokerSystemDAO.setJdbcTemplate(chosenSystem);
          brokerSystemDAO.insertClient(registrationRequest.getNewUser());
          brokerSystemDAO.insertClientAccount("RUB", registrationRequest.getNewUser().getPassportData());
      }

}
