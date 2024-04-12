package com.example.lab6;

import com.example.lab6.model.*;
import com.example.lab6.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class Lab6Application implements CommandLineRunner {
    private PatientService patientService;
    private DentistService dentistService;
    private SurgeryService surgeryService;
    @Autowired
    private AddressService addressService;
    private AppointmentService appointmentService;
    Lab6Application(PatientService patientService, DentistService dentistService, SurgeryService surgeryService, AppointmentService appointmentService){
        this.patientService = patientService;
        this.dentistService = dentistService;
        this.surgeryService = surgeryService;
        this.appointmentService = appointmentService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Lab6Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //      ====================  Addresses ========================

        var fairfield = new Address("fairfield", "iowa", "52556");
        var greenVill = new Address("greenV", "Greece", "52566");
        var miami = new Address("miami", "Florida", "40006");
        var newArk = new Address("NewArk", "NA", "59996");


//      ====================  Patients ========================
        var gillian = new Patient(null, "Gillian", "White","john@gmail.com" , "(233) 889 984",
                 LocalDate.of(1994, 2, 23), null);
//        var savedGillian = this.patientService.addPatient(gillian);

        var jill = new Patient(null, "Jill", "Bell","jill@gmail.com" , "(233) 889 984",
                 LocalDate.of(1994, 2, 23),
                 null);
        var savedJill = this.patientService.addNewPatient(jill);

        var ian = new Patient(null, "Ian", "MacKay","ian@gmail.com" , "(233) 889 984",
                LocalDate.of(1994, 2, 23),
                 null);
        var savedIan = this.patientService.addNewPatient(ian);

        var john = new Patient(null, "John", "Walker","johnwalker@gmail.com" , "(233) 889 984",
                LocalDate.of(1994, 2, 23),
                 null);
        var savedJohn = this.patientService.addNewPatient(john);


//       ================== Dentist ========================
        var tony = new Dentist(null, "Tony", "Smith",
                "tony@gmail.com", "(900) 324 223");
//       var savedTony = this.dentistService.addDentist(tony);

        var helen = new Dentist(null, "Helen", "Pearson",
                "helen@gmail.com", "(900) 324 223");
        var savedHelen = this.dentistService.addNewDentist(helen);

        var robin = new Dentist(null, "Robin", "Plevin",
                "robin@gmail.com", "(900) 324 223");
        var savedRobin = this.dentistService.addNewDentist(robin);

//      ======== Surgery =============

        var surgery1 = new Surgery("Mount Pleasant Surgeons");
        surgery1.setLocation_address(miami);
//       var savedSurgery1 = this.surgeryService.addSurgery(surgery1);

//     =========== Appointement ===============
        var appointment1 = new Appointment(LocalDateTime.of(2024, 5, 10,3, 0)  );
        appointment1.setSurgery(surgery1);
        appointment1.setPatient(jill);
        appointment1.setDentist(robin);

    }
}
