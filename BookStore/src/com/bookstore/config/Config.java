package com.bookstore.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@EnableTransactionManagement
@Configuration
@ComponentScan(basePackages = "com.bookstore")
public class Config {

	@Bean
	public InternalResourceViewResolver viewResolver() {
		System.out.println("Config> InternalResourceViewResolver");
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/myjsps/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
	public DataSource dataSource() {
		System.out.println("Config> InternalResourceViewResolver");
		BasicDataSource dataSource= new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/bookstoredb");
		dataSource.setUsername("root");
		dataSource.setPassword("mysql");
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean(DataSource dataSource) {
		System.out.println("Config- LocalSessionFactoryBean");
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource);
		
		Properties properties= new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");
		localSessionFactoryBean.setHibernateProperties(properties);
		localSessionFactoryBean.setPackagesToScan("com.bookstore.entity");
		return localSessionFactoryBean;
	}
	
	@Bean
	public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory) {
		System.out.println("Config- HibernateTemplate");
		return new HibernateTemplate(sessionFactory);
	}
	
	@Bean
	public PlatformTransactionManager platformTransactionManager(SessionFactory sessionFactory) {
		System.out.println("Config- PlatformTransactionManager");
		return new HibernateTransactionManager(sessionFactory);
	}
}
