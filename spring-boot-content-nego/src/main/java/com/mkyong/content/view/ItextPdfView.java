package com.mkyong.content.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mkyong.content.model.Fruit;

public class ItextPdfView extends AbstractPdfView {
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, 
			Document document, 
			PdfWriter writer,
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		@SuppressWarnings("unchecked")
		List<Fruit> fruits = (List<Fruit>) model.get("fruits");
		 
		PdfPTable table = new PdfPTable(3);
		table.setWidths(new int[] { 20, 50, 100 });
		 
		table.addCell("No");
		table.addCell("Name");
		table.addCell("Provided by");
		 
		for (Fruit fruit : fruits) {
			table.addCell(String.valueOf(fruit.getId()));
			table.addCell(fruit.getName());
			table.addCell(fruit.getProduceBy());
		}
		 
		document.add(table);
	}

}
