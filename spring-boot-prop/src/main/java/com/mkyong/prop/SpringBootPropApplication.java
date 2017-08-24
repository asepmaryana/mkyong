package com.mkyong.prop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootPropApplication {
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootPropApplication.class, args);
		AppProperties prop = ctx.getBean(AppProperties.class);
		System.out.println("App: "+prop.getMenus());
	}
}
