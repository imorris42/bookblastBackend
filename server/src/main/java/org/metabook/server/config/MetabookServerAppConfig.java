package org.metabook.server.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.event.TransactionAwareApplicationEventMulticaster;

@Configuration
@EnableAsync
//@EnableAutoConfiguration

@EnableJpaRepositories(basePackages = {"org.metabook.repository.book"})
@EnableSpringDataWebSupport
//@Import({ ApplicationConfiguration.class })
//@ComponentScan(excludeFilters = @Filter({ Service.class, Configuration.class,useDefaultFilters = false,  }))
@ComponentScan(basePackages = {
		"org.metabook.repository.book.*",
		"org.metabook.repository.core.*",
		"org.metabook.repository.service.*"
		}) //"org.metabook.repository.book","org.metabook.repository.core", "org.metabook.server.api.book.engine.web"})

public class MetabookServerAppConfig {

	@Bean
	ApplicationEventMulticaster applicationEventMulticaster() {
		return new TransactionAwareApplicationEventMulticaster();
	}
	
	  @Bean
	  public DataSource dataSource() {
	  BasicDataSource dataSource = new BasicDataSource();
	  
		dataSource.setDriverClassName("org.postgresql.Driver");
		//dataSource.setUrl("jdbc:postgresql://56646b860c1e665852000108-bookblast.rhcloud.com:49821/bookblastrepository");
		dataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/bookblast");
	
		// postgresql://adminh1ij96q:kEj6csnvkmLR@5661d2032d5271b83200014b-bookblast.rhcloud.com:35701/
		dataSource.setUsername("adminexrwixs");
		dataSource.setPassword("gPu4g-jrIPCX");
		dataSource.setDefaultAutoCommit(false);
	  //log.info("Starting to process url to datasource {}.",dataSource.getUrl());
	  //log.info("Starting to process user for datasource {}.",dataSource.getUsername());
	  //dataSource.setPassword("CB2866814A7042FE273C191F01AE8FF2");
	  dataSource.setDefaultAutoCommit(false);

/*    
	  dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      dataSource.setValidationQuery("select 1");
      dataSource.setUrl("jdbc:sqlserver://127.0.0.1:2012;databaseName=metaBook;instance=SQLSERVER2012;user=sa;password=Gw_123;integrated security=false");
*/
      return dataSource;
	  }


	  @Bean
	  public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
	    return new JpaTransactionManager(emf);
	  }

	  @Bean
	  public JpaVendorAdapter jpaVendorAdapter() {
	    HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
	    jpaVendorAdapter.setDatabase(Database.POSTGRESQL);
	    //jpaVendorAdapter.setDatabase(Database.DEFAULT);
	    jpaVendorAdapter.setGenerateDdl(true);
	    return jpaVendorAdapter;
	  }

	  @Bean
	  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		//Properties properties = System.getProperties();
	    //properties.setProperty("derby.system.home", "C:\\\\metaBook\\db");
	    LocalContainerEntityManagerFactoryBean lemfb = new LocalContainerEntityManagerFactoryBean();
	    lemfb.setDataSource(dataSource());

	    lemfb.setJpaVendorAdapter(jpaVendorAdapter());
	    lemfb.setPackagesToScan(new String[] {"org.metabook.repository.book","org.metabook.repository.core"});
	    lemfb.setJpaProperties(additionalProperties());
	    return lemfb;
	  }


	   Properties additionalProperties() {
		      Properties properties = new Properties();
		      properties.setProperty("hibernate.hbm2ddl.auto", "update"); //"create-drop" //update
		      //properties.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
		      properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");		      
		      properties.setProperty("hibernate.event.merge.entity_copy_observer","allow"); 
			  //properties.setProperty("hibernate.ConnectionURL","jdbc:postgresql://127.12.154.129:15200/bookblast");
			 // properties.setProperty("hibernate.ConnectionURL","jdbc:postgresql://127.0.0.1:5432/bookblast");			   
		      //properties.setProperty("hibernate.ConnectionURL","jdbc:sqlserver://127.0.0.1:2012;databaseName=metaBook;instance=SQLSERVER2012;user=sa;password=Gw_123;integrated security=false");
		      return properties;
		   }
	   
	   @Bean
	   public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
	      return new PersistenceExceptionTranslationPostProcessor();
	   }
	 
	   
	   
}
