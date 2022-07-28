package com.simplilearn.assigment.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "PRODUCTS")
public class Product {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;
	private String name;
	private BigDecimal price;
	private Date dateAdded;
	@OneToOne(
			fetch = FetchType.EAGER,
			optional = false,
			cascade = CascadeType.REMOVE
	)
	
	@JoinColumn(unique = false)
	private Category category;
	
	
	
	/**
	 * 
	 */
	public Product() {
		super();
	}
	/**
	 * @param name
	 * @param price
	 * @param dateAdded
	 * @param categoryId
	 */
	public Product(String name, BigDecimal price, Date dateAdded, Category categoryId) {
		super();
		this.name = name;
		this.price = price;
		this.dateAdded = dateAdded;
		this.category = categoryId;
	}
	public long getID() {
		return ID;
	}
	public void setID(long iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Date getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category categoryId) {
		this.category = categoryId;
	}
	@Override
	public String toString() {
		return "Product [ID=" + ID + ", name=" + name + ", price=" + price + ", dateAdded=" + dateAdded
				+ ", categoryId=" + category + "]";
	}  
	
	
}
