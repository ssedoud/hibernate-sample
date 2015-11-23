package com.project.sample.sedoud.dao;

import com.project.sample.sedoud.data.DriverLicense;
import com.project.sample.sedoud.data.Passport;
import com.project.sample.sedoud.data.Person;
import com.project.sample.sedoud.data.SocialInsurance;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;

/**
 * Unidirectionnal OneToOne mapping testing
 * The Passport ressource should be only accessible via the Person entity.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
@Transactional
public class OneToOneTest extends AbstractTransactionalJUnit4SpringContextTests {

    final Logger logger = LoggerFactory.getLogger(OneToOneTest.class);

    @Autowired
    PersonDao personDao;

    /**
     * Creates a person with his OneToOne attributes clear the session
     * and get them from the database.
     */
    @Test
    public void testCascadeSave_FK_relation() {
        //Entity creation
        initData();

        //Get the entity we've just created.
        List<Person> persons = personDao.getAll();

        Assert.assertNotNull(persons);
        Assert.assertEquals(persons.size(), 1);
        Assert.assertNotNull(persons.get(0).getPassport());
        Assert.assertNotNull(persons.get(0).getDriverLicense());

        //Test that the bidirectionnal relation is well managed
        Assert.assertNotNull(persons.get(0).getDriverLicense().getPerson());

    }


    /**
     * Creates a person with his OneToOne attributes clear the session
     * and get them from the database.
     */
    @Test
    public void testCascadeUpdate_FK_relation() {
        initData();

        //Get the entity we've just created.
        List<Person> persons = personDao.getAll();

        Person savedPerson = persons.get(0);
        savedPerson.getPassport().setPassportNumber("CHANGED_NUMBER");
        personDao.getEntityManager().flush();
    }

    /**
     * Data initialisation for this test
     * Creates a Person with his OneToOne dependencies {passport,driverLicense}
     */
    private void initData() {
        //Entity creation
        final Person employee = new Person();
        employee.setName("Said");
        employee.setSurname("Sedoud");

        //FK OneToOne
        Passport passport = new Passport();
        passport.setPassportNumber("C1076Y89");

        DriverLicense driverLicense = new DriverLicense();
        driverLicense.setDriverLicenseNumber("129676108710");
        driverLicense.setIssueDate(Calendar.getInstance().getTime());

        //Shared id
        SocialInsurance socialInsurance = new SocialInsurance();
        socialInsurance.setSocialNumber("187120310938");
        socialInsurance.setPerson(employee);

        employee.setPassport(passport);
        employee.setDriverLicense(driverLicense);

        //This will save the passport and driverLicense as well.
        personDao.persist(employee);


        // Clear the cache to make sure to get entities thats are not in the session cache.
        personDao.getEntityManager().clear();
    }
}
