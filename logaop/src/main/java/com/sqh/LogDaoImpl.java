package com.sqh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class LogDaoImpl implements LogDao {

    JdbcTemplate jdbcTemplate;
    @Override
    public void writeLog(LogBean logBean) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate("")
    }
}
