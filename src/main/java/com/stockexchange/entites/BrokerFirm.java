package com.stockexchange.entites;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BrokerFirm {
	
	private String firmName;
	private String stateRegistrationNumber;
	private String individualTaxpayerIndex;
	private String avatarFirmUrl;
	ArrayList<User> employees;

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

	public ArrayList<User> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<User> employees) {
		this.employees = employees;
	}
	
}
