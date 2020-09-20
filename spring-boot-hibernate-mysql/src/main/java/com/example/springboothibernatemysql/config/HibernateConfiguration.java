/**
 * 
 */
package com.example.springboothibernatemysql.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/**
 * @author Mayank
 *
 */
@Configuration
@PropertySource(value = {"classpath:application.properties"})
public class HibernateConfiguration {
	
	@Value("${datasource.driver-class-name}")
	private String driverClass;
	
	@Value("${datasource.url}")
	private String url;
	
	@Value("${datasource.username}")
	private String username;
	
	@Value("${datasource.password}")
	private String password;
	
	@Value("${hibernate.dialect}")
	private String dialect;
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);
		dataSource.setDriverClassName(driverClass);
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(getDataSource());
		factory.setHibernateProperties(hibernateProps());
		factory.setPackagesToScan(new String[] {"com.example.springboothibernatemysql.modal"});
		return factory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory factory) {
		HibernateTransactionManager transaction = new HibernateTransactionManager();
		transaction.setSessionFactory(factory);
		return transaction;
	}
	
	private Properties hibernateProps() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", dialect);
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.show_sql", "true");
		return properties;
	}
	
}
