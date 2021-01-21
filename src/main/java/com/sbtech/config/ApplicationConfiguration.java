package com.sbtech.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.sbtech")
@PropertySource({"classpath:mysql-hibernate.properties"})
public class ApplicationConfiguration implements WebMvcConfigurer {
   
	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(ApplicationConfiguration.class);
	
	@Bean
	public DataSource dataSource() {
		
		// creating connection pool
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		// set the jdbc driver
		try {
			dataSource.setDriverClass(
					env.getProperty("connection.driver_class"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		
		logger.info("connection.url" + env.getProperty("connection.url"));
		
		// set database connection properties
		dataSource.setJdbcUrl(env.getProperty("connection.url"));
		dataSource.setUser(env.getProperty("connection.username"));
		dataSource.setPassword(env.getProperty("connection.password"));
		
		// set connection pool properties
		dataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		dataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		dataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		dataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		
		return dataSource;
	}
	
	// method to convert the environment property to int
	private int getIntProperty(String propertyName) {
	
		String propertyValue = env.getProperty(propertyName);
		int intPropertyValue = Integer.parseInt(propertyValue);
		return intPropertyValue;
	}
	
	private Properties getHibernateProperties() {
		
		// set hibernate properties
		Properties properties = new Properties();
		properties.setProperty("hibernte.dialect", env.getProperty("hibernate.dialect"));
		properties.setProperty("hibernte.show_sql", env.getProperty("hibernate.show_sql"));
		properties.setProperty("hibernate.hbm2ddl.auto", 
				        env.getProperty("hibernate.hbm2ddl.auto"));
		return properties;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		
		// create session factory
		LocalSessionFactoryBean sessionFactory = 
				new LocalSessionFactoryBean();
		
		// set properties
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(
				env.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());
		
		return sessionFactory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		
		// setup transaction manager based on session factory
		HibernateTransactionManager txManager = 
				new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		
		return txManager;
	}
	
}
