package com.ehealth.doctors.controller;

import com.ehealth.doctors.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class ClinicController {

    @Autowired
    private ClinicService clinicService;
}