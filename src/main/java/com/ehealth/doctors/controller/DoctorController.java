package com.ehealth.doctors.controller;

import com.ehealth.doctors.entity.Doctor;
import com.ehealth.doctors.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Doctor> getBy(UUID id) {
        Doctor doctor = doctorService.getBy(id);
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

    @GetMapping(value = {"", "/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Doctor>> getAll() {
        Iterable<Doctor> doctors = doctorService.list();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @GetMapping(value = {"generate", "generate/"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Doctor> generate() {
        Doctor doc = doctorService.testGenerate();
        return new ResponseEntity<>(doc, HttpStatus.OK);
    }
}