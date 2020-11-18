package com.pomhotel.booking.application.models;

public class OffersModel {
    //--- Attributes -----------------------------------------------
    public long id;
    public int childrens;
    public double discountChilds;
    public String description;

    //--- Constructor ----------------------------------------------
    public OffersModel(long id, int childrens, double discountChilds, String description) {
        this.id = id;
        this.childrens = childrens;
        this.discountChilds = discountChilds;
        this.description = description;
    }

    public OffersModel() {
    }

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
}
