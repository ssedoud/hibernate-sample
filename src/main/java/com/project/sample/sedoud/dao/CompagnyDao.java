package com.project.sample.sedoud.dao;

import com.project.sample.sedoud.entity.Company;
import com.project.sample.sedoud.entity.Person;

import java.util.List;

/**
 * Dao for person entity
 */
public interface CompagnyDao {

    void save(Company company);

    List<Company> getAll();

    Company findById(Long id);

    void evict(Company c);
}
