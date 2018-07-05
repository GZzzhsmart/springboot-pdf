package com.example.demo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.PdfFileRequest;
import com.example.demo.service.PdfFileCreator;

@RestController
public class PdfController {
	
	private final PdfFileCreator pdfFileCreator;
	
	@Autowired
	public PdfController(PdfFileCreator pdfFileCreator) {
		this.pdfFileCreator = pdfFileCreator;
	}
	
	@RequestMapping(value = "/api/pdf", method = RequestMethod.POST)
	public void createPdf(@RequestBody PdfFileRequest fileRequest, HttpServletResponse response) {
		pdfFileCreator.writePdfToResponse(fileRequest, response);
	}
	

}
