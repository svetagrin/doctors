package com.ehealth.doctors.service;

import com.ehealth.doctors.dao.IClinicDAO;
import com.ehealth.doctors.model.entity.Clinic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by vilyam on 17.02.17.
 */
@Service
public class ClinicService {
    @Autowired
    private IClinicDAO iClinicDAO;

    public Clinic getBy(UUID id) {
        return iClinicDAO.findOne(id);
    }

    public Iterable<Clinic> list() {
        return iClinicDAO.findAll();
    }

    public void save(Clinic clinic) {
        iClinicDAO.save(clinic);
    }

    public void create(Clinic clinic) {
        iClinicDAO.save(clinic);
    }
}
