package com.project.Mart.models;

import javax.persistence.*;

@Entity
@Table(name="payment")
public class PaymentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "pamyent_id")
    private Integer P_id;

    @Column(name = "pamyent_date")
    private String P_date;

    @Column(name = "pamyent_price")
    private String p_price;

    @Column(name = "pamyent_CustomerDetails")
    private String p_CustomerDetails;

    @Column(name = "pamyent_SellerDetails")
    private String p_SellerDetails;


    public Integer getP_id() {
        return P_id;
    }

    public String getP_date() {
        return P_date;
    }

    public String getP_price() {
        return p_price;
    }

    public String getP_CustomerDetails() {
        return p_CustomerDetails;
    }

    public String getP_SellerDetails() {
        return p_SellerDetails;
    }

    public void setP_id(Integer p_id) {
        P_id = p_id;
    }

    public void setP_date(String p_date) {
        P_date = p_date;
    }

    public void setP_price(String p_price) {
        this.p_price = p_price;
    }

    public void setP_CustomerDetails(String p_CustomerDetails) {
        this.p_CustomerDetails = p_CustomerDetails;
    }

    public void setP_SellerDetails(String p_SellerDetails) {
        this.p_SellerDetails = p_SellerDetails;
    }
}