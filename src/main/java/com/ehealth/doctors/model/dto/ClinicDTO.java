package com.ehealth.doctors.model.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


public class ClinicDTO implements java.io.Serializable {
    private UUID id;
    private String name;
    private String edrpou;
    private String website;
    private Date dateAdded;
    private Date dateUpdated;
    //private Set<DoctorDTO> doctors  = new HashSet<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEdrpou() {
        return edrpou;
    }

    public void setEdrpou(String edrpou) {
        this.edrpou = edrpou;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

//    public Set<DoctorDTO> getDoctors() {
//        return doctors;
//    }
//
//    public void setDoctors(Set<DoctorDTO> doctors) {
//        this.doctors = doctors;
//    }
}
