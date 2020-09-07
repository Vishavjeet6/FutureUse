package com.nagarro.CSVToPDF.serviceImpl;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.nagarro.CSVToPDF.exception.CSVException;
import com.nagarro.CSVToPDF.service.CSVToPDFService;
import com.nagarro.CSVToPDF.utils.CSVHelper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

@Service
public class CSVToPDFServiceImpl implements CSVToPDFService {

	@Override
	public boolean checkValidCSV(MultipartFile file) throws CSVException{
		return CSVHelper.hasCSVFormat(file);
	}
	
	@Override
	public ResponseEntity<byte[]> convertCsvToPdf(MultipartFile file) {
		try {
			String fileName = file.getOriginalFilename();
			fileName = changeCSVExtensionToPDF(fileName);
			
			Document document = new Document(PageSize.A1);
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			PdfWriter pdfWriter = PdfWriter.getInstance(document, output);
			CSVReader reader = new CSVReader(new InputStreamReader(file.getInputStream()));
			
			document.open();
			
//			create table
			String [] header = reader.peek();
			int columns = header.length;
			PdfPTable pdfTable = new PdfPTable(columns);
			pdfTable.setWidthPercentage(100);
	        PdfPCell tableCell;
			String [] nextLine;		
			
//			write into table
			while ((nextLine = reader.readNext()) != null) {   
				for(int i=0; i<columns; i++) {
					tableCell=new PdfPCell(new Phrase(nextLine[i]));
				    pdfTable.addCell(tableCell);
				}  
			}
			reader.close();
			document.add(pdfTable);
			document.close();
			pdfWriter.close();
			
		    byte[] contents = output.toByteArray();
		    
		    HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.APPLICATION_PDF);
		    headers.setContentDispositionFormData(fileName, fileName);
		    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
		    
		    ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);
		    return response;
		
		} catch(DocumentException | IOException | CsvValidationException e) {
			throw new CSVException(e.getMessage());
		}

	}
	
	public String changeCSVExtensionToPDF(String fileName) {
		if (fileName.indexOf(".") > 0)
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
		return fileName+".pdf";
	}
}
