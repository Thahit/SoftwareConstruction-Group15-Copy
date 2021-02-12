package com.chainofbakeries;

/**
 * The type Cake.
 */
public class Cake extends Sweets{
    final double price=3;

    /**
     * Cost as double.
     * Hint: in case cost() has been called on toppings, this cost call will be the last one and sum up all prices
     * @return price of Cake
     */
    public double cost(){
        return this.price;
    }
}
