package com.ehealth.doctors.service;

import com.ehealth.doctors.dao.IClinicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vilyam on 17.02.17.
 */
@Service
@Transactional
public class ClinicService {
    @Autowired
    private IClinicDAO iClinicDAO;
}
