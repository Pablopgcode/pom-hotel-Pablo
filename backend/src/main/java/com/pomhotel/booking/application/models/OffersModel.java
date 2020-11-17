package com.pomhotel.booking.application.models;

public class OffersModel {
    //--- Attributes -----------------------------------------------
    public long id;
    public int childrens;
    public double discountChilds;

    //--- Constructor ----------------------------------------------
    public OffersModel(long id, int childrens, double discountChilds) {
        this.id = id;
        this.childrens = childrens;
        this.discountChilds = discountChilds;
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
}
