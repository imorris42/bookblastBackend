package org.metabook.server.config;

import java.util.Set;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.metabook.server.cors.SimpleCORSFilter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MetabookInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

/*	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		 AnnotationConfigWebApplicationContext rootMiddleTierContext = getRootMiddleTierContext();

		rootMiddleTierContext.refresh(); 

		servletContext.addListener(new ContextLoaderListener(rootMiddleTierContext));
		servletContext.setInitParameter("defaultHtmlEscape", "true");   
		
		WebApplicationContext mvcServletContext = getMvcServletContext();
		
			   ServletRegistration.Dynamic appServlet = servletContext.addServlet(
		      "appServlet", new DispatcherServlet(mvcServletContext));
				appServlet.setLoadOnStartup(1);
		   Set<String> mappingConflicts = appServlet.addMapping("/");
		 
		   if (!mappingConflicts.isEmpty()) {
		      for (String s : mappingConflicts) {
		         logger.error("Mapping conflict: " + s);
		      }
		      throw new IllegalStateException(
		         "'appServlet' cannot be mapped to '/' under Tomcat versions <= 7.0.14");
		   }
        
	}*/

/*	@Override
	public void onStartup(ServletContext container) {
	ServletRegistration.Dynamic registration = container.addServlet("dispatcher", new
	DispatcherServlet());
	registration.setLoadOnStartup(1);
	registration.addMapping("/api/*");
	}
*/
	@Override
	public void onStartup(ServletContext servletContext)
	        throws ServletException {
	      FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("corsFilter", new SimpleCORSFilter());
	     //encodingFilter.setInitParameter("blah", "blah");
	      encodingFilter.addMappingForUrlPatterns(null, false, "/api/*");

	    super.onStartup(servletContext);
	}
    
	 private AnnotationConfigWebApplicationContext getMvcServletContext() {
	        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

	        context.register(org.metabook.server.config.MetabookServerMvcConfig.class);  // ,org.metabook.server.config.MetabookServerAppConfig");
	        //context.setConfigLocation("org.metabook.server.config.MetabookServerMvcConfig");
	        return context;
	    }
	 
	 private  AnnotationConfigWebApplicationContext getRootMiddleTierContext() {
		 AnnotationConfigWebApplicationContext context = new  AnnotationConfigWebApplicationContext();
		 context.register(org.metabook.server.config.MetabookServerAppConfig.class);
	     //context.setConfigLocation("org.metabook.server.config.MetabookServerAppConfig");  // ,org.metabook.server.config.MetabookServerAppConfig");
	        return context;
	    }

		@Override
		protected Class<?>[] getRootConfigClasses() {
			// return new Class[] {
			//return new Class[] {org.metabook.server.config.MetabookServerAppConfig.class};
			
			return null;
		}

		@Override
		protected Class<?>[] getServletConfigClasses() {

			// return null;
			return new Class[] {
					org.metabook.server.config.MetabookServerAppConfig.class
					,org.metabook.server.config.MetabookServerMvcConfig.class
					//,org.metabook.server.api.book.engine.web.PingController.class
					//,org.metabook.server.api.book.engine.web.BookController.class
					//,org.metabook.server.api.book.engine.web.EngineController.class
					//,org.metabook.repository.book.BookRepository.class
			};
			//return new Class[] { MetabookServerAppConfig.class, MetabookServerMvcConfig.class };
		}

		@Override
		protected String[] getServletMappings() {
			return new String[] { "/*" };
		}
	 
}
