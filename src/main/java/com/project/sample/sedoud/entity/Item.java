package com.project.sample.sedoud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

/**
 * Item entity.
 * Many to Many association with category
 */
@Entity
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private Set<Category> categories = new HashSet<Category>();


    public Item() {
    }

    /**
     * Getter for id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter for id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for categories
     */
    public Set<Category> getCategories() {
        return categories;
    }

    /**
     * Setter for categories
     */
    private void setCategories(Set<Category> categories) {
        this.categories = categories;
    }


    /**
     * Add a category to an item.
     * Manages the bi-directionnal relationship.
     */
    private void addCategory(Category category) {
        if (category == null)
            throw new IllegalArgumentException("Null category");
        //Adding the item to the category
        category.getItems().add(this);
        //Then adding the category to the categories list.
        categories.add(category);
    }
}