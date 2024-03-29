package main.java.app;

import main.java.app.Authenticator.OAuthAuthenticator;
import main.java.app.controllers.Accounts;
import main.java.app.controllers.HomeController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class ApplicationContextConfig {
	
	private static final Logger logger = LoggerFactory
			.getLogger(OAuthAuthenticator.class);
	
	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean(name = "/")
	public Controller getHomeController() {
		return new HomeController();
	}
}