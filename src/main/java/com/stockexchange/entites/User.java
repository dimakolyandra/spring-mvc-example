package com.stockexchange.entites;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;

import org.slf4j.Logger;

public class User {
	
	private BigDecimal id;
	private String login;
	private String password;
	private String firstName;
	private String secondName;
	private Date bDate;
	private String passportData;
	private String phone;
	private ArrayList<BrokerFirm> firms;
	private ArrayList<User> brokers;
		
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

	public ArrayList<BrokerFirm> getFirms() {
		return firms;
	}

	public void setFirms(ArrayList<BrokerFirm> firms) {
		this.firms = firms;
	}
	
	public void addFirm(BrokerFirm firm){
		if (firms == null){
			this.firms = new ArrayList<BrokerFirm>();
		}
		this.firms.add(firm);
	}

	public void addBroker(User broker){
		if (brokers == null){
			this.brokers = new ArrayList<User>();
		}
		this.brokers.add(broker);
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public ArrayList<User> getBrokers() {
		return brokers;
	}

	public void setBrokers(ArrayList<User> brokers) {
		this.brokers = brokers;
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
