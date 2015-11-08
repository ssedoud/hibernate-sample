package com.project.sample.sedoud.dao;

import com.project.sample.sedoud.entity.Company;
import com.project.sample.sedoud.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
@Transactional
public class ManyToOneTest extends AbstractTransactionalJUnit4SpringContextTests {

    final Logger logger = LoggerFactory.getLogger(ManyToOneTest.class);

    @Autowired
    CompagnyDao compagnyDao;

    @Test
    public void testCascadeSave() throws Exception {

        final Person employee = new Person();
        employee.setName("Said");
        employee.setSurname("Sedoud");

        final Company company = new Company();
        company.setName("PriceMinister");
        company.addEmployees(employee);

        compagnyDao.save(company);

        List<Company> compagnies = compagnyDao.getAll();
        for (Company compagny : compagnies) {
            logger.info("Saved compagny : " + compagny);

        }

    }

    @Test
    public void test_N_plus_1_SelectProblem() throws Exception {

        final Company company = new Company();
        company.setName("PriceMinister");
        final Company company2 = new Company();
        company2.setName("Amazon");

        for (int i = 0;i<10;i++) {
            final Person employee = new Person();
            employee.setName("name"+i);
            employee.setSurname("surname"+i);
            company.addEmployees(employee);
            company2.addEmployees(employee);
        }

        compagnyDao.save(company);
        compagnyDao.save(company2);
        compagnyDao.evict(company);
        compagnyDao.evict(company2);

        List<Company> dbCompany = compagnyDao.getAll();
        for (Company c :dbCompany){
            c.getEmployees().get(0).getName();
        }


    }

}
