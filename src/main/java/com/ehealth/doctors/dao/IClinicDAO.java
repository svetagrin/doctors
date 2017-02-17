package com.ehealth.doctors.dao;

import com.ehealth.doctors.entity.Clinic;
import com.ehealth.doctors.entity.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IClinicDAO extends CrudRepository<Clinic, UUID> {

}