package com.sfh.unit.a.v4;

import com.sfh.unit.a.entity.Movie;

/**
 * @user sfh
 * @date 2021/8/31 11:17
 */
public class NewReleasePrice extends MoviePrice{
    @Override
    public int getPriceCode() {
        return Movie.NEW_RELEASE;
    }

    @Override
    public double getChange(int dayRental) {
        return  dayRental * 3;
    }

    @Override
    public int getFrequentRenterPoints(int dayRental) {
        if (dayRental > 1) {
            return 2;
        }
        return 1;
    }
}
