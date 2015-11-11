package com.project.sample.sedoud.data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Compagny data
 */
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
public class Company {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="employed_persons",
    joinColumns = @JoinColumn(name = "company_id"),inverseJoinColumns = @JoinColumn(name = "person_id"))
    private List<Person> employees = new ArrayList<Person>();

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

    public List<Person> getEmployees() {
        return employees;
    }

    public void addEmployees(Person employee) {
        employee.setCompany(this);
        this.employees.add(employee);

    }

    @Override public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}
