package com.ehealth.doctors.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Created by vilyam on 17.02.17.
 */
@Entity
@Table(name = "doctor_certificate")
public class DoctorCertificate implements java.io.Serializable {

    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "id", columnDefinition = "BINARY(16)", unique = true)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private String number;

    @Column(name = "degree")
    private String degree;

    @Column(name = "issued_by")
    private String issuedBy;

    @Column(name = "date_started")
    @Temporal(TemporalType.DATE)
    private Date dateStarted;

    @Column(name = "date_finished")
    @Temporal(TemporalType.DATE)
    private Date dateFinished;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="doctor_id", nullable = false)
    private Doctor doctor;

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public Date getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(Date dateStarted) {
        this.dateStarted = dateStarted;
    }

    public Date getDateFinished() {
        return dateFinished;
    }

    public void setDateFinished(Date dateFinished) {
        this.dateFinished = dateFinished;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "DoctorCertificate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", degree='" + degree + '\'' +
                ", issuedBy='" + issuedBy + '\'' +
                ", dateStarted=" + dateStarted +
                ", dateFinished=" + dateFinished +
                '}';
    }
}
