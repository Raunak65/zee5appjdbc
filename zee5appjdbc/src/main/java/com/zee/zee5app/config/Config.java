package com.zee.zee5app.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration //it is used to mark on config class/classes
//here we will hold all commonly required objects for our application
@ComponentScan("com.zee.zee5app")
@PropertySource("classpath:application.properties")
public class Config {
	//config: db related, reading prop file. commonly req beans(password encoder)
	
	@Autowired //will bring the already created objects
	Environment environment; //this impl object is prepared by spring
	//we need to inject already created object ===> DI ===> IoC
	
	@Bean //for providing the singleton object
	//if we will not specify the bean name then it will take/consider the method as bean name
	public DataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUsername(environment.getProperty("jdbc.username"));
		basicDataSource.setPassword(environment.getProperty("jdbc.password"));
		basicDataSource.setUrl(environment.getProperty("jdbc.url"));
		basicDataSource.setDefaultAutoCommit(false);
		return basicDataSource;
	}
}