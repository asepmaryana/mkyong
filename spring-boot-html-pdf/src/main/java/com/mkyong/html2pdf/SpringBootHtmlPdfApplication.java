package com.mkyong.html2pdf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@SpringBootApplication
public class SpringBootHtmlPdfApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHtmlPdfApplication.class, args);
	}
	
	@Bean
	public ClassLoaderTemplateResolver emailTemplateResolver() {
		ClassLoaderTemplateResolver emailTemplateResolver=new ClassLoaderTemplateResolver();
	    emailTemplateResolver.setPrefix("templates/");
	    emailTemplateResolver.setTemplateMode("HTML5");
	    emailTemplateResolver.setSuffix(".html");
	    emailTemplateResolver.setTemplateMode("XHTML");
	    emailTemplateResolver.setCharacterEncoding("UTF-8");
	    emailTemplateResolver.setOrder(1);
	    return emailTemplateResolver;
	}
}
