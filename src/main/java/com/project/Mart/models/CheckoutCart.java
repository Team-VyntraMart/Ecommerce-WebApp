package com.project.Mart.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="checkout_cart", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "order_id"
        })
})
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"order_date"}, 
        allowGetters = true)
public class CheckoutCart implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String order_id,payment_type,delivery_address;
	private long user_id;
	
	@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "product_id")
	Products product;	
	//long ;
	private int qty;
	private double price;
	
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date order_date;
	
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	public String getDelivery_address() {
		return delivery_address;
	}
	public void setDelivery_address(String delivery_address) {
		this.delivery_address = delivery_address;
	}

	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public Products getProduct() {
		return product;
	}
	public void setProduct(Products product) {
		this.product = product;
	}
}