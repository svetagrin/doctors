package com.ehealth.doctors.model.dto;

import java.util.UUID;


public class DoctorLicenseDTO implements java.io.Serializable {
    private UUID id;
    private String issuedBy;
    private String category;
    private String orderNo;
    private String dateIssued;
    private String dateExpiry;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(String dateIssued) {
        this.dateIssued = dateIssued;
    }

    public String getDateExpiry() {
        return dateExpiry;
    }

    public void setDateExpiry(String dateExpiry) {
        this.dateExpiry = dateExpiry;
    }
}
