package com.project.sample.sedoud.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Date;

/**
 * DriverLicense data
 */
@Entity(name = "DRIVER_LICENSE")
public class DriverLicense {

    @Id
//    @SequenceGenerator(name = "DRIVER_LICENSE_GENERATOR",sequenceName = "DRIVER_LICENSE_SEQUENCE")
    @GeneratedValue//(strategy = SEQUENCE, generator="DRIVER_LICENSE_GENERATOR")
    private Long id;

    private String driverLicenseNumber;

    private Date issueDate;

    /**
     * Bidirectionnal OneToOne relationship with Person
     * "mappedBy" is used to tell which side owns the relationship.
     */
    @OneToOne(mappedBy = "driverLicense")
    private Person person;

    public DriverLicense() {
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
     * Getter for driverLicenseNumber
     */
    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    /**
     * Setter for driverLicenseNumber
     */
    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    /**
     * Getter for issueDate
     */
    public Date getIssueDate() {
        return issueDate;
    }

    /**
     * Setter for issueDate
     */
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    /**
     * Getter for person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Setter for person
     */
    public void setPerson(Person person) {
        this.person = person;
    }
}
