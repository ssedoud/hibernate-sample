package com.project.sample.sedoud.dao;

import com.project.sample.sedoud.data.Person;

import java.util.List;

/**
 * Dao for person data
 */
public interface PersonDao extends GenericDao {

    void persist(Person person);

    List<Person> getAll();


}
