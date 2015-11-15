package com.project.sample.sedoud.data;

import javax.persistence.*;

/**
 * Person data
 */
@SuppressWarnings("ALL")
@Entity
public class Person {

    @Id
    @Column(name = "PERSON_ID")
    @GeneratedValue
    private Long id;

    private String name;

    private String surname;

    @ManyToOne
    @JoinTable(name="employed_persons",
            joinColumns =  @JoinColumn(name = "person_id"),inverseJoinColumns = @JoinColumn(name = "company_id"))
    private Company company;

    /**
     * Unidirectionnal OneToOne relationship.
     * This is a 1 to 0.1 relation because nullable is TRUE
     * "Insertable" and "updatable" setted to FALSE
     * prevent for this attribute to update/insert the relationship from this attribute default value is TRUE.
     * Use @JoinColumn to indicate the foreign key column of the entity which owns this relationship.
     * By default OneToOne relationship are EAGER
     */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "PASS_ID", insertable = true,
            updatable = true, nullable = true, unique = true)
    private Passport passport;


    /**
     * Bidirectionnal OneToOne relationship.
     * The relationship will be managed on this side (see setter)
     * This is a 1 to 0.1 relation because nullable is TRUE
     * "Insertable" and "updatable" setted to FALSE
     * prevent for this attribute to update/insert the relationship from this attribute default value is TRUE.
     * Use @JoinColumn to indicate the foreign key column of the entity which owns this relationship
     * and use "mappedby on the other side of the relationship.
     * By default OneToOne relationship are EAGER
     */
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "DRIVER_LICENSE_ID", insertable = true,
            updatable = true, nullable = true, unique = true)
    private DriverLicense driverLicense;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private SocialInsurance socialInsurance;

    public Person() {}

    public Person(String name, String surname, Company company) {
        this.name = name;
        this.surname = surname;
        this.company = company;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * Getter for passport
     */
    public Passport getPassport() {
        return passport;
    }

    /**
     * Setter for passport
     */
    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    /**
     * Getter for driverLicense
     */
    public DriverLicense getDriverLicense() {
        return driverLicense;
    }

    /**
     * Setter for driverLicense
     */
    public void setDriverLicense(DriverLicense driverLicense) {
        this.driverLicense = driverLicense;
        driverLicense.setPerson(this);
    }

    /**
     * Getter for socialInsurance
     */
    public SocialInsurance getSocialInsurance() {
        return socialInsurance;
    }

    /**
     * Setter for socialInsurance
     */
    public void setSocialInsurance(SocialInsurance socialInsurance) {
        this.socialInsurance = socialInsurance;
    }

    @Override public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
