package com.virtualpairprogrammers.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.virtualpairprogrammers.domain.Book;

public class BooksReportPDF extends AbstractPdfView {

	@Override
	protected void buildPdfDocument
			(Map<String, Object> model, 
			Document doc, 
			PdfWriter writer, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception
	{
		List<Book> books = (List<Book>) model.get("allBooks");
		
		PdfPTable table = new PdfPTable(3);
		
		for (Book next : books)
		{
//			doc.add(new Paragraph(next.getTitle()));
			table.addCell(next.getTitle());
			table.addCell(next.getAuthor());
			table.addCell("" + next.getPrice());
		}
		
		doc.add(table);
	}

}
