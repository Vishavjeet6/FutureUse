package com.nagarro.Course.delegate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.Course.service.CourseService;
import com.nagarro.Course.utils.RecordNotFoundException;

@Component
public class CourseDelegate {
	
	@Autowired
	private CourseService courseService;

	public void deleteById(String id) throws RecordNotFoundException{
		if(id==null) {
			throw new RecordNotFoundException("ID passed is null");
		}
		try {
			Long longId = Long.parseLong(id);
			courseService.deleteCourseById(longId);
		} catch (NumberFormatException e) {
			throw new RecordNotFoundException("Please Enter ID in numerical format");
		}	
	}
}
