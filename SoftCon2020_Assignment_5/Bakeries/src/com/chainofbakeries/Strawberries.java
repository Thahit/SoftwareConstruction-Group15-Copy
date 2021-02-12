package com.chainofbakeries;

/**
 * The type Strawberries.
 */
public class Strawberries extends SweetsDekorator{
    final double price=1;

    /**
     * Original Constructor set to private, so only Bakery can add toppings
     * @throws UnsupportedOperationException
     */
    private Strawberries(){
        throw new UnsupportedOperationException();
    }

    /**
     * Instantiates a new Strawberries. Used by Bakery
     *
     * @param b --> it needs a base, either the base is a plain Cake or it already has toppings on it
     */
    public Strawberries(Sweets b){
        this.base=b;
    }

    /**
     * Cost as double.
     *
     * @return calls cost() of base + price of Strawberries as double
     */
    @Override
    public double cost() {
        return this.base.cost()+this.price;
    }

}
