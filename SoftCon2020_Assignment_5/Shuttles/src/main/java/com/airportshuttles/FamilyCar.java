package com.airportshuttles;

public class FamilyCar extends Vehicle{
    /**
     * This is a Family car. It can fit 2 small and 2 large bags, costs 15 CHF/h, has normal speed and uses gasoline.
     */

    public FamilyCar(){
        this.fuelBehavior = new Gasoline();
        this.speedFactor = new normal();
        this.price = "15 CHF/h";
        this.smallBags = "2";
        this.largeBags = "2";
        this.name = "Family car";
    }
}
