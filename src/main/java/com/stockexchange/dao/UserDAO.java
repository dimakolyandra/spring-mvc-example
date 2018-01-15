package com.stockexchange.dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.stockexchange.entites.User;

@Repository
public class UserDAO extends BaseDAO<User, BigDecimal>{
	
	@Autowired
	@Qualifier("registerUser")
	private StoredProcedureDAO registerUser;
	
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
	
	public BigDecimal registerTrader(User newTrader, User chosenWorker){
	    Map<String, Object> inParams = new HashMap<String, Object>();
        inParams.put("P_FIRST_NAME", newTrader.getFirstName());
        inParams.put("P_SECOND_NAME", newTrader.getSecondName());
        inParams.put("P_BIRTHDAY", newTrader.getbDate());
        inParams.put("P_PHONE_NUMBER", newTrader.getPhone());
        inParams.put("P_PASSPORT_DATA", newTrader.getPassportData());
        inParams.put("P_LOGIN", newTrader.getLogin());
        inParams.put("P_PASSWORD", newTrader.getPassword());
        inParams.put("P_USER_TYPE", new Integer(1));
        inParams.put("P_BROKER_USER_ID", chosenWorker.getId());
        inParams.put("P_CURRENCY_ISO", new String("RUB"));
        Map<String, Object> outParams = registerUser.execute(inParams);
        return (BigDecimal) outParams.get("RESULT_ACCOUNT_NUMBER");
	}
	
	@Override
	public BigDecimal insert(User entity){
	    return null;
	}

	
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
