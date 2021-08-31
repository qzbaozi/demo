package com.sfh.unit.a.v4;

import com.sfh.unit.a.entity.Movie;

/**
 * @user sfh
 * @date 2021/8/31 11:17
 */
public class RegularPrice extends MoviePrice{
    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    public double getChange(int dayRental) {
       double result = 2;
        if (dayRental > 2) {
            result += (dayRental - 2) * 1.5;
        }
        return result;
    }

    @Override
    public int getFrequentRenterPoints(int dayRental) {
        return 1;
    }
}
