package com.nagarro.CSVToPDF.delegate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.nagarro.CSVToPDF.exception.CSVException;
import com.nagarro.CSVToPDF.service.CSVToPDFService;


@Component
public class CSVToPDFDelegate {
	
	@Autowired
	private CSVToPDFService csvToPdfService;
	
	public ResponseEntity<byte[]> 
	convertCSVToPDF(MultipartFile file) 
	throws CSVException{
		if(file.isEmpty()) {
			throw new CSVException("There is no file");
		}
		if(!csvToPdfService.checkValidCSV(file)) {
			throw new CSVException("Please upload only CSV file");
		}else{
			return csvToPdfService.convertCsvToPdf(file);
		}
	}
}
