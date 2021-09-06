package com.sfh.unit.u08.changeValueToReference;

import lombok.Getter;

/**
 * @user sfh
 * @date 2021/9/6 18:32
 */
@Getter
public class Order {

    Customer customer;

//    public Order(String customerName) {
//        this.customer = new Customer(customerName);
//    }
//
//    public void setCustomer(String customerName) {
//        this.customer = new Customer(customerName);
//    }

    public Order(String customerName) {
        this.customer = Customer.create(customerName);
    }

    public void setCustomer(String customerName) {
        this.customer = Customer.create(customerName);
    }

    public String getCustomerName() {
        return customer.getName();
    }
}
