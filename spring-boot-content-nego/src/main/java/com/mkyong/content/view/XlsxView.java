package com.mkyong.content.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.mkyong.content.model.Fruit;

public class XlsxView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, 
			Workbook workbook, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		System.out.println("XlsxView - Requested: "+request.getRequestURI());
		
		// set the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"fruits.xlsx\"");
 
        @SuppressWarnings("unchecked")
        List<Fruit> fruits = (List<Fruit>) model.get("fruits");
 
        // create sheet
        Sheet sheet = workbook.createSheet("Fruits Xlsx");
 
        // create header
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("No");
        header.createCell(1).setCellValue("Name");
        header.createCell(2).setCellValue("Provided by");
 
        // Create cells
        int rowCount = 1;
        for (Fruit fruit : fruits){
            Row fruitRow = sheet.createRow(rowCount++);
            fruitRow.createCell(0).setCellValue(fruit.getId());
            fruitRow.createCell(1).setCellValue(fruit.getName());
            fruitRow.createCell(2).setCellValue(fruit.getProduceBy());
        }
	}

}
