package com.pdf.controller;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pdf.service.PdfService;

@Controller
@RequestMapping("/pdf")
public class PDFController {

	@Autowired
	private PdfService pdfService;

	@GetMapping("/createPDF")
	public ResponseEntity<InputStreamResource> createPDF() {

		
		ByteArrayInputStream pdf = pdfService.createPdf();
		HttpHeaders httpheaders = new HttpHeaders();
		httpheaders.add("Content-Disposition", "inline;file=lcwd.pdf");
		return ResponseEntity.ok().headers(httpheaders).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(pdf));

	}

}
