package com.stockexchange.services;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stockexchange.dao.BrokerFirmDAO;
import com.stockexchange.dao.UserDAO;
import com.stockexchange.entites.BrokerFirm;
import com.stockexchange.entites.User;
import com.stockexchange.exceptions.ExternalBrokerSystemException;
import com.stockexchange.pojo.BrokersSystemRegistrationRequest;

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
    private BigDecimal firmId;
    private String registrationRestServiceURL;
    
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

    public String getRegistrationRestServiceURL() {
        return registrationRestServiceURL;
    }

    public void setRegistrationRestServiceURL(String registrationRestServiceURL) {
        this.registrationRestServiceURL = registrationRestServiceURL;
    }
    
    public BigDecimal getFirmId() {
        return firmId;
    }

    public void setFirmId(BigDecimal firmId) {
        this.firmId = firmId;
    }
    
    public ArrayList<BrokerFirm> getAllFirms(){
        return brokerFirmDAO.getAll();
    }
    
    public User findLeastLoadedWorker(BigDecimal firmId){
        return userDAO.getLeastLoadedWorker(firmId);
    }
    
    private void validateResponse(StatusLine status) throws ExternalBrokerSystemException{
        if (status.getStatusCode() != 200){
            throw new ExternalBrokerSystemException();
        }
    }
    
    @Transactional(isolation=Isolation.READ_COMMITTED, 
                   propagation=Propagation.REQUIRES_NEW, 
                   readOnly=false,
                   rollbackFor=Exception.class)
    public User finishRegistration() throws Exception{
        userDAO.registerTrader(currentTrader, chosenWorker);
        ObjectMapper mapper = new ObjectMapper();
        
        BrokersSystemRegistrationRequest regReq = new BrokersSystemRegistrationRequest(
                firmId.toString(), currentTrader);
        
        String  reqReqJson = mapper.writeValueAsString(regReq);
        
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(registrationRestServiceURL);
        StringEntity entity = new StringEntity(reqReqJson, "UTF-8");
        
        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json;charset=utf-8");
        
        CloseableHttpResponse response = client.execute(httpPost);
        validateResponse(response.getStatusLine());
        client.close();
        return null;
    }
}
