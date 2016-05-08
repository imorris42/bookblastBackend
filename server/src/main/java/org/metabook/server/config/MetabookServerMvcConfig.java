package org.metabook.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.hateoas.UriTemplate;
import org.springframework.hateoas.hal.CurieProvider;
import org.springframework.hateoas.hal.DefaultCurieProvider;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.util.UrlPathHelper;

@EnableAsync
@EnableWebMvc
@EnableJpaRepositories(basePackages = {"org.metabook.repository.book"})
@EnableSpringDataWebSupport
@Import(MetabookServerAppConfig.class) 
@Configuration
/*@ComponentScan(excludeFilters = @Filter({ Service.class, Configuration.class }), useDefaultFilters = false, basePackages = {
		"org.metabook.repository.book.*",
		"org.metabook.repository.core.*",
		"org.metabook.repository.service.*",
		"org.metabook.server.api.book.engine.web.*"})*/
@ComponentScan(basePackages = {
		//"org.metabook.repository.book",
		//"org.metabook.repository.core",
		//"org.metabook.repository.service",
		"org.metabook.server.api.book"})


public class MetabookServerMvcConfig extends WebMvcConfigurerAdapter {
	public static String CURIE_NAMESPACE = "metabook";

/*	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
	configurer
	.setUseSuffixPatternMatch(true)
	.setUseTrailingSlashMatch(false)
	.setUseRegisteredSuffixPatternMatch(true)
	.setPathMatcher(antPathMatcher())
	.setUrlPathHelper(urlPathHelper());
	}
	
	@Bean
	public UrlPathHelper urlPathHelper() {
	return new UrlPathHelper();
	}*/
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {
	  registry.addResourceHandler("/assets/**").addResourceLocations("/assets/").
	  setCachePeriod(0);
	  registry.addResourceHandler("/static/**").addResourceLocations("/static/").
	  setCachePeriod(0);
	  registry.addResourceHandler("/vendor/**").addResourceLocations("/vendor/").
	  setCachePeriod(0);
	  registry.addResourceHandler("/js/**").addResourceLocations("/js/").
	  setCachePeriod(0); 
	  registry.addResourceHandler("/src/**").addResourceLocations("/src/").
	  setCachePeriod(0); 
	  registry.addResourceHandler("/templates-app.js").addResourceLocations("/templates-app.js").
	  setCachePeriod(0); 
	  registry.addResourceHandler("/templates-common.js").addResourceLocations("/templates-common.js").
	  setCachePeriod(0); 

      registry.addResourceHandler("/index.html").addResourceLocations("/index.html").
	  setCachePeriod(0); 

	 }
	 @Override
	 public void addViewControllers(ViewControllerRegistry registry) {
	     registry.addViewController("/").setViewName("forward:/index.html");
	 }
	 
	    @Bean
	    public ViewResolver getViewResolver() {
	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	        resolver.setPrefix("/");
	        resolver.setSuffix(".js");
	        return resolver;
	    }
	    
	 
	 // public void  configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) { configurer.enable(); }
	 

	@Bean
	public CurieProvider curieProvider() {
		return new DefaultCurieProvider(CURIE_NAMESPACE, new UriTemplate("http://localhost:8080/alps/{rel}"));
	}
}
