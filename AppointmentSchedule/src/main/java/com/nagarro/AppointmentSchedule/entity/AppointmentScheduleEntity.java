package com.nagarro.AppointmentSchedule.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "appointment_schedule")
public class AppointmentScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String date;
    private String appointment;
    private String startTime;
    private String endTime;
    private String evaluatorId;
    private String userId;  
}
