package com.sfh.unit.a.entity;

import com.sfh.unit.a.v4.ChildrenPrice;
import com.sfh.unit.a.v4.MoviePrice;
import com.sfh.unit.a.v4.NewReleasePrice;
import com.sfh.unit.a.v4.RegularPrice;
import lombok.Builder;
import lombok.Data;

/**
 * @user sfh
 * @date 2021/8/31 9:28
 */
@Data
public class Movie {
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    String title;
    int priceCode;
    MoviePrice price;

    public Movie() {
    }

    public Movie(String title, int priceCode) {
        this.title = title;
        this.setPriceCode(priceCode);
    }

    public int getFrequentRenterPoints(int dayRental) {
        return price.getFrequentRenterPoints(dayRental);
    }

    public double getChange(int dayRental) {
        return price.getChange(dayRental);
    }

    public int getPriceCode() {
        return price.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode) {
            case Movie.REGULAR:
                price = new RegularPrice();
                break;
            case Movie.NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            case Movie.CHILDREN:
                price = new ChildrenPrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect price code");
        }
    }
}
