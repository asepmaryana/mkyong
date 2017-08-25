package com.memorynotfound.config;

import com.memorynotfound.view.ItextPdfView;
import com.memorynotfound.view.XlsView;
import com.memorynotfound.view.XlsxStreamingView;
import com.memorynotfound.view.XlsxView;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.*;

@EnableWebMvc
@Configuration
@ComponentScan("com.memorynotfound")
public class WebConfig extends WebMvcConfigurerAdapter {

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
                new XlsView(),
                new XlsxView(),
                new XlsxStreamingView(),
                new ItextPdfView());
    }
}
