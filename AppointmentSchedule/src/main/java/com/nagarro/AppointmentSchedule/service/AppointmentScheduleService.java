package com.nagarro.AppointmentSchedule.service;

import java.util.List;

import com.nagarro.AppointmentSchedule.entity.AppointmentScheduleEntity;
import com.nagarro.AppointmentSchedule.utils.RecordNotFoundException;

public interface AppointmentScheduleService {

	List<AppointmentScheduleEntity> findAllAppointment() throws RecordNotFoundException;

	void deleteAppointmentById(Long id) throws RecordNotFoundException;

}
