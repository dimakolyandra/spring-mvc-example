package com.stockexchange.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import com.stockexchange.entites.BrokerFirm;

public class BrokerFirmDAO extends BaseDAO<BrokerFirm, Integer>{
	
	private final static Logger logger = LoggerFactory.getLogger(Logger.class);
	
	private static final String SQL_SELECT_ALL_FIRM = "SELECT * FROM BROKER_FIRM";
	
	public BrokerFirmDAO(JdbcTemplate dbTemp) {
		super(dbTemp);
	}

	@Override
	public ArrayList<BrokerFirm> getAll() {
		logger.info("GET ALL METHOD!");
		ArrayList<BrokerFirm> firms = new ArrayList<BrokerFirm>();
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_SELECT_ALL_FIRM);
		for(Map<String, Object> row: rows){
			BrokerFirm firm = new BrokerFirm();
			firm.setId((BigDecimal)row.get("BROKER_FIRM_ID"));
			firm.setFirmName((String)row.get("FIRM_NAME"));
			firm.setStateRegistrationNumber((String)row.get("STATE_REGISTRATION_NUMBER"));
			firm.setIndividualTaxpayerIndex((String)row.get("INDIVIDUAL_TAXPAYER_INDEX"));
			firm.setAvatarFirmUrl((String)row.get("AVATAR_URL"));
			firms.add(firm);
		}
		return firms;
	}

	@Override
	public BrokerFirm getEntityById(Integer id) {
		return null;
	}

	@Override
	public BrokerFirm update(BrokerFirm entity) {
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		return false;
	}

	@Override
	public boolean insert(BrokerFirm entity) {
		return false;
	}

}
