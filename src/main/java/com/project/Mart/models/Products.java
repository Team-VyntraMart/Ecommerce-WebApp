package com.project.Mart.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="products", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "name"
        })
})
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"added_on"}, 
        allowGetters = true)
public class Products implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	long id;
	Long category_id;
	String name;
	double price;
	
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date added_on;
	
	public Date getAdded_on() {
		return added_on;
	}
	public void setAdded_on(Date added_on) {
		this.added_on = added_on;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
}