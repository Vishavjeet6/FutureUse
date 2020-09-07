package com.nagarro.CSVToPDF.utils;


import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

public class CSVHelper {
	  public static String[] TYPE = {
			  "application/vnd.ms-excel",
			  "text/csv"
			  };
	  
	  public static boolean hasCSVFormat(MultipartFile file) {
		  if(Arrays.asList(TYPE).contains(file.getContentType())){
		      return true;
		    }
		  return false;
	  }
}
