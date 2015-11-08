package com.project.sample.sedoud.dao;

import com.project.sample.sedoud.entity.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Dao for person entity
 */
public interface PersonDao {

    Long save(Person person);

    List<Person> getAll();
}
