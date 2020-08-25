package com.nagarro.Demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.Demo.delegate.CourseDelegate;
import com.nagarro.Demo.utils.RecordNotFoundException;

@RestController
@RequestMapping("/api")
public class CourseController {
	
	@Autowired
	private CourseDelegate delegate;
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>
		deleteCourseById(@PathVariable(value = "id") String id)
				throws RecordNotFoundException {
			delegate.deleteById(id);
			return ResponseEntity.noContent().build();
	}
}
