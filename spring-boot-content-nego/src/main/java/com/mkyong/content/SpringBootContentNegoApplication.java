package com.mkyong.content;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mkyong.content.view.ItextPdfView;
import com.mkyong.content.view.XlsView;
import com.mkyong.content.view.XlsxStreamingView;
import com.mkyong.content.view.XlsxView;

@SpringBootApplication
public class SpringBootContentNegoApplication extends WebMvcConfigurerAdapter {
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer
        	.defaultContentType(MediaType.TEXT_HTML)
        	.parameterName("type")
        	.favorParameter(true)
        	.ignoreUnknownPathExtensions(false)
        	.ignoreAcceptHeader(false)
        	.useJaf(true);
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
        registry.enableContentNegotiation(
                new XlsxView(),
                new ItextPdfView());
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootContentNegoApplication.class, args);
	}
}
