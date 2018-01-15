package com.stockexchange.pojo;


import java.math.BigDecimal;

import com.stockexchange.entites.User;

public class BrokersSystemRegistrationRequest {
    
    private String brokerFirmId;
    private User newUser;
    private BigDecimal accountNumber;
    
    public BrokersSystemRegistrationRequest(){}
    
    public BrokersSystemRegistrationRequest(String brId, User user, BigDecimal accNumb){
        brokerFirmId = brId;
        newUser = user;
        accountNumber = accNumb;
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

    public BigDecimal getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(BigDecimal accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    
}
