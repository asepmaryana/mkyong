package com.memorynotfound.exporter;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.memorynotfound.model.City;

public class CitiesXlsExporter {
	
	public static void export(String fileName, 
			Map<String, Object> model, 
			Workbook workbook, 
			HttpServletResponse response) {
		
		// change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"\"");

        @SuppressWarnings("unchecked")
        List<City> cities = (List<City>) model.get("cities");

        // create excel xls sheet
        Sheet sheet = workbook.createSheet("Cities");

        // create header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Kode");
        header.createCell(1).setCellValue("Nama");
        header.createCell(2).setCellValue("Provinsi");

        // Create data cells
        int rowCount = 1;
        for (City c : cities){
            Row courseRow = sheet.createRow(rowCount++);
            courseRow.createCell(0).setCellValue(c.getKode());
            courseRow.createCell(1).setCellValue(c.getNama());
            courseRow.createCell(2).setCellValue(c.getProvinsi());
        }
        
	}
	
}
