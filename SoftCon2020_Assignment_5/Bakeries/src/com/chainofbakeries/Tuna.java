package com.chainofbakeries;

/**
 * The type Tuna.
 */
public class Tuna extends SandwichDecorator{
    final double price=3;

    /**
     * Original Constructor set to private, so only Bakery can add toppings
     * @throws UnsupportedOperationException
     */
    private Tuna(){
        throw new UnsupportedOperationException();
    }

    /**
     * Instantiates a new Tuna. Used by Bakery
     *
     * @param b --> it needs a base, either the base is a plain Sandwich or it already has toppings on it
     */
    public Tuna(Bread b){
        this.base=b;
    }

    /**
     * Cost as double.
     *
     * @return calls cost() of base + price of Tuna as double
     */
    @Override
    public double cost() {
        return this.base.cost()+this.price;
    }
}
