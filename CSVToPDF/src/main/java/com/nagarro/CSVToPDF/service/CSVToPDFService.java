package com.nagarro.CSVToPDF.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface CSVToPDFService {
	boolean checkValidCSV(MultipartFile file);
	ResponseEntity<byte[]> convertCsvToPdf(MultipartFile file);
}
