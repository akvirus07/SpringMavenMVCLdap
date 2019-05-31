package com.gslab.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringWebInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext container=new AnnotationConfigWebApplicationContext();
		container.register(SpringWebConfiguration.class);
		container.setServletContext(servletContext);
		Dynamic servlet = servletContext.addServlet("spring", new DispatcherServlet(container));
		servlet.addMapping("/");
	        DispatcherServlet dv = 
			new DispatcherServlet(new GenericWebApplicationContext());
	
	ServletRegistration.Dynamic appServlet = servletContext.addServlet("testDemo1", dv);
		servlet.setLoadOnStartup(3);
	}
}
