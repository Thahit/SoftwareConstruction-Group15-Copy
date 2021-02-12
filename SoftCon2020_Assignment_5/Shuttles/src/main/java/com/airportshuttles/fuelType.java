package com.airportshuttles;

public interface fuelType {
    /**
     * This is the interface of all the fuel types the cars currently have. If a new fuel type should come up,
     * it is possible to create a class with the new fuel type which implements this interface, extending
     * the available options in the process.
     * @return This method returns a string of the corresponding fuel type.
     */
    String fuelType();
}
