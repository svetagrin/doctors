package com.ehealth.doctors.dao;

import com.ehealth.doctors.model.entity.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IDoctorDAO extends CrudRepository<Doctor, UUID> {

}