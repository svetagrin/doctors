package com.ehealth.doctors.mock;

import com.ehealth.doctors.dao.IClinicDAO;
import com.ehealth.doctors.dao.IDoctorDAO;
import com.ehealth.doctors.model.entity.Clinic;
import com.ehealth.doctors.model.entity.ClinicDoctorBinding;
import com.ehealth.doctors.model.entity.Doctor;
import com.ehealth.doctors.model.entity.DoctorCertificate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by vilyam on 18.02.17.
 */
@Component
public class MockUtils {
    @Autowired
    private IDoctorDAO iDoctorDAO;

    @Autowired
    private IClinicDAO iClinicDAO;

    public Doctor testGenerateDoctor() {
        Clinic clinic = new Clinic();
        clinic.setName("hospital");
        clinic.setDateAdded(new Date());
        iClinicDAO.save(clinic);

        DoctorCertificate cert = new DoctorCertificate();
        cert.setName("temp");
        cert.setIssuedBy("goose");

        Doctor doc = new Doctor();
        doc.setDateUpdated(new Date());
        doc.setFname("yo");
        doc.setFormerSurname("uo");
        doc.setName("yo");
        doc.setSurname("yo");
        doc.addCertificate(cert);


        ClinicDoctorBinding binding = new ClinicDoctorBinding();

        binding.setClinic(clinic);
        binding.setDoctor(doc);

        clinic.addClinicDoctorBinding(binding);
        doc.addClinicDoctorBinding(binding);

        iDoctorDAO.save(doc);

        return doc;
    }
}
