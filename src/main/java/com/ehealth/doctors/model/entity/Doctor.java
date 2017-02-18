package com.ehealth.doctors.model.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "doctor")
public class Doctor implements java.io.Serializable {
    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "id", columnDefinition = "BINARY(16)", unique = true)
    private UUID id;

    @Column(name = "mpi_id", columnDefinition = "BINARY(16)")
    private UUID mpiId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "fname")
    private String fname;

    @Column(name = "city")
    private String city;

    @Column(name = "former_surname")
    private String formerSurname;

    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(name = "date_updated")
    @Temporal(TemporalType.DATE)
    private Date dateUpdated;

    @Column(name = "date_created")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<DoctorCertificate> certificates = new HashSet<>();

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<DoctorLicense> licenses = new HashSet<>();

    @OneToMany(mappedBy = "pk.doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ClinicDoctorBinding> clinics = new HashSet<>();

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

    public Set<DoctorCertificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(Set<DoctorCertificate> certificates) {
        certificates.forEach(c -> c.setDoctor(this));
        this.certificates = certificates;
    }

    public Set<DoctorLicense> getLicenses() {
        return licenses;
    }

    public void setLicenses(Set<DoctorLicense> licenses) {
        licenses.forEach(l -> l.setDoctor(this));
        this.licenses = licenses;
    }

    public void addCertificate(DoctorCertificate cert) {
        cert.setDoctor(this);
        getCertificates().add(cert);
    }

    public void addLicense(DoctorLicense license) {
        license.setDoctor(this);
        getLicenses().add(license);
    }

    public void addClinicDoctorBinding(ClinicDoctorBinding b) {
        b.setDoctor(this);
        getClinics().add(b);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<ClinicDoctorBinding> getClinics() {
        return clinics;
    }

    public void setClinics(Set<ClinicDoctorBinding> clinics) {
        clinics.forEach(l -> l.setDoctor(this));
        this.clinics = clinics;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", mpiId=" + mpiId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", fname='" + fname + '\'' +
                ", city='" + city + '\'' +
                ", formerSurname='" + formerSurname + '\'' +
                ", dateUpdated=" + dateUpdated +
                ", certificates=" + certificates +
                ", licenses=" + licenses +
                '}';
    }
}
