package com.FZZG.Model;

import java.sql.Date;
import java.sql.Timestamp;

public class billinginfo {
     private  String item;
     private Date time;
     private  Float prices;
     private  String category;

    public billinginfo() {
    }

    public billinginfo(String item, Date time, Float prices, String category) {
        this.item = item;
        this.time = time;
        this.prices = prices;
        this.category = category;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Float getPrices() {
        return prices;
    }

    public void setPrices(Float prices) {
        this.prices = prices;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
