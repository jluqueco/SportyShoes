package com.simplilearn.assigment.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIES")
public class Category {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long categoryID;
	private String description;
	private Date dateAdded;
	/**
	 * @param description
	 */
	
	
	
	public Category(String description) {
		super();
		this.description = description;
	}
	/**
	 * 
	 */
	public Category() {
		super();
	}
	public long getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(long categoryID) {
		this.categoryID = categoryID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	@Override
	public String toString() {
		return "Category [categoryID=" + categoryID + ", description=" + description + "]";
	}
	
	
}
