package com.example.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

//	@Bean(name = "dataSource")
//	public DataSource getDataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//		// See: application.properties
//		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
//		dataSource.setUrl(env.getProperty("spring.datasource.url"));
//		dataSource.setUsername(env.getProperty("spring.datasource.username"));
//		dataSource.setPassword(env.getProperty("spring.datasource.password"));
//
//		System.out.println("## getDataSource: " + dataSource);
//
//		return dataSource;
//	}

//	@Autowired
//	@Bean(name = "sessionFactory")
//	public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
//		Properties properties = new Properties();
//
//		// See: application.properties
//		properties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
//		properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
//		properties.put("current_session_context_class",
//				env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));

//		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
//
//		// Package contain entity classes
//		factoryBean.setPackagesToScan(new String[] { "com.example.userservice.models" });
//		factoryBean.setDataSource(dataSource);
////		factoryBean.setHibernateProperties(properties);
//		factoryBean.afterPropertiesSet();
//		//
//		SessionFactory sf = factoryBean.getObject();
//		System.out.println("## getSessionFactory: " + sf);
//		return sf;
//	}

//	@Autowired
//	@Bean(name = "transactionManager")
//	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
//		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
//		return transactionManager;
//	}
}
