package com.project.sample.sedoud.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by said.sedoud on 8/14/15.
 */
public class GenericDao<T> {

    @PersistenceContext
    protected EntityManager em;


    public void save(T entity){
        em.persist(entity);
    }

    public List<T> findAll(Class<T> clazz){
        Query query = em.createQuery("from " + clazz.getName());
        return query.getResultList();
    }

    public T findById(Class<T> clazz, Long id){
        return em.find(clazz,id);
    }

    public void delete(T entity){
        em.remove(entity);
    }
}
