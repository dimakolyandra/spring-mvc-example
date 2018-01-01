package com.stockexchange.dao;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.stockexchange.enums.TypeOfStoredProcedureParameter;

/**
 * Base class for constructing needed Stored procedures.
 * Setting is realized in xml context file.
 * @author dimakolyandra
 */

public class StoredProcedureDAO extends StoredProcedure{
	
	/**
	 * @param dataSource DataSource connected with database
	 * @param sprocName Name of stored procedure
	 * @param params Map, containing name of stored procedure parameter as key and parameter type as value 
	 * @param inOrOut Map, containing name of stored procedure parameter as key and parameter type (in or out) as value 
	 */
	
	private final static Logger logger = LoggerFactory.getLogger(Logger.class);
	public String a ="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
	public StoredProcedureDAO(DataSource dataSource, 
							  String sprocName,
							  Map<String, Integer> params, 
							  Map<String, TypeOfStoredProcedureParameter> inOrOut){		
		super(dataSource, sprocName);
		for (String parameter: params.keySet()){
			TypeOfStoredProcedureParameter isInOrOut = inOrOut.get(parameter);
			if (isInOrOut == TypeOfStoredProcedureParameter.IN){
				declareParameter(new SqlParameter(parameter, params.get(parameter)));
			}
			else if(isInOrOut == TypeOfStoredProcedureParameter.OUT){
				declareParameter(new SqlOutParameter(parameter, params.get(parameter)));	
			}
		}
		compile();
	}
	
/*	public Has execute(Map<String, Object> params){
		return super.execute(params);
	}*/
	
	
}
