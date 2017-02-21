package com.ehealth.doctors.model.dto;

import com.ehealth.doctors.model.entity.ContactType;

import java.util.UUID;

public class DoctorContactCardDTO {
    private UUID id;
    private ContactType type;
    private String value;
    private boolean isVerified;
    private boolean isPrimary;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }
}
