package com.mkyong.pdf.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mkyong.pdf.GenerateExcelReport;
import com.mkyong.pdf.GeneratePdfReport;
import com.mkyong.pdf.model.City;
import com.mkyong.pdf.service.ICityService;

@RestController
public class CityController {
	
	@Autowired
    ICityService cityService;
	
	@RequestMapping(value="/cities", method=RequestMethod.GET)
	public List<City> cities() {
		return cityService.findAll();
	}
	
	@RequestMapping(value="/pdfreport", method=RequestMethod.GET, produces=MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> citiesReport() throws IOException {
		List<City> cities = (List<City>) cityService.findAll();
		
		ByteArrayInputStream bis = GeneratePdfReport.citiesReport(cities);
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");
        
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
	}
	
	@RequestMapping(value="/xlsreport", method=RequestMethod.GET)
	public ResponseEntity<InputStreamResource> citiesReportXls() throws IOException {
		
		ByteArrayInputStream bis = GenerateExcelReport.citiesReport();
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=ReportExcel.xlsx");
        
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(bis));
	}
}
