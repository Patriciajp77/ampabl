package com.ampa.bl.bl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories("com.ampa.bl.bl")
@EnableTransactionManagement
public class BlApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlApplication.class, args);
	}
	
/*clase `com.mysql.jdbc.Driver '. 
 * Esto está desaprobado. La nueva clase de controlador es `com.mysql.cj.jdbc.Driver '.
 *  El controlador se registra automáticamente a través del SPI y la carga manual de 
 *  la clase de controlador generalmente no es necesaria.
 */
	
	
	
	/*
	
	
	@Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:33006/ampabl1");
        dataSource.setUsername("root");
        dataSource.setPassword("admo%1975");
        return dataSource;
    }
	 @Bean
	    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
	 
	        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
	        entityManagerFactoryBean.setDataSource(dataSource);
	        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
	        entityManagerFactoryBean.setPackagesToScan("com.ampa.bl.bl");
	 
	        Properties jpaProperties = new Properties();
	 
	        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	 
	        entityManagerFactoryBean.setJpaProperties(jpaProperties);
	 
	        return entityManagerFactoryBean;
	         
	    }
	     
	    @Bean public PlatformTransactionManager transactionManager() {
	         
	        JpaTransactionManager txManager= new JpaTransactionManager();
	        txManager.setEntityManagerFactory(entityManagerFactory(dataSource()).getObject());
	        return txManager;
	         
	    }
	 
	  */

}
