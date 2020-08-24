package com.nagarro.AppointmentSchedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.AppointmentSchedule.entity.AppointmentScheduleEntity;

@Repository
public interface AppointmentScheduleRepository extends JpaRepository<AppointmentScheduleEntity, Long>{

}
