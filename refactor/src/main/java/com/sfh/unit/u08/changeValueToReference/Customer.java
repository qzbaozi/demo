package com.sfh.unit.u08.changeValueToReference;

import lombok.Data;

/**
 * @user sfh
 * @date 2021/9/6 18:32
 */
@Data
public class Customer {
    final String name;

    private Customer(String name) {
        this.name = name;
    }

    public static Customer create(String name){
        return new Customer(name);
    }
}
