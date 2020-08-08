package com.example.demo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: 江宝明
 * @Description:
 * @Date:2020/08/08
 * @Modified By：
 */

@Service
public class ExportService {

    @Qualifier("oracleJdbcTemplate")
    private JdbcTemplate oracleJdbcTemplate;


    @Qualifier("mysqlJdbcTemplate")
    private JdbcTemplate mysqlJdbcTemplate;


    public  void export(){



    }


    private List<Map<String, Object>> getTable(){
       return oracleJdbcTemplate.queryForList("select  * from ps_form_table");
    }

}
