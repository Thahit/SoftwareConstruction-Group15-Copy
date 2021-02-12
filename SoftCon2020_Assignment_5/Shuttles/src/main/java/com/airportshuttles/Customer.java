package com.airportshuttles;

public class Customer {

    /**
     * This methods prints out the information about the vehicle chosen. Furthermore it checks if
     * any of the variables needed for the vehicle are missing and if so it throws an exception.
     * @param vehicle is the vehicle the customer chooses to ride.
     */

    public static void ride (Vehicle vehicle){
        if(vehicle.smallBags == null){
            throw new UnsupportedOperationException();
        }
        if(vehicle.largeBags == null){
            throw new UnsupportedOperationException();
        }
        if(vehicle.name == null){
            throw new UnsupportedOperationException();
        }
        if(vehicle.speedFactor == null){
            throw new UnsupportedOperationException();
        }
        if(vehicle.price == null){
            throw new UnsupportedOperationException();
        }
        if(vehicle.fuelBehavior == null){
            throw new UnsupportedOperationException();
        }
        System.out.println(vehicle.name + "; " + (vehicle.smallBags)+" smallbags; " + (vehicle.largeBags)+" largebags;"+vehicle.speedFactor.speed()+"; " + vehicle.price );
    }
}
