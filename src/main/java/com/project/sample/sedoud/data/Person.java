package com.project.sample.sedoud.data;

import javax.persistence.*;

/**
 * Person data
 */
@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String surname;

    @ManyToOne
    @JoinTable(name="employed_persons",
            joinColumns =  @JoinColumn(name = "person_id"),inverseJoinColumns = @JoinColumn(name = "company_id"))
    private Company company;


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

    @Override public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
