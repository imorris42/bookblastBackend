package org.metabook.server;

import org.junit.Test;
import org.metabook.server.config.MetabookServerAppConfig;
//import org.metabook.server.springboot.MetabookServerConfigContext.ApplicationConfiguration;
//import org.metabook.server.springboot.MetabookServerConfigContext.WebConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.repository.support.Repositories;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
/**
 * Integration test to bootstrap the root {@link ApplicationContext}.
 * 
 * @author 
ian Morris
 */
public class ApplicationIntegrationTest {

	@Test
	public void initializesRootApplicationContext() {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {

			context.register(MetabookServerAppConfig.class);
			context.refresh();

			new Repositories(context);
		}
	}

	@Test
	public void initializesWebApplicationContext() {

		try (AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext()) {

			applicationContext.register(MetabookServerAppConfig.class);
			applicationContext.setServletContext(new MockServletContext());
			applicationContext.refresh();
		}
	}
}
