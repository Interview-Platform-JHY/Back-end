package com.interview.itp.Config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DataSourceConfiguration {
	
	@Autowired
	ApplicationContext appConext;
	
	//application.yml에 설정한 HikariCp를 HikariConfig 객체에 바인딩 시킴
	@Bean
	@ConfigurationProperties(prefix="spring.datasource.hikari") //읽어올 설정정보명
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}
	
	// Connection Pool을 관리하는 DataSource 인터페이스 객체 선언
	@Bean
	public DataSource dataSource() {
		return new HikariDataSource(hikariConfig());
	}
	
	// DataSource를 이용해 Mysql과 MyBatis 연결
	// SqlSessionFactoryBean : DB 연결과 SQL 실행을 하는 객체 + Mybatis 관련 설정
	@Bean(name="sqlSessionFactory")
	@ConfigurationProperties(prefix="mybatis") //읽어올 설정정보명
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlBean = new SqlSessionFactoryBean();
		
		sqlBean.setDataSource(dataSource);
		
		return sqlBean.getObject();
		
	}
	
	//sqlSessionTemplate : mybatis의 적힌 쿼리문을 수행하는 역할
	@Bean(name="sqlSession")
	public SqlSessionTemplate sqlSession(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
	
}
