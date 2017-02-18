package com.ehealth.doctors.controller;

import com.ehealth.doctors.model.converter.OrikaBeanMapper;
import com.ehealth.doctors.model.dto.DoctorDTO;
import com.ehealth.doctors.model.entity.Doctor;
import com.ehealth.doctors.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/doctor",  produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public class DoctorController {

    private final DoctorService doctorService;

    private final OrikaBeanMapper mapper;

    @Autowired
    public DoctorController(OrikaBeanMapper mapper, DoctorService doctorService) {
        this.mapper = mapper;
        this.doctorService = doctorService;
    }

    @GetMapping(value = "/{id}")
    public DoctorDTO getById(@PathVariable UUID id) {
        Doctor doctor = doctorService.getBy(id);

        return mapper.map(doctor, DoctorDTO.class);
    }

    @GetMapping(value = {"", "/"})
    public Iterable<DoctorDTO> getAll() {
        Iterable<Doctor> doctors = doctorService.list();

        return mapper.mapAsList(doctors, DoctorDTO.class);
    }

    @PostMapping(value = {"", "/"})
    public DoctorDTO create(@RequestBody DoctorDTO doctorDto) throws Exception {
        if (doctorDto.getId() != null) throw new Exception();

        final Doctor doctor = mapper.map(doctorDto, Doctor.class);

        doctorService.save(doctor);

        return mapper.map(doctor, DoctorDTO.class);
    }

    @PutMapping(value = {"", "/"})
    public DoctorDTO update(@RequestBody DoctorDTO doctorDto) {
        final Doctor doctor = mapper.map(doctorDto, Doctor.class);

        doctorService.save(doctor);

        return mapper.map(doctor, DoctorDTO.class);
    }
}