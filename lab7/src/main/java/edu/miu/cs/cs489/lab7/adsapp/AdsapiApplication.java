package edu.miu.cs.cs489.lab7.adsapp;

import edu.miu.cs.cs489.lab7.adsapp.dto.address.AddressRequest;
import edu.miu.cs.cs489.lab7.adsapp.dto.patient.PatientRequest;
import edu.miu.cs.cs489.lab7.adsapp.model.Address;
import edu.miu.cs.cs489.lab7.adsapp.model.Patient;
import edu.miu.cs.cs489.lab7.adsapp.service.AddressService;
import edu.miu.cs.cs489.lab7.adsapp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class AdsapiApplication implements CommandLineRunner{
    @Autowired
    private PatientService patientService;
    @Autowired
    private AddressService addressService;

    public static void main(String[] args) {
        SpringApplication.run(AdsapiApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello RESTful Web API");
        //      ====================  Addresses ========================

        var fairfield = new AddressRequest("123 N court","fairfield", "iowa", "52556");
        var fairfield2 = new AddressRequest("123 F Lib","fairfield", "iowa", "52556");
        var greenVill = new AddressRequest("24 Green","greenV", "Greece", "52566");
        var miami = new AddressRequest("56 M Miam","miami", "Florida", "40006");
        var newArk = new AddressRequest("409 newA ", "NewArk", "NA", "59996");


//      ====================  Patients ========================
        var gillian = new PatientRequest( "Gillian", fairfield);
//        var savedGillian = this.patientService.addPatient(gillian);

        var jill = new PatientRequest("Jill", greenVill);
        var ian = new PatientRequest("Ian", miami);
        var john = new PatientRequest( "John",  newArk);
        var john2 = new PatientRequest( "Hoes", newArk);
patientService.addNewPatient(jill);
patientService.addNewPatient(ian);
patientService.addNewPatient(john);
        patientService.addNewPatient(gillian);

        System.out.println(" ADS Dental Surgeries Appointments management system WebAPI server. Starting...");
        System.out.println(" ADS Dental Surgeries Appointments management system WebAPI server. Started.\nRunning Apache Tomcat service and Listening for HTTP Request on Port number, 8080");
        System.out.println("To see list of Patients, send HTTP GET Request to the URI,\nhttp://localhost:8080/adsweb/api/v1/patient/list");

    }
}
