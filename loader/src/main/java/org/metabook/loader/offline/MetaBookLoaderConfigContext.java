package org.metabook.loader.offline;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.ProcessorDefinition;
import org.apache.camel.osgi.SpringCamelContextFactory;
import org.apache.camel.impl.BreakpointSupport;
import org.apache.camel.impl.ConditionSupport;
import org.apache.camel.spring.SpringCamelContext;
//import org.apache.camel.spring.boot.CamelSpringBootApplicationController;
//import org.apache.camel.spring.boot.FatJarRouter;
import org.apache.camel.spring.javaconfig.CamelConfiguration;
import org.apache.camel.spring.javaconfig.SingleRouteCamelConfiguration;
import org.apache.commons.dbcp2.BasicDataSource;
/*import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;*/
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.apache.camel.spring.Main;
//@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"org.metabook.repository.book"})
@ComponentScan(basePackages = {"org.metabook.repository.book","org.metabook.repository.core", "org.metabook.loader.offline.route"})
//@SpringBootApplication
@Configuration
//@EnableAutoConfiguration
public class MetaBookLoaderConfigContext extends SingleRouteCamelConfiguration {//extends FatJarRouter for spring boot{

	
	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
	private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
	private static final String PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setDriverClassName("org.postgresql.Driver");
		//dataSource.setUrl("jdbc:postgresql://56646b860c1e665852000108-bookblast.rhcloud.com:49821/bookblastrepository");
		//dataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/bookblastrepository");
		dataSource.setUrl("jdbc:postgresql://56646b860c1e665852000108-bookblast.rhcloud.com:49821/bookblastrepository");
		//dataSource.setUrl("jdbc:postgresql://127.0.0.1:49821/bookblastrepository");	
		// postgresql://adminh1ij96q:kEj6csnvkmLR@5661d2032d5271b83200014b-bookblast.rhcloud.com:35701/
		dataSource.setUsername("adminexrwixs");
		dataSource.setPassword("gPu4g-jrIPCX");
		dataSource.setDefaultAutoCommit(false);
		/*
		 * dataSource.setDriverClassName(
		 * "com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 * dataSource.setValidationQuery("select 1"); dataSource.setUrl(
		 * "jdbc:sqlserver://127.0.0.1:2012;databaseName=metaBook;instance=SQLSERVER2012;user=sa;password=Gw_123;integrated security=false"
		 * );
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
		// jpaVendorAdapter.setDatabase(Database.DEFAULT);
		jpaVendorAdapter.setGenerateDdl(true);
		jpaVendorAdapter.setShowSql(false);
		return jpaVendorAdapter;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lemfb = new LocalContainerEntityManagerFactoryBean();
		lemfb.setDataSource(dataSource());
		lemfb.setJpaVendorAdapter(jpaVendorAdapter());
		lemfb.setPackagesToScan(new String[] { "org.metabook.repository.book", "org.metabook.repository.core" });
		lemfb.setJpaProperties(additionalProperties());
		return lemfb;
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		// properties.setProperty("hibernate.hbm2ddl.auto", "update");
		// //"create-drop"
		// properties.setProperty("hibernate.dialect",
		// "org.hibernate.dialect.SQLServerDialect");
		properties.setProperty("hibernate.event.merge.entity_copy_observer", "allow");
		properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
		properties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, "update");//"create-drop");
		properties.put(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY, "org.hibernate.cfg.ImprovedNamingStrategy");
		properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, false);
		properties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, true);

		//properties.setProperty("hibernate.ConnectionURL","jdbc:postgresql://127.0.0.1:5432/bookblast;user=adminexrwixs;password=gPu4g-jrIPCX");
		// properties.setProperty("hibernate.ConnectionURL","jdbc:postgresql://db-bookblast.rhcloud.com:5432/bookblast");
		// properties.setProperty("hibernate.ConnectionURL","jdbc:sqlserver://127.0.0.1:2012;databaseName=metaBook;instance=SQLSERVER2012;user=sa;password=Gw_123;integrated
		// security=false");
		return properties;
	}

	   @Bean
	   public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
	      return new PersistenceExceptionTranslationPostProcessor();
	   }
	   
	    public static void main(String[] args) throws Exception {
	        new Main().run(args);
	    }
	    /**
	     * Returns the CamelContext which support Spring
	     */
	    @Override
	    protected CamelContext createCamelContext() throws Exception {
	        return new SpringCamelContext(getApplicationContext());
	    }
	   // public static void main(String... args) {
/*	  For sping boot      ApplicationContext applicationContext = new SpringApplication(MetaBookLoaderConfigContext.class).run(args);
	        CamelSpringBootApplicationController applicationController =
	                applicationContext.getBean(CamelSpringBootApplicationController.class);
	        applicationController.blockMainThread();*/
	    //}
	   

	/**
	 * Returns the CamelContext which support OSGi
	 */
/*	@Override
	protected CamelContext createCamelContext() throws Exception {
		SpringCamelContextFactory factory = new SpringCamelContextFactory();
		factory.setApplicationContext(getApplicationContext());
		return factory.createContext();
	}*/

/*	   @Override
	    protected CamelContext createCamelContext() throws Exception {
	        return new SpringCamelContext(getApplicationContext());
	    }
	     
	    @Override
	    protected void setupCamelContext(CamelContext camelContext) throws Exception {

	    	camelContext.start();
	    }
	 */
	    
//	@Override
/*	protected void setupCamelContext(CamelContext camelContext)
			throws Exception {	
		
		camelContext.setDebugger(new DefaultDebugger());
		camelContext.getDebugger()
				.addSingleStepBreakpoint(this.getBreakpointSupport(), this.getDebugCondition());		
	}*/

	public void afterPropertiesSet() throws Exception {
		// just to make SpringDM happy do nothing here
	}
	
/*	@Bean
	public Mongo mongo() throws Exception {
	    return new MongoClient("localhost", 27017);
	}
*/
	private ConditionSupport getDebugCondition() {
		return new ConditionSupport() {
			public boolean matchProcess(Exchange exchange, Processor processor,
					ProcessorDefinition  definition) {
				return "file:///tmp/etl/metabook/offline/in/".equals(exchange.getFromRouteId());
			}
		};
	}

	private BreakpointSupport getBreakpointSupport(){
		return new BreakpointSupport() {
		    public void beforeProcess(Exchange exchange, Processor processor, ProcessorDefinition definition) {
		    //	TransactionsAccount body = exchange.getIn().getBody(TransactionsAccount.class);
		  //   System.out.println("Breakpoint at " + definition + " with body: " + body);
		    }
		};
	}

	@Override
	public RouteBuilder route() {
		 return new RouteBuilder() {
	            @SuppressWarnings("deprecation")
				public void configure() {
        from("file:///tmp/etl/metabook/offline/in/").      
        doTry().
    	to("bean:bookProcessor").
    	split().
    	body().
	    to("jpa://org.metabook.repository.book.Book?usePersist=false").endDoTry().
        doCatch(IllegalStateException.class).
    	log("exception  is {$exceptionMessage}").handled(true).
    	doCatch(Exception.class).log("WATCH Unknown exception thrown  {$exceptionMessage} ").handled(true).
    	stop().
    	end();
	            }
		 
	};
	}
}