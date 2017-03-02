package com.ehealth.doctors.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.ehealth.doctors.dao.IClinicDAO;
import com.ehealth.doctors.model.entity.Clinic;

/**
 * Created by vilyam on 17.02.17.
 */
@Service
public class ClinicService {
	@Autowired
	private IClinicDAO iClinicDAO;

	@PostAuthorize("hasRole('ROLE_ADMIN')")
	public Clinic getBy(UUID id) {
		return iClinicDAO.findOne(id);
	}

	@PostAuthorize("hasRole('ROLE_USER')")
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
