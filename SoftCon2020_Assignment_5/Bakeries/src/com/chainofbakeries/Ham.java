package com.chainofbakeries;

/**
 * The type Ham.
 */
public class Ham extends SandwichDecorator{
    final double price=2;

    /**
     * Original Constructor set to private, so only Bakery can add toppings
     * @throws UnsupportedOperationException
     */
    private Ham(){
        throw new UnsupportedOperationException();
    }

    /**
     * Instantiates a new Ham. Used by Bakery
     *
     * @param b --> it needs a base, either the base is a plain Sandwich or it already has toppings on it
     */
    public Ham(Bread b){
        this.base=b;
    }

    /**
     * Cost as double.
     *
     * @return calls cost() of base + price of Ham as double
     */
    @Override
    public double cost() {
        return this.base.cost()+this.price;
    }

}
