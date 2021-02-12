package com.chainofbakeries;

/**
 * This Class is only here to test the program since we weren't supposed to implement Tests in Ex 1.
 */
public class testClassMain {
    /**
     * Only testing purpose
     */
    public static void main(String[] args){

        // init CentralOffice etc.
        BakeryComponent theOne = CentralOffice.OneCentralOffice();
        BakeryComponent districtA =  theOne.createCityOffice("Bern");
        // waste of time to create 5 addresses
        String[] addr = districtA.definingAddress("street 13", "9999");
        String[] addr2 = districtA.definingAddress("street 14", "9999");
        BakeryComponent bakeryAA = districtA.createBakery(true,false, "bakeryAA", addr);

        //testing print names
        // it should work with BakeryComponent because of the pattern
        BakeryComponent bakeryAB = districtA.createBakery(false, true, "bakeryAB", addr);
        BakeryComponent bakeryAC = districtA.createBakery(true, true, "bakeryAC", addr2);
        BakeryComponent districtB = theOne.createCityOffice("Zurich");
        Bakery bakeryBA = districtB.createBakery(true, true, "bakeryBA", addr);
        BakeryComponent bakeryBB = districtB.createBakery(true, false, "bakeryBB", addr);

        BakeryComponent districtC = theOne.createCityOffice("Glarus");

        theOne.printAllOffices();
        districtA.printAllBakeriesNames();
        bakeryBB.printName();

        // should return an exception  (it does)
//        bakeryBA.createBakery(true, true, "bakeryBA", addr);


        for (String s: bakeryBA.returnAddress()){
            System.out.println(s);
        }


        //testing baking
        Bread sandwi = bakeryAB.createSandwich();
        Bread top = bakeryAB.addCheese(sandwi);
        Bread top2 = bakeryAB.addCheese(top);
        Bread top3 = bakeryAB.addTomatoes(top2);
        Bread top4 = bakeryAB.addTomatoes(top3);
        System.out.println(bakeryAA.calcPricePastry(top4));

        Sweets cak = bakeryAC.createCake();
        Sweets filling = bakeryAC.addChocolate(cak);
        System.out.println(bakeryAA.calcPricePastry(filling));

        }
}
