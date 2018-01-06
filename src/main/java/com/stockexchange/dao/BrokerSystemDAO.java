package com.stockexchange.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.stockexchange.entites.User;

@Repository
public class BrokerSystemDAO {

    private JdbcTemplate jdbcTemplate;

    private final String INSERT_CLIENT_INTO_BROKER_SYSTEM = 
            "INSERT INTO CLIENT("
            + "FIRST_NAME, "
            + "SECOND_NAME, "
            + "BIRTHDAY, "
            + "PHONE_NUMBER, "
            + "PASSPORT_DATA) "
        + "VALUES(?, ?, ?, ?, ?)";

    private final String INSERT_CLIENT_ACCOUNT_INTO_BROKER_SYSTEM = 
            "INSERT INTO CLIENT_ACCOUNT("
            + "ISO, "
            + "PASSPORT_DATA) "
            + "VALUES(?, ?)";

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertClient(User user){
        jdbcTemplate.update(INSERT_CLIENT_INTO_BROKER_SYSTEM,
                            user.getFirstName(),
                            user.getSecondName(),
                            user.getbDate(),
                            user.getPhone(),
                            user.getPassportData());
    }
    
    public void insertClientAccount(String iso, String passport){
        jdbcTemplate.update(INSERT_CLIENT_ACCOUNT_INTO_BROKER_SYSTEM, iso, passport);
    }

}
