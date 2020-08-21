package com.nagarro.Course.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.nagarro.Course.repository.CourseRepository;
import com.nagarro.Course.service.CourseService;
import com.nagarro.Course.utils.RecordNotFoundException;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public void deleteCourseById(Long id) throws RecordNotFoundException{
		try {
			courseRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new RecordNotFoundException("Record not found for the ID " + id);
		}		
	}
}
