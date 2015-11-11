package com.project.sample.sedoud.dao;

import com.project.sample.sedoud.data.Company;

import java.util.List;

/**
 * Dao for person data
 */
public interface CompagnyDao {

    void persist(Company company);

    List<Company> getAll();

    Company findById(Long id);

    void evict(Company c);
}
