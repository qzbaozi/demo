package com.sfh.unit.a.entity;

import lombok.Data;

/**
 * @user sfh
 * @date 2021/8/31 9:32
 */
@Data
public class Rental {
    Movie movie;
    int dayRental;

    public Rental(Movie movie, int dayRental) {
        this.movie = movie;
        this.dayRental = dayRental;
    }

    public int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(dayRental);
    }

    public double getChange() {
        return movie.getChange(dayRental);
    }
}
