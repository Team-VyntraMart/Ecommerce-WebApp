 package com.project.Mart.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "add_to_cart")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"added_date"}, 
        allowGetters = true)
public class AddtoCart implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	@JsonIgnore
	
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "product_id")
	Products product;
	//Long product_id;
	int qty;
	
	@Transient
	double price;
	
	Long user_id;
	
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date added_date;

	public Date getAdded_date() {
		return added_date;
	}
	public void setAdded_date(Date added_date) {
		this.added_date = added_date;
	}

	@Transient
	String productName;
	
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}

	public String getProductName() {
		return product.getName();
	}
	public double getPrice() {
		return getQty()*product.getPrice();
	}
}
