package com.nagarro.Course.service;

import com.nagarro.Course.utils.RecordNotFoundException;

public interface CourseService {

	void deleteCourseById(Long id) throws RecordNotFoundException;

}
