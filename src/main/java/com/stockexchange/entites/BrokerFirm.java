package com.stockexchange.entites;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

import org.slf4j.Logger;

public class BrokerFirm {
	
	private BigDecimal id;
	private String firmName;
	private String stateRegistrationNumber;
	private String individualTaxpayerIndex;
	private String avatarFirmUrl;
	ArrayList<User> employees;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getFirmName() {
		return firmName;
	}

	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}

	public String getStateRegistrationNumber() {
		return stateRegistrationNumber;
	}

	public void setStateRegistrationNumber(String stateRegistrationNumber) {
		this.stateRegistrationNumber = stateRegistrationNumber;
	}

	public String getIndividualTaxpayerIndex() {
		return individualTaxpayerIndex;
	}

	public void setIndividualTaxpayerIndex(String individualTaxpayerIndex) {
		this.individualTaxpayerIndex = individualTaxpayerIndex;
	}

	public String getAvatarFirmUrl() {
		return avatarFirmUrl;
	}

	public void setAvatarFirmUrl(String avatarFirmUrl) {
		this.avatarFirmUrl = avatarFirmUrl;
	}


	public ArrayList<User> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<User> employees) {
		this.employees = employees;
	}
	
	public void printBrokerFirm(Logger log){
		log.info("=======FIRM_OBJ======");
		log.info("FIRM_NAME:" + firmName);
		log.info("STATE_REGISTRATION_NUMBER" + stateRegistrationNumber);
		log.info("INDIVIDUAL_TAXPAYER_INDEX:" + individualTaxpayerIndex);
		log.info("AVATAR_FIRM_URL:" + avatarFirmUrl);
	}

	
}
