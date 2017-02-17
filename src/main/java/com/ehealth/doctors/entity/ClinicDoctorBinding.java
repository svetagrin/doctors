package com.ehealth.doctors.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vilyam on 17.02.17.
 */

@Entity
@Table(name = "clinic_doctor")
@AssociationOverrides({
        @AssociationOverride(name = "pk.doctor", joinColumns = @JoinColumn(name = "doctor_id")),
        @AssociationOverride(name = "pk.clinic", joinColumns = @JoinColumn(name = "clinic_id"))})
public class ClinicDoctorBinding implements java.io.Serializable {

    @JsonIgnore
    @EmbeddedId
    private ClinicDoctorBindingId pk = new ClinicDoctorBindingId();

    @Column(name = "date_created")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;

    public ClinicDoctorBindingId getPk() {
        return pk;
    }

    public void setPk(ClinicDoctorBindingId pk) {
        this.pk = pk;
    }

    @Transient
    public Clinic getClinic() {
        return getPk().getClinic();
    }

    public void setClinic(Clinic clinic) {
        this.getPk().setClinic(clinic);
    }

    @JsonIgnore
    @Transient
    public Doctor getDoctor() {
        return getPk().getDoctor();
    }

    public void setDoctor(Doctor doctor) {
        this.getPk().setDoctor(doctor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClinicDoctorBinding)) return false;

        ClinicDoctorBinding that = (ClinicDoctorBinding) o;

        return getPk() != null ? getPk().equals(that.getPk()) : that.getPk() == null;

    }

    @Override
    public int hashCode() {
        return getPk() != null ? getPk().hashCode() : 0;
    }
}
