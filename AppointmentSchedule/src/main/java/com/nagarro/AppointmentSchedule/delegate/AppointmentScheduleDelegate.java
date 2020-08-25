package com.nagarro.AppointmentSchedule.delegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nagarro.AppointmentSchedule.entity.AppointmentScheduleEntity;
import com.nagarro.AppointmentSchedule.service.AppointmentScheduleService;
import com.nagarro.AppointmentSchedule.utils.RecordNotFoundException;

@Component
public class AppointmentScheduleDelegate {
	
	@Autowired
	AppointmentScheduleService appointmentScheduleService;
	
	public List<AppointmentScheduleEntity> findAllAppointment() 
			throws RecordNotFoundException{
		List<AppointmentScheduleEntity> appointments = appointmentScheduleService.findAllAppointment();
		if(appointments.isEmpty()) {
			throw new RecordNotFoundException("No appointments");
		}
		return appointments;
	}

	public void deleteAppointmentById(Long id) 
			throws RecordNotFoundException{
		if(id == null) {
			throw new RecordNotFoundException("Id passed is null");
		}
		appointmentScheduleService.deleteAppointmentById(id);
		
	}
	

}
