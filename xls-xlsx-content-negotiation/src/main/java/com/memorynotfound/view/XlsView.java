package com.memorynotfound.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.memorynotfound.exporter.CitiesXlsExporter;
import com.memorynotfound.exporter.CourseXlsExporter;

public class XlsView extends AbstractXlsView {

    //private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance(DateFormat.SHORT);

    @Override
    protected void buildExcelDocument(Map<String, Object> model,
                                      Workbook workbook,
                                      HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
    	
    	String viewName = (String) model.get("viewName");
    	System.out.println("viewName = "+viewName);
    	
    	if(viewName.equals("courses")) 
    		CourseXlsExporter.export("courses.xls", model, workbook, response);
    	else if(viewName.equals("cities")) 
    		CitiesXlsExporter.export("cities.xls", model, workbook, response);
    	
    	/*
        // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"my-xls-file.xls\"");

        @SuppressWarnings("unchecked")
        List<Course> courses = (List<Course>) model.get("courses");

        // create excel xls sheet
        Sheet sheet = workbook.createSheet("Spring MVC AbstractXlsView");

        // create header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("ID");
        header.createCell(1).setCellValue("Name");
        header.createCell(2).setCellValue("Date");

        // Create data cells
        int rowCount = 1;
        for (Course course : courses){
            Row courseRow = sheet.createRow(rowCount++);
            courseRow.createCell(0).setCellValue(course.getId());
            courseRow.createCell(1).setCellValue(course.getName());
            courseRow.createCell(2).setCellValue(DATE_FORMAT.format(course.getDate()));
        }
        */
    }
}