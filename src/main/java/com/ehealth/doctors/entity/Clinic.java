package com.ehealth.doctors.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Created by vilyam on 17.02.17.
 */
@Entity
@Table(name = "clinic")
public class Clinic implements java.io.Serializable {
    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "id", columnDefinition = "BINARY(16)", unique = true)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "edrpou")
    private String edrpou;

    @Column(name = "website")
    private String website;

    @Column(name = "date_added")
    @Temporal(TemporalType.DATE)
    private Date dateAdded;

    @Column(name = "date_updated")
    @Temporal(TemporalType.DATE)
    private Date dateUpdated;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.clinic", cascade=CascadeType.ALL)
    private Set<ClinicDoctorBinding> doctors  = new HashSet<>();

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

    public Set<ClinicDoctorBinding> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<ClinicDoctorBinding> doctors) {
        doctors.forEach(d -> d.setClinic(this));
        this.doctors = doctors;
    }

    public void addClinicDoctorBinding(ClinicDoctorBinding b) {
        b.setClinic(this);
        getDoctors().add(b);
    }
}
