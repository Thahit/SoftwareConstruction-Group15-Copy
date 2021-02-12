package com.chainofbakeries;

/**
 * The type Cheese.
 */
public class Cheese extends SandwichDecorator{
    final double price=1;

    /**
     * Original Constructor set to private, so only Bakery can add toppings
     * @throws UnsupportedOperationException
     */
    private Cheese(){
        throw new UnsupportedOperationException();
    }

    /**
     * Instantiates a new Cheese. Used by Bakery
     *
     * @param b --> it needs a base, either the base is a plain Sandwich or it already has toppings on it
     */
    public Cheese(Bread b){
        this.base=b;
    }

    /**
     * Cost as double.
     *
     * @return calls cost() of base + price of Cheese as double
     */
    @Override
    public double cost() {
        return this.base.cost()+this.price;
    }
}
