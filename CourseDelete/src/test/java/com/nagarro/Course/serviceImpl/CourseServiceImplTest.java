package com.nagarro.Course.serviceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.nagarro.Course.repository.CourseRepository;

@ExtendWith(MockitoExtension.class)
class CourseServiceImplTest {
	
	@Mock
	CourseRepository courseRepository;

	@InjectMocks
	CourseServiceImpl courseServiceImpl;

	@Test
	public void unitTest() {
		courseServiceImpl.deleteCourseById(1L);
		Mockito.verify(courseRepository).deleteById(1L);
	}
}
