package com.project.sample.sedoud.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * User data.
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;


}
