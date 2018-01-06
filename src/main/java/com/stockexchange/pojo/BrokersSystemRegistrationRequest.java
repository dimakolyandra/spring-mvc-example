package com.stockexchange.pojo;

import java.math.BigDecimal;

import com.stockexchange.entites.User;

public class BrokersSystemRegistrationRequest {
    
    private String brokerFirmId;
    private User newUser;
    
    public BrokersSystemRegistrationRequest(){}
    
    public BrokersSystemRegistrationRequest(String brId, User user){
        brokerFirmId = brId;
        newUser = user;
    }
    
    public String getBrokerFirmId() {
        return brokerFirmId;
    }

    public void setBrokerFirmId(String brokerFirmId) {
        this.brokerFirmId = brokerFirmId;
    }

    public User getNewUser() {
        return newUser;
    }

    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }
    
    
}
