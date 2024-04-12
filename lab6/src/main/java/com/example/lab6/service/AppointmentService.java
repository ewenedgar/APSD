package com.example.lab6.service;

import com.example.lab6.model.Appointment;
import com.example.lab6.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    Appointment addNewAppointment(Appointment newAppointment){
        return appointmentRepository.save(newAppointment);
    }
}
