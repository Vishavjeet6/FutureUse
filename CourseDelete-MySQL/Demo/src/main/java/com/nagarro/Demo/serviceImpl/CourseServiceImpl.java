package com.nagarro.Demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.nagarro.Demo.repository.CourseRepository;
import com.nagarro.Demo.service.CourseService;
import com.nagarro.Demo.utils.RecordNotFoundException;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public void deleteCourseById(Long id) throws RecordNotFoundException{
		if(id != null) {
			try {
				courseRepository.deleteById(id);
			} catch (EmptyResultDataAccessException e) {
				throw new RecordNotFoundException("Record not found for the ID " + id);
			}
		}else {
			throw new RecordNotFoundException("ID passed is null");
		}
		
	}
}
