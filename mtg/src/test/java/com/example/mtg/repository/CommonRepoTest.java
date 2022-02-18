package com.example.mtg.repository;


import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.jdbc.Sql;

@DataJdbcTest
@Sql("classpath:schema-h2.sql")
public abstract class CommonRepoTest {

}
