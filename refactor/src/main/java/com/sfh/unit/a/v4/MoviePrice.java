package com.sfh.unit.a.v4;

import com.sfh.unit.a.entity.Movie;

/**
 * @user sfh
 * @date 2021/8/31 11:12
 */
public abstract class MoviePrice {

    public abstract int getPriceCode();

    public abstract double getChange(int dayRental);

    public abstract int getFrequentRenterPoints(int dayRental);
}
