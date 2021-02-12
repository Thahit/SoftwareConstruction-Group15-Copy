package com.chainofbakeries;

/**
 * The type Bakery. It supports Sweets and Bread
 */
public class Bakery extends BakeryComponent{
    protected String[] address;

    /**
     * creates a Bakery
     *
     * @param Address of the bakery
     * @param Name of the bakery
     */
    public Bakery(String[] Address, String Name){
        this.address = Address;
        this.name = Name;
    }

    /**
     * Creates sandwich, type of bread. Used by Bakeries
     *
     * @return sandwich
     */
    public Bread createSandwich(){
        Bread abread = new Sandwich();
        return abread;
    }

    /**
     * Create cake, type of sweets. Used by Bakeries
     *
     * @return cake
     */
    public Sweets createCake(){
        Sweets aCake = new Cake();
        return aCake;
    }

    /**
     * Add ham, type of bread. Used by Bakeries
     *
     * @param something --> it needs a base, either the base is a plain Sandwich or it already has toppings on it
     * @return base but with added topping
     */
    public Bread addHam(Bread something){
        Bread topping = new Ham(something);
        return topping;
    }

    /**
     * Add tomatoes, type of bread. Used by Bakeries
     *
     * @param something --> it needs a base, either the base is a plain Sandwich or it already has toppings on it
     * @return base but with added topping
     */
    public Bread addTomatoes(Bread something){
        Bread topping = new Tomatoes(something);
        return topping;
    }

    /**
     * Add cheese, type of bread. Used by Bakeries
     *
     * @param something --> it needs a base, either the base is a plain Sandwich or it already has toppings on it
     * @return base but with added topping
     */
    public Bread addCheese(Bread something){
        Bread topping = new Cheese(something);
        return topping;
    }

    /**
     * Add tuna, type of bread. Used by Bakeries
     *
     * @param something --> it needs a base, either the base is a plain Sandwich or it already has toppings on it
     * @return base but with added topping
     */
    public Bread addTuna(Bread something){
        Bread topping = new Tuna(something);
        return topping;
    }

    /**
     * Add cream, type of sweets. Used by Bakeries
     *
     * @param something --> it needs a base, either the base is a plain Cake or it already has toppings on it
     */
    public Sweets addCream(Sweets something) {
        Sweets topping = new Cream(something);
        return topping;
    }

    /**
     * Add strawberry, type of sweets. Used by Bakeries
     *
     * @param something --> it needs a base, either the base is a plain Cake or it already has toppings on it
     * @return base but with added topping
     */
    public Sweets addStrawberry(Sweets something) {
        Sweets topping = new Strawberries(something);
        return topping;
    }

    /**
     * Add chocolate, type of sweets. Used by Bakeries
     *
     * @param something --> it needs a base, either the base is a plain Cake or it already has toppings on it
     * @return base but with added topping
     */
    public Sweets addChocolate(Sweets something) {
        Sweets topping = new Chocolate(something);
        return topping;
    }

    /**
     * Calculates price
     *
     * @param aPastry --> some type of pastry (e.g. sweets, bread ... potentially other types in the future)
     * @return the double
     */
    public double calcPricePastry(Pastries aPastry){
        return aPastry.cost();
    }

    /**
     * Prints name.
     * Method used by Bakeries
     */
    public void printName(){
        System.out.println(this.name);
    }

    /**
     * returns the Address of a Bakery
     *
     * @return address
     */
    public String[] returnAddress(){
        return this.address;
    }
}
