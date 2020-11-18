package com.pomhotel.booking.application.domain.entities;

import javax.persistence.*;
import java.io.Serializable;

//--- Entity -------------------------------------------------------
@Entity
@Table(name = "offers", schema = "pom_hotel")
public class OffersEntity implements Serializable {

    //--- Attributes -----------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Basic
    @Column(name = "childrens", nullable = true, length = 10)
    private int  childrens;

    @Basic
    @Column(name = "discountChilds", nullable = true, length = 10)
    private double discountChilds;

    @Basic
    @Column(name = "description", nullable = false, length = 100)
    private String description;


    //--- Getters & Setters ---------------------------------------
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getChildrens() {
        return childrens;
    }

    public void setChildrens(int childrens) {
        this.childrens = childrens;
    }

    public double getDiscountChilds() {
        return discountChilds;
    }

    public void setDiscountChilds(double discountChilds) {
        this.discountChilds = discountChilds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //--- Some general functions -----------------------------------

    @Override
    public String toString() {
        return "OffersEntity{" +
                "id=" + id +
                ", childrens=" + childrens +
                ", discountChilds=" + discountChilds +
                '}';
    }
}
