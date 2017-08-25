package com.memorynotfound.view;

import java.text.DateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.memorynotfound.model.Course;

public class ItextPdfView extends AbstractPdfView {
	
	private static final DateFormat DATE_FORMAT = DateFormat.getDateInstance(DateFormat.SHORT);
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		@SuppressWarnings("unchecked")
		List<Course> courses = (List<Course>) model.get("courses");
		 
		PdfPTable table = new PdfPTable(3);
		table.setWidths(new int[] { 20, 100, 50 });
		 
		table.addCell("ID");
		table.addCell("Name");
		table.addCell("Date");
		 
		for (Course c : courses) {
			table.addCell(String.valueOf(c.getId()));
			table.addCell(c.getName());
			table.addCell(DATE_FORMAT.format(c.getDate()));
		}
		 
		document.add(table);
	}

}
