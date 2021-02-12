package com.airportshuttles;

public class Bus extends Vehicle {
    /**
     * This is a bus. It can fit infinite small and infinite large bags, costs 5 CHF, is slow and uses diesel.
     */

    public Bus() {
        this.fuelBehavior = new Diesel();
        this.speedFactor = new slow();
        this.price = "5 CHF";
        this.smallBags = "infinite";
        this.largeBags = "infinite";
        this.name = "Bus";
    }





}
