package com.project.sample.sedoud.dao.implementation;

import com.project.sample.sedoud.dao.PersonDao;
import com.project.sample.sedoud.data.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Dao for person data
 */
@Transactional
@Repository
public class PersonDaoImpl extends GenericDaoImpl<Person> implements PersonDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void persist(Person person) {
        super.persist(person);
    }

    @Override
    public List<Person> getAll() {
        return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }
}
