package com.ehealth.doctors.model.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * DTO class for mapping {@link com.ehealth.doctors.model.entity.Doctor}
 */
public class DoctorDTO implements java.io.Serializable {
    private UUID id;
    private UUID mpiId;

    @NotNull
    @Size(min=2, max=30)
    private String name;
    @NotNull
    @Size(min=2, max=30)
    private String surname;
    @NotNull
    @Size(min=2, max=30)
    private String fname;
    @Past
    private Date birthday;
    private String city;
    private String formerSurname;
    private Date dateCreated;
    private Date dateUpdated;
    private Set<DoctorCertificateDTO> certificates = new HashSet<>();
    private Set<DoctorLicenseDTO> licenses = new HashSet<>();
    private Set<DoctorClinicDTO> clinics = new HashSet<>();
    private Set<DoctorContactCardDTO> contacts = new HashSet<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getMpiId() {
        return mpiId;
    }

    public void setMpiId(UUID mpiId) {
        this.mpiId = mpiId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFormerSurname() {
        return formerSurname;
    }

    public void setFormerSurname(String formerSurname) {
        this.formerSurname = formerSurname;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Set<DoctorCertificateDTO> getCertificates() {
        return certificates;
    }

    public void setCertificates(Set<DoctorCertificateDTO> certificates) {
        this.certificates = certificates;
    }

    public Set<DoctorLicenseDTO> getLicenses() {
        return licenses;
    }

    public void setLicenses(Set<DoctorLicenseDTO> licenses) {
        this.licenses = licenses;
    }

    public Set<DoctorClinicDTO> getClinics() {
        return clinics;
    }

    public void setClinics(Set<DoctorClinicDTO> clinics) {
        this.clinics = clinics;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Set<DoctorContactCardDTO> getContacts() {
        return contacts;
    }

    public void setContacts(Set<DoctorContactCardDTO> contacts) {
        this.contacts = contacts;
    }
}
