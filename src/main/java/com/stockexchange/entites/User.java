package com.stockexchange.entites;

import java.sql.Date;

import org.slf4j.Logger;

public class User {
	private String login;
	private String password;
	private String firstName;
	private String secondName;
	private Date bDate;
	private String passportData;
	private String phone;
	private BrokerFirm firm;
		
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getSecondName() {
		return secondName;
	}
	
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	
	public Date getbDate() {
		return bDate;
	}
	
	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}
	
	public String getPassportData() {
		return passportData;
	}
	
	public void setPassportData(String passportData) {
		this.passportData = passportData;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public BrokerFirm getFirm() {
		return firm;
	}

	public void setFirm(BrokerFirm firm) {
		this.firm = firm;
	}


	public void printUser(Logger log){
		log.info("=======USER_OBJ======");
		log.info("LOGIN:" + login);
		log.info("PASSWORD:" + password);
		log.info("FIRST_NAME:" + firstName);
		log.info("SECOND_NAME:" + secondName);
		log.info("BIRTH_DATE:" + bDate.toString());
		log.info("PASSPORT:" + passportData);
		log.info("PHONE:" + phone);
	}

}
