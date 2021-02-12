package com.chainofbakeries;

import java.util.ArrayList;

/**
 * The type Central office.
 */
public class CentralOffice extends BakeryComponent{
    private ArrayList<CityOffice> ultimateList = new ArrayList<>();

    //singleton
    private volatile static CentralOffice Office1;

    /**
     * Instantiates a new Central office. Set to private, that way Singleton Design Pattern works
     */
    private CentralOffice() {}

    /**
     * One central office. Singleton applied, this means, this class can only be created once
     *
     * @return the central office
     */
    public static CentralOffice OneCentralOffice() {
        if (Office1 == null) {
            synchronized (CentralOffice.class) {
                if (Office1 == null) {
                    Office1 = new CentralOffice();
                    Office1.name = "Central Office"; // technically CentralOffice has no name
                }
            }
        }
        return Office1;
    }

    /**
     * Creates city office
     *
     * @param city --> assigned city
     * @return city office
     */
    public CityOffice createCityOffice(String city){
        CityOffice aCityOffice = new CityOffice(city);
        ultimateList.add(aCityOffice);
        return aCityOffice;
    }

    /**
     * Gets status of central office, boolean. This makes sure that only the Central Office can create City Offices.
     * Method used in City Office - Constructor
     * @return boolean
     */
    public static boolean getStatusOfCentralOffice(){
        boolean status;
        if (Office1 ==null){
            status = false;
        }
        else{
            status = true;
        }
        return status;
    }

    /**
     * Prints all City Bakeries with their corresponding Bakeries.
     * Print Design example: City Office 1
     *                       Bakery 1
     *                       Bakery 2
     *
     *                       City Office 2
     *                       Bakery 1
     *                       etc.
     */
    public void printAllOffices(){
        for(CityOffice c: ultimateList){
            System.out.println(c.getName());
            c.printAllBakeriesNames();
            System.out.println(""); // for space between different CityOffice
        }
    }
}
