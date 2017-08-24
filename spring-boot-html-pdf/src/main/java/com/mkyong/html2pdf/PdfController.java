package com.mkyong.html2pdf;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PdfController {
	
	@Autowired
	PdfGenaratorUtil pdfGenaratorUtil;
	
	@RequestMapping(value = "/pdf", method = RequestMethod.GET)
	public void create(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<String, String> data = new HashMap<String,String>();
	    data.put("name","Asep Maryana");
	    data.put("baseUrl", request.getScheme() + "://" +
                			request.getServerName() +
                			":" + request.getServerPort());
	    pdfGenaratorUtil.createPdf("welcome", data, request, response, request.getServletContext());
	}
}
