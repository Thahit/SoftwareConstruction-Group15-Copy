package com.chainofbakeries;

/**
 * The type Sandwich.
 */
public class Sandwich extends Bread{
    final double price=2;       // proxy,  i havent seen the real price

    /**
     * Cost as double.
     * Hint: in case cost() has been called on toppings, this cost call will be the last one and sum up all prices
     * @return price of Sandwich
     */
    public double cost(){
        return this.price;
    }
}
