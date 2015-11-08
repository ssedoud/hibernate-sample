package com.project.sample.sedoud.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Category entity.
 * One to Many self-association
 */
@Entity
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    /**
     * MappedBy signals hibernate that the key for the relationship is on the other side.
     * MappedBy is the equivalent of inverse=true. It enables optimization on how much
     * sql request will be created to make the change
     * See : http://www.mkyong.com/hibernate/inverse-true-example-and-explanation/
     */
    @OneToMany(mappedBy = "parentCategory")
    private Set<Category> childCategories = new HashSet<Category>();

    @ManyToOne
    private Category parentCategory;



    private Set<Item> items  = new HashSet<Item>();



    public Category() {}


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
     * Getter for parentCategory
     */
    public Category getParentCategory() {
        return parentCategory;
    }

    /**
     * Setter for parentCategory
     */
    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    /**
     * Getter for childCategories
     */
    public Set<Category> getChildCategories() {
        return childCategories;
    }


    /**
     * Setter for childCategories
     */
    private void setChildCategories(Set<Category> childCategories) {
        this.childCategories = childCategories;
    }

    /**
     * Getter for items
     */
    public Set<Item> getItems() {
        return items;
    }

    /**
     * Setter for items
     */
    public void setItems(Set<Item> items) {
        this.items = items;
    }

    /**
     * Add child category managing the bi-directionnal relationship.
     * The category automatically changes the child side of the relationship
     */
    public  void addChildCategory(Category childCategory){
        if (childCategory == null)
            throw new IllegalArgumentException("Null child category!");
        //REmoving the child from its previously parent
        if (childCategory.getParentCategory() != null)
            childCategory.getParentCategory().getChildCategories()
                    .remove(childCategory);
        //
        childCategory.setParentCategory(this);
        childCategories.add(childCategory);
    }
}
