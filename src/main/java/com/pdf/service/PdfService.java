package com.pdf.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;

import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class PdfService {

	// take this Logger and LoggerFacttory as a SL4J
	private Logger logger = LoggerFactory.getLogger(PdfService.class);

	public ByteArrayInputStream createPdf() {

		logger.info("Create PDF Started : ");

		String title = "Welcome To HDFC Bank";
		String content = "Open Your Account & Male Payment Easy";

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		// Document take as loggie.text ..... Document is a Class
		Document document = new Document();

		// whatever we write in document it will get into the out
		PdfWriter.getInstance(document, out);

		document.open();

		Font titlefont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20);

		// Paragraph is a Class
		Paragraph titlepara = new Paragraph(title, titlefont);
		titlepara.setAlignment(Element.ALIGN_CENTER);
		document.add(titlepara);

		Font parafont = FontFactory.getFont(FontFactory.HELVETICA, 16);
		Paragraph paragraph = new Paragraph(content);
		paragraph.add(new Chunk("HDFC bank is India's private Top Bank"));
		document.add(paragraph);

		document.close();

		return new ByteArrayInputStream(out.toByteArray());

	}

}
