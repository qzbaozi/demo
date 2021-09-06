package com.sfh.a;

import com.sfh.unit.a.entity.Rental;
import org.junit.Test;

/**
 * @user sfh
 * @date 2021/9/1 17:38
 */
public class Unit01Test {

    @Test
    public void build(){
        Rental build = Rental.builder().dayRental(1).build();

    }

}
