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
@Transactional
@Repository
public class PersonDaoImpl implements PersonDao {
    @PersistenceContext
    private EntityManager em;


    public Long save(Person person) {
        em.persist(person);
        return person.getId();
    }

    public List<Person> getAll() {
        return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }
}
