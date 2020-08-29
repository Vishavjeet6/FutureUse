package com.nagarro.Course.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.nagarro.Course.delegate.CourseDelegate;
import com.nagarro.Course.utils.RecordNotFoundException;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CourseController.class)
class CourseControllerTest {
	
	@MockBean
	private CourseDelegate courseDelegate;

	@Test
	void deleteCourseValidId() throws Exception {    		
		Mockito
			.doNothing()
			.when(courseDelegate)
			.deleteById(ArgumentMatchers.anyString());
		courseDelegate.deleteById(ArgumentMatchers.anyString());
		int status = 200;
		assertEquals(200, status);
	}
	
	@Test
	void deleteCourseNonNumericalId() throws Exception {    		
		Mockito
			.doThrow(new RecordNotFoundException("Please Enter ID in numerical format"))
			.when(courseDelegate)
			.deleteById(ArgumentMatchers.anyString());
		Exception exception = assertThrows(RecordNotFoundException.class, () -> courseDelegate.deleteById(ArgumentMatchers.anyString()));
		assertEquals("Please Enter ID in numerical format", exception.getMessage());
	}
	
	@Test
	void deleteCourseNullId() throws Exception {    		
		Mockito
			.doThrow(new RecordNotFoundException("ID passed is null"))
			.when(courseDelegate)
			.deleteById(ArgumentMatchers.isNull());
		Exception exception = assertThrows(RecordNotFoundException.class, () -> courseDelegate.deleteById(ArgumentMatchers.isNull()));
		assertEquals("ID passed is null", exception.getMessage());
	}
	
	@Test
	void deleteCourseInvalidId() throws Exception {    		
		Mockito
			.doThrow(new RecordNotFoundException("Record not found for the ID :id"))
			.when(courseDelegate)
			.deleteById(ArgumentMatchers.anyString());
		Exception exception = assertThrows(RecordNotFoundException.class, () -> courseDelegate.deleteById(ArgumentMatchers.anyString()));
		assertEquals("Record not found for the ID :id", exception.getMessage());
	}
}
