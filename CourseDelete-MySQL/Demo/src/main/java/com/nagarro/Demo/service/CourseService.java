package com.nagarro.Demo.service;

import com.nagarro.Demo.utils.RecordNotFoundException;

public interface CourseService {

	void deleteCourseById(Long id) throws RecordNotFoundException;

}
