package com.chainofbakeries;

/**
 * The type Cream.
 */
public class Cream extends SweetsDekorator{
    final double price=1.5;

    /**
     * Original Constructor set to private, so only Bakery can add toppings
     * @throws UnsupportedOperationException
     */
    private Cream(){
        throw new UnsupportedOperationException();
    }

    /**
     * Instantiates a new Cream. Used by Bakery
     *
     * @param b --> it needs a base, either the base is a plain Cake or it already has toppings on it
     */
    public Cream(Sweets b){
        this.base=b;
    }

    /**
     * Cost as double.
     *
     * @return calls cost() of base + price of Cream as double
     */
    @Override
    public double cost() {
        return this.base.cost()+this.price;
    }
}
