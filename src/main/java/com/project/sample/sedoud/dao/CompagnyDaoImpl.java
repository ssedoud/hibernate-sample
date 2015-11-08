package com.project.sample.sedoud.dao;

import com.project.sample.sedoud.entity.Company;
import com.project.sample.sedoud.entity.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Dao for company entity
 */
@Transactional
@Repository
public class CompagnyDaoImpl extends GenericDao<Company> implements CompagnyDao {

    public void save(Company company) {
        super.save(company);
    }

    public List<Company> getAll() {
        return super.findAll(Company.class);
       // super.em.createNamedQuery("from company inner join company.employee");
    }

    public Company findById(Long id) {
        return super.findById(Company.class,id);
    }

    public void evict(Company c){
        this.em.detach(c);
    }
}
