package com.journaldev.annotations;

/**
 * Created by diam on 5/13/2018.
 */
public class BeanTest {

    public static void main(String[] args) {
        Car car = new Car();
        System.out.println("Car Name: " + car.getCName());
        System.out.println("Car Number: " + car.getCNo());
    }
}
