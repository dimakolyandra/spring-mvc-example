package com.stockexchange.dao;

import java.util.ArrayList;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class BaseDAO <E, K>{
	
	protected JdbcTemplate jdbcTemplate;
	
	public BaseDAO(JdbcTemplate dbTemp){
		jdbcTemplate = dbTemp;
	}
	
	public abstract ArrayList<E> getAll();
	
	public abstract E getEntityById(K id);
	
	public abstract E update(E entity);
	
	public abstract boolean delete(K id);
	
	public abstract boolean insert(E entity);

}
