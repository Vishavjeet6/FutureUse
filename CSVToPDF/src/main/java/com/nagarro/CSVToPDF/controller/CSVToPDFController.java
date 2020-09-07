package com.nagarro.CSVToPDF.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nagarro.CSVToPDF.delegate.CSVToPDFDelegate;
import com.nagarro.CSVToPDF.exception.CSVException;



@RestController
@RequestMapping("/api")
public class CSVToPDFController{
	
	@Autowired
	private CSVToPDFDelegate delegate;
	
	@PostMapping("/upload")
	public ResponseEntity<byte[]>
		csvToPdf(@RequestParam("file") MultipartFile file)
				throws CSVException{
		return delegate.convertCSVToPDF(file);
	}
}