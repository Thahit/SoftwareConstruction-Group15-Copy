package com.chainofbakeries;

/**
 * The type Tomatoes.
 */
public class Tomatoes extends SandwichDecorator{
    final double price=1.5;

    /**
     * Original Constructor set to private, so only Bakery can add toppings
     * @throws UnsupportedOperationException
     */
    private Tomatoes(){
        throw new UnsupportedOperationException();
    }

    /**
     * Instantiates a new Tomatoes. Used by Bakery
     *
     * @param b --> it needs a base, either the base is a plain Sandwich or it already has toppings on it
     */
    public Tomatoes(Bread b){
        this.base=b;
    }

    /**
     * Cost as double.
     *
     * @return calls cost() of base + price of Tomatoes as double
     */
    @Override
    public double cost() {
        return this.base.cost()+this.price;
    }
}
