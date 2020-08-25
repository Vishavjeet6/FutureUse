package com.nagarro.AppointmentSchedule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.AppointmentSchedule.delegate.AppointmentScheduleDelegate;
import com.nagarro.AppointmentSchedule.entity.AppointmentScheduleEntity;
import com.nagarro.AppointmentSchedule.utils.RecordNotFoundException;


@RestController
@RequestMapping("/api")
public class AppointmentScheduleController {
	
	@Autowired
	private AppointmentScheduleDelegate delegate;
	
	@GetMapping("/get")
	public List<AppointmentScheduleEntity>
		getCourse()
				throws RecordNotFoundException {	
			return delegate.findAllAppointment();
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>
		deleteCourseById(@PathVariable(value = "id") Long id)
				throws RecordNotFoundException {
			delegate.deleteAppointmentById(id);
			return ResponseEntity.noContent().build();
	}
	
}
