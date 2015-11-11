package com.project.sample.sedoud.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Generic DAO encapsulate all method for all DAO
 */
public class GenericDao<T> {

    @PersistenceContext
    protected EntityManager em;


    public void persist(T entity){
        em.persist(entity);
    }

    public List<T> findAll(Class<T> clazz){
        Query query = em.createQuery("from " + clazz.getName());
        return query.getResultList();
    }

    public T findById(Class<T> clazz, Long id){
        return em.find(clazz,id);
    }

    public void remove(T entity){
        em.remove(entity);
    }
}
