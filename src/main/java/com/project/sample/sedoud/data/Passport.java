package com.project.sample.sedoud.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Passport data
 */
@Entity
public class Passport {

    @Id
    @GeneratedValue
    private Long id;

    private String passportNumber;

    public Passport() {
    }

    /**
     * Getter for id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter for id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for passportNumber
     */
    public String getPassportNumber() {
        return passportNumber;
    }

    /**
     * Setter for passportNumber
     */
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }
}
