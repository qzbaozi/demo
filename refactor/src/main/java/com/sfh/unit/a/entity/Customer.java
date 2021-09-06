package com.sfh.unit.a.entity;

import com.sfh.annotation.BadExamples;
import lombok.Data;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @user sfh
 * @date 2021/8/31 9:33
 */
@Data
public class Customer {
    String name;
    Vector<Rental> rentals;

    public Customer() {
        rentals = new Vector();
    }

    public void addRental(Rental rental) {
        this.rentals.add(rental);
    }


    @BadExamples
    public String statement() {

        double totalAmount = 0;
        int frequentRenterPoints = 0;

        Enumeration<Rental> elements = rentals.elements();

        String result = "Rental Record for " + getName() + "\n";

        while (elements.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = elements.nextElement();

            //datermine amount for rental line
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDayRental() > 2) {
                        thisAmount += (each.getDayRental() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDayRental() * 3;
                    break;
                case Movie.CHILDREN:
                    thisAmount += 1.5;
                    if (each.getDayRental() > 3) {
                        thisAmount += (each.getDayRental() - 3) * 1.5;
                    }
                    break;
            }
            //add frequent renter points
            frequentRenterPoints++;

            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDayRental() > 1) {
                frequentRenterPoints++;
            }

            result += "\t" + each.getMovie().getTitle() + "\t"
                    + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        //add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";

        return result;
    }

    /**
     * v1 抽取独立函数，封装到对应类 {@link Rental#getChange()}
     * <p>
     * V2
     * 移除多余临时变量
     * 用查询替换临时变量
     * {@link Customer#getTotalAmount(),Customer#getFrequentRenterPoints()}
     * <p/>
     * <p>
     * V3
     * 最好不要在另一个对象的属性基础上运用Switch语句。如果不得不使用，也应该在对象自己的数据上使用，而不是在别人的数据室使用
     * <p/>
     * <p>
     * V4
     * state模式
     * </p>
     *
     * @return
     */
    public String statement_V1() {
        Enumeration<Rental> elements = rentals.elements();
        String result = "Rental Record for " + getName() + "\n";

        while (elements.hasMoreElements()) {
            Rental each = elements.nextElement();
            result += "\t" + each.getMovie().getTitle() + "\t"
                    + String.valueOf(each.getChange()) + "\n";
        }
        //add footer lines
        result += "Amount owed is " + this.getTotalAmount() + "\n";
        result += "You earned " + getFrequentRenterPoints() + " frequent renter points";

        return result;
    }

    private double getTotalAmount() {
        double result = 0;
        Enumeration<Rental> elements = rentals.elements();
        while (elements.hasMoreElements()) {
            Rental each = elements.nextElement();
            result += each.getChange();
        }
        return result;
    }

    private int getFrequentRenterPoints() {
        int result = 0;
        Enumeration<Rental> elements = rentals.elements();
        while (elements.hasMoreElements()) {
            Rental each = elements.nextElement();
            //add frequent renter points
            result += each.getFrequentRenterPoints();
        }
        return result;
    }


}
