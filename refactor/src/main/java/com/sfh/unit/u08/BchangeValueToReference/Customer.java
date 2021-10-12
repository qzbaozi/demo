package com.sfh.unit.u08.BchangeValueToReference;

import lombok.Data;
import lombok.Getter;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @user sfh
 * @date 2021/9/6 18:32
 */
@Getter
public class Customer {
    static final ConcurrentHashMap<String,Customer> map=new ConcurrentHashMap();
    final String name;

    private Customer(String name) {
        this.name = name;
    }

    public static Customer create(String name){
        return new Customer(name);
    }

    public static Customer getNamed(String name){
        return loadCustomer(name);
    }

    /**修改為工厂模式
     *
     * @param name
     * @return
     */
    private static Customer loadCustomer(String name){
        Customer customer = map.get(name);
        if (customer == null){
            customer=new Customer(name);
            customer.store();
        }
        return customer;
    }

    private void store(){
        map.put(this.getName(),this);
    }
}
