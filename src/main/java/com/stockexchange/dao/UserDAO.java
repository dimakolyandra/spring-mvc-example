package com.stockexchange.dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import com.stockexchange.entites.User;

public class UserDAO extends BaseDAO<User, BigDecimal>{
	
	private final static Logger logger = LoggerFactory.getLogger(Logger.class);
	
	//TODO: РАЗОБРАТЬСЯ, ПОЧЕМУ НЕ РАБОТАЕТ
	//@Autowired
	//@Qualifier("registerUser")
	StoredProcedureDAO registerUser;
	
	private final String INSERT_NEW_USER = "CALL ADDING_USER(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	private final String SELECT_WORKERS_WITH_CLIENTS_COUNT = "SELECT USER_SYSTEM_ID, " +
																	"FIRST_NAME, " +
																	"SECOND_NAME, " +
																	"BIRTHDAY, " +
																	"PHONE_NUMBER, " +
																	"PASSPORT_DATA, " +
																	"LOGIN, " +
																	"PASSWORD, " +
																	"USER_TYPE, " +
																	"BROKER_FIRM_ID, " +
																	"COUNT(TRADER_USER_ID) AS CLIENTS_COUNT " +
															  "FROM " +
															  "USER_SYSTEM U_S " + 
															  "LEFT OUTER JOIN TRADING_CONTRACT T_C "
															  	+ "ON (U_S.USER_SYSTEM_ID = T_C.BROKER_USER_ID) " +
															  "WHERE U_S.USER_TYPE = 0 " +
															  "AND U_S.BROKER_FIRM_ID = ? " +
															  "GROUP BY USER_SYSTEM_ID, "
															  		+ "FIRST_NAME, "
															  		+ "SECOND_NAME, "
															  		+ "BIRTHDAY, "
															  		+ "PHONE_NUMBER, "
															  		+ "PASSPORT_DATA, "
															  		+ "LOGIN, "
															  		+ "PASSWORD, "
															  		+ "USER_TYPE, "
															  		+ "BROKER_FIRM_ID " + 
															  "ORDER BY CLIENTS_COUNT ASC";

	
	public UserDAO(JdbcTemplate dbTemp) {
		super(dbTemp);
	}

	public StoredProcedureDAO getRegisterUser() {
		return registerUser;
	}

	public void setRegisterUser(StoredProcedureDAO registerUser) {
		this.registerUser = registerUser;
	}

	@Override
	public ArrayList<User> getAll() {
		return null;
	}

	@Override
	public User getEntityById(BigDecimal id) {
		return null;
	}

	@Override
	public User update(User entity) {
		return null;
	}

	@Override
	public boolean delete(BigDecimal id) {
		return false;
	}
	
	@Override
	public BigDecimal insert(User entity){
		Map<String, Object> inParams = new HashMap<String, Object>();
	    inParams.put("P_FIRST_NAME", entity.getFirstName());
	    inParams.put("P_SECOND_NAME", entity.getSecondName());
	    inParams.put("P_BIRTHDAY", entity.getbDate());
	    inParams.put("P_PHONE_NUMBER", entity.getPhone());
	    inParams.put("P_PASSPORT_DATA", entity.getPassportData());
	    inParams.put("P_LOGIN", entity.getLogin());
	    inParams.put("P_PASSWORD", entity.getPassword());
	    inParams.put("P_USER_TYPE", new Integer(1));
	    inParams.put("P_BROKER_FIRM_ID", entity.getFirms().get(0).getId());
	    inParams.put("P_BROKER_USER_ID", entity.getBrokers().get(0).getId());
	    inParams.put("P_CURRENCY_ISO", new String("RUB"));
	    Map<String, Object> result =  registerUser.execute(inParams);
	    BigDecimal newUserId = new BigDecimal((Long)result.get("RESULT_ID"));
	    return newUserId;
	}

//	@Override
//	public BigDecimal insert(User entity) {
//		jdbcTemplate.update(INSERT_NEW_USER, 
//							entity.getFirstName(),
//							entity.getSecondName(),
//							entity.getbDate(),
//							entity.getPhone(),
//							entity.getPassportData(),
//							entity.getLogin(),
//							entity.getPassword(),
//							new Integer(1),
//							entity.getFirms().get(0).getId(),
//							entity.getBrokers().get(0).getId(),
//							new String("RUB"));
//		return new BigDecimal(0);
//	}

	public User getLeastLoadedWorker(BigDecimal firmId){
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SELECT_WORKERS_WITH_CLIENTS_COUNT, firmId);
		Map<String, Object> firstRow = rows.get(0);
		User leastLoadedWorker = new User();
		Timestamp time = (Timestamp) firstRow.get("BIRTHDAY");
		leastLoadedWorker.setId((BigDecimal)firstRow.get("USER_SYSTEM_ID"));
		leastLoadedWorker.setFirstName((String)firstRow.get("FIRST_NAME"));
		leastLoadedWorker.setSecondName((String)firstRow.get("SECOND_NAME"));
		leastLoadedWorker.setbDate(new Date(time.getTime()));
		leastLoadedWorker.setPhone((String)firstRow.get("PHONE_NUMBER"));
		leastLoadedWorker.setPassportData((String)firstRow.get("PASSPORT_DATA"));
		leastLoadedWorker.setLogin((String)firstRow.get("LOGIN"));
		leastLoadedWorker.setPassword((String)firstRow.get("PASSWORD"));
		return leastLoadedWorker;
	}
	
}
