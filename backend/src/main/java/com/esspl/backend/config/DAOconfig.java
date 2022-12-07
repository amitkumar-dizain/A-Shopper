package com.esspl.backend.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan(basePackages= {"com.esspl.backend.model"})
@EnableTransactionManagement
public class DAOconfig {

	public static final String DRIVER_NAME = "org.postgresql.Driver";
	public static final String URL = "jdbc:postgresql://localhost:5432/onlineshopping";
	public static final String USER_NAME = "postgres";
	public static final String PASSWORD = "amit";

	@Bean("dataSource")
	public DataSource getdatasource() {
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName(DRIVER_NAME);
		datasource.setUrl(URL);
		datasource.setUsername(USER_NAME);
		datasource.setPassword(PASSWORD);
		return datasource;
	}
	@Bean
	public SessionFactory getSessionFactory(DataSource datasource) {
		
		LocalSessionFactoryBuilder  builder = new LocalSessionFactoryBuilder(datasource) ;
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.esspl.backend.model");
		
		return builder.buildSessionFactory();
		
	}
	private Properties getHibernateProperties() {
		Properties prop = new Properties();
		prop.put("hibernate.show_sql", true);
		prop.put("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
		prop.put("hibernate.format_sql", true);
		
		return prop;
	}
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager =new HibernateTransactionManager(sessionFactory);
		
		return transactionManager;
	}
	}

