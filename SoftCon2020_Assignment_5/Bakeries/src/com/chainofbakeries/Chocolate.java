package com.chainofbakeries;

/**
 * The type Chocolate.
 */
public class Chocolate extends SweetsDekorator{
    final double price=2;

    /**
     * Original Constructor set to private, so only Bakery can add toppings
     * @throws UnsupportedOperationException
     */
    private Chocolate(){
        throw new UnsupportedOperationException();
    }

    /**
     * Instantiates a new Chocolate. Used by Bakery
     *
     * @param b --> it needs a base, either the base is a plain Cake or it already has toppings on it
     */
    public Chocolate(Sweets b){
        this.base=b;
    }

    /**
     * Cost as double.
     *
     * @return calls cost() of base + price of Chocolate as double
     */
    @Override
    public double cost() {
        return this.base.cost()+this.price;
    }

}
