package com.nagarro.AppointmentSchedule.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.nagarro.AppointmentSchedule.entity.AppointmentScheduleEntity;
import com.nagarro.AppointmentSchedule.repository.AppointmentScheduleRepository;
import com.nagarro.AppointmentSchedule.service.AppointmentScheduleService;
import com.nagarro.AppointmentSchedule.utils.RecordNotFoundException;

@Service
public class AppointmentScheduleServiceImpl implements AppointmentScheduleService {
	
	@Autowired
	AppointmentScheduleRepository appointmentScheduleRepository;

	@Override
	public List<AppointmentScheduleEntity> findAllAppointment() throws RecordNotFoundException {
		return appointmentScheduleRepository.findAll();
	}

	@Override
	public void deleteAppointmentById(Long id) throws RecordNotFoundException {
		try {
			appointmentScheduleRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new RecordNotFoundException("Record not found for the ID " + id);
		}	
	}	
}
