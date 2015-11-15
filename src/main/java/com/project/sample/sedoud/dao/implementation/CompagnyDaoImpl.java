package com.project.sample.sedoud.dao.implementation;

import com.project.sample.sedoud.dao.CompagnyDao;
import com.project.sample.sedoud.data.Company;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Dao for company data
 */
@Transactional
@Repository
public class CompagnyDaoImpl extends GenericDaoImpl<Company> implements CompagnyDao {

    @Override
    public void persist(Company company) {
        super.persist(company);
    }

    @Override
    public List<Company> getAll() {
        return super.findAll(Company.class);
       // super.em.createNamedQuery("from company inner join company.employee");
    }

    @Override
    public Company findById(Long id) {
        return super.findById(Company.class,id);
    }

    @Override
    public void evict(Company c){
        this.em.detach(c);
    }
}
