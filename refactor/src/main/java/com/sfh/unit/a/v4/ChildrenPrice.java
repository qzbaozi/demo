package com.sfh.unit.a.v4;

import com.sfh.unit.a.entity.Movie;

/**
 * @user sfh
 * @date 2021/8/31 11:17
 */
public class ChildrenPrice extends MoviePrice {
    @Override
    public int getPriceCode() {
        return Movie.CHILDREN;
    }

    @Override
    public double getChange(int dayRental) {
        double result = 1.5;
        if (dayRental > 3) {
            result += (dayRental - 3) * 1.5;
        }
        return result;
    }

    @Override
    public int getFrequentRenterPoints(int dayRental) {
        return 1;
    }
}
