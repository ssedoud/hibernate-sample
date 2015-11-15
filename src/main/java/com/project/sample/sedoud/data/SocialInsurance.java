package com.project.sample.sedoud.data;

import javax.persistence.*;

/**
 * Passport data
 */
@Entity(name = "SOCIAL_INSURANCE")
public class SocialInsurance {

    @Id
    @GeneratedValue
    private Long id;

    private String socialNumber;
    @OneToOne
    @JoinColumn(name = "PERSON_ID")
    @MapsId
    private Person person;

    public SocialInsurance() {
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
    public String getSocialNumber() {
        return socialNumber;
    }

    /**
     * Setter for passportNumber
     */
    public void setSocialNumber(String passportNumber) {
        this.socialNumber = passportNumber;
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
        person.setSocialInsurance(this);
    }
}
