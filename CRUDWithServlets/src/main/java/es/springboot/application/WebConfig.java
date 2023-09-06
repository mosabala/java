package es.springboot.application;

import javax.servlet.http.HttpServlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.springboot.application.servlets.SvPersonas;

@Configuration
public class WebConfig {
	 @Bean	
	   public ServletRegistrationBean<HttpServlet> userServlet() {
		   ServletRegistrationBean<HttpServlet> servRegBean = new ServletRegistrationBean<>();
		   servRegBean.setServlet(new SvPersonas());
		   servRegBean.addUrlMappings("/SvPersonas/*");
		   //servRegBean.setLoadOnStartup(1);
		   return servRegBean;
	   }

}
