package com.project.sample.sedoud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

/**
 * User entity.
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;


}
