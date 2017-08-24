package com.mkyong.html2pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.context.SpringWebContext;
import org.xhtmlrenderer.pdf.ITextRenderer;

@Component
public class PdfGenaratorUtil {
	
	@Autowired
	private TemplateEngine templateEngine;
	
	@Autowired
	private ApplicationContext applicationContext; 
	
	public void createPdf(String templateName, Map map, HttpServletRequest request, HttpServletResponse response, ServletContext context) throws Exception {
		Assert.notNull(templateName, "The templateName can not be null");
		String path = request.getServletContext().getRealPath("/");
		SpringWebContext ctx = new SpringWebContext(request, response, context, request.getLocale(), map, applicationContext);
		if (map != null) {
			Iterator itMap = map.entrySet().iterator();
			while (itMap.hasNext()) {
				Map.Entry pair = (Map.Entry) itMap.next();
				ctx.setVariable(pair.getKey().toString(), pair.getValue());
			}
		}
		
		String processedHtml = templateEngine.process(templateName, ctx);
		  FileOutputStream os = null;
		  String fileName = UUID.randomUUID().toString();
	        try {
	            //final File outputFile = File.createTempFile(fileName, ".pdf");
	        	String file = path+fileName+".pdf";
	        	final File outputFile = new File(file);
	            os = new FileOutputStream(outputFile);

	            ITextRenderer renderer = new ITextRenderer();
	            renderer.setDocumentFromString(processedHtml);
	            renderer.layout();
	            renderer.createPDF(os, false);
	            renderer.finishPDF();
	            System.out.println("PDF created successfully: "+file);
	        }
	        finally {
	            if (os != null) {
	                try {
	                    os.close();
	                } catch (IOException e) { /*ignore*/ }
	            }
	        }
	}
}
