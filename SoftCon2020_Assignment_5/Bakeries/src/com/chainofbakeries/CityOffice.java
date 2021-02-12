package com.chainofbakeries;

import java.util.ArrayList;

/**
 * The type City office.
 */
public class CityOffice extends BakeryComponent {
    private String city;
    private ArrayList<Bakery> listOfBakeries = new ArrayList<>();

    /**
     * Instantiates a new City office.
     *
     * @param city the city
     */
    public CityOffice(String city) {
        if (!CentralOffice.getStatusOfCentralOffice()) { // create only CityOffice, if there's already a CentralOffice
            throw new UnsupportedOperationException();
        }
        this.city = city;
        this.name = "city office of " + city;
    }

    /**
     * Creates bakery
     *
     * @param sweet   --> if sweet true & bread true, it's a normal bakery
     * @param bread       if only sweet or only bread true, it's either a BreadBakery or a SweetBakery
     * @param name    --> unique name (String)
     * @param address --> address (String [ ])
     * @return Bakery (either normal, sweet or bread)
     */
    public Bakery createBakery(boolean sweet, boolean bread, String name, String[] address){ //for address, use "definingAddress"
        Bakery aBakery;
        if (sweet && bread) {                        // if desired, create Universal Bakery or...
            aBakery = new Bakery(address, name);
        } else if (bread) {                          // ...BreadBakery
            aBakery = new BreadBakery(address, name);
        } else if (sweet){
            aBakery = new SweetBakery(address, name);             // ...SweetBakery
        }
        else{
            throw new UnsupportedOperationException();
        }
        this.listOfBakeries.add(aBakery);            // add Bakery to CityOffice List
        return aBakery;
    }

    /**
     * Defining address string [ ]
     *
     * @param StreetnameNr --> Streetname and Number
     * @param postalCode   --> Postal Code
     * @return Address as string [ ]
     */
    public String[] definingAddress(String StreetnameNr, String postalCode){
        String[] address = {StreetnameNr, postalCode, this.city};
        return address;
    }

    /**
     * Prints all corresponding bakeries names
     */
    public void printAllBakeriesNames(){
        for(Bakery b: listOfBakeries){
            b.printName();
        }
    }

    /**
     * Gets name of corresponding City Office, string.
     *
     * @return name as string
     */
    public String getName(){
        return this.name;
    }
 }
