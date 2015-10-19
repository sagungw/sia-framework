package com.sia.main.web;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@Configuration
@ImportResource({"/WEB-INF/spring-beans/servlet/sia-modul-servlet.xml"})
public class ServletConfiguration implements ApplicationContextAware {

	private AnnotationConfigWebApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = (AnnotationConfigWebApplicationContext) applicationContext;
		this.applicationContext.scan("com.sia.main.web.kontroler");
	}

}
