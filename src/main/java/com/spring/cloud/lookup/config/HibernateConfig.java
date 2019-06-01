package com.spring.cloud.lookup.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

@Component
@Configuration
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfig {

	@Value("${hib.jdbc.url}")
	private String url;

	@Value("${hib.jdbc.uname}")
	private String uName;

	@Value("${hib.jdbc.pwd}")
	private String pwd;

	@Value("${hib.prop.dialect}")
	private String dialect;

	@Value("${hib.jdbc.driver}")
	private String driver;
	
	@Value("${hib.prop.hbm2ddl}")
	private String hbm2ddl;

	// Create Data Source
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(url);
		dataSource.setUsername(uName);
		dataSource.setPassword(pwd);
		dataSource.setDriverClassName(driver);
		return dataSource;
	}

	// Create Hibernate Properties
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", dialect);
		properties.put("hibernate.hbm2ddl.auto", hbm2ddl);
		properties.put("hibernate.show_sql", "true;");
		properties.put("spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation", "true");
		return properties;
	}

	// Create Session Factory
	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setHibernateProperties(hibernateProperties());
		factoryBean.setPackagesToScan(new String[] { "com.spring.cloud.lookup.model" });
		return factoryBean;
	}

	// Create Transaction
	@Bean
	public HibernateTransactionManager getTransaction(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;

	}

}
