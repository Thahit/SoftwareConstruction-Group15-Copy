package com.chainofbakeries;

/**
 * The type Bakery component. It's the intersection of Bakery, City Office and CentralOffice.
 * Since there are no methods that are used by all these Subclasses, all methods throw UnsupportedOperationException
 */
public abstract class BakeryComponent {
    protected String name;

    /**
     * @see com.chainofbakeries.Bakery#createSandwich()
     * @throws UnsupportedOperationException if method is not (allowed to be) used by this class
     */
    public Bread createSandwich(){
        throw new UnsupportedOperationException();
    }

    /**
     * @see com.chainofbakeries.Bakery#createCake()
     * @throws UnsupportedOperationException if method is not (allowed to be) used by this class
     */
    public Sweets createCake(){
        throw new UnsupportedOperationException();
    }

    /**
     * @see com.chainofbakeries.Bakery#addHam(Bread)
     * @throws UnsupportedOperationException if method is not (allowed to be) used by this class
     */
    public Bread addHam(Bread something){
        throw new UnsupportedOperationException();
    }

    /**
     *  @see com.chainofbakeries.Bakery#addTomatoes(Bread)
     *  @throws UnsupportedOperationException if method is not (allowed to be) used by this class
     */
    public Bread addTomatoes(Bread something){
        throw new UnsupportedOperationException();
    }

    /**
     * @see com.chainofbakeries.Bakery#addCheese(Bread)
     * @throws UnsupportedOperationException if method is not (allowed to be) used by this class
     */
    public Bread addCheese(Bread something){
        throw new UnsupportedOperationException();
    }

    /**
     * @see com.chainofbakeries.Bakery#addTuna(Bread)
     * @throws UnsupportedOperationException if method is not (allowed to be) used by this class
     */
    public Bread addTuna(Bread something){
        throw new UnsupportedOperationException();
    }

    /**
     * @see com.chainofbakeries.Bakery#addCream(Sweets)
     * @throws UnsupportedOperationException if method is not (allowed to be) used by this class
     */
    public Sweets addCream(Sweets something) {
        throw new UnsupportedOperationException();
    }

    /**
     * @see com.chainofbakeries.Bakery#addStrawberry(Sweets)
     * @throws UnsupportedOperationException if method is not (allowed to be) used by this class
     */
    public Sweets addStrawberry(Sweets something) {
        throw new UnsupportedOperationException();
    }

    /**
     * @see com.chainofbakeries.Bakery#addChocolate(Sweets)
     * @throws UnsupportedOperationException if method is not (allowed to be) used by this class
     */
    public Sweets addChocolate(Sweets something) {
        throw new UnsupportedOperationException();
    }

    /**
     * @see com.chainofbakeries.Bakery#calcPricePastry(Pastries)
     * @throws UnsupportedOperationException if method is not (allowed to be) used by this class
     */
    public double calcPricePastry(Pastries aPastry){
        throw new UnsupportedOperationException();
    }

    /**
     * @see com.chainofbakeries.Bakery#printName()
     * @throws UnsupportedOperationException if method is not (allowed to be) used by this class
     */
    public void printName(){
        throw new UnsupportedOperationException();
    }

    /**
     * @see com.chainofbakeries.Bakery#returnAddress()
     * @throws UnsupportedOperationException if method is not (allowed to be) used by this class
     */
    public String[] returnAddress(){
        throw new UnsupportedOperationException();
    }

    /**
     * @see com.chainofbakeries.CityOffice#createBakery(boolean, boolean, String, String[])
     * @throws UnsupportedOperationException if method is not (allowed to be) used by this class
     */
    public Bakery createBakery(boolean sweet, boolean bread, String name, String[] address){
        throw new UnsupportedOperationException();
    }

    /**
     * @see com.chainofbakeries.CityOffice#definingAddress(String, String)
     * @throws UnsupportedOperationException if method is not (allowed to be) used by this class
     */
    public String[] definingAddress(String StreetnameNr, String postalCode){
        throw new UnsupportedOperationException();
    }

    /**
     * @see com.chainofbakeries.CityOffice#printAllBakeriesNames()
     * @throws UnsupportedOperationException if method is not (allowed to be) used by this class
     */
    public void printAllBakeriesNames(){
        throw new UnsupportedOperationException();
    }

    /**
     * @see com.chainofbakeries.CityOffice#getName()
     * @throws UnsupportedOperationException if method is not (allowed to be) used by this class
     */
    public String getName(){
        throw new UnsupportedOperationException();
    }

    /**
     * @see com.chainofbakeries.CentralOffice#OneCentralOffice()
     * @throws UnsupportedOperationException if method is not (allowed to be) used by this class
     */
    public static CentralOffice OneCentralOffice() {
        throw new UnsupportedOperationException();
    }

    /**
     * @see com.chainofbakeries.CentralOffice#createCityOffice(String)
     * @throws UnsupportedOperationException if method is not (allowed to be) used by this class
     */
    public CityOffice createCityOffice(String city){
        throw new UnsupportedOperationException();
    }

    /**
     * @see com.chainofbakeries.CentralOffice#getStatusOfCentralOffice()
     * @throws UnsupportedOperationException if method is not (allowed to be) used by this class
     */
    public static boolean getStatusOfCentralOffice(){
        throw new UnsupportedOperationException();
    }

    /**
     * @see com.chainofbakeries.CentralOffice#printAllOffices()
     * @throws UnsupportedOperationException if method is not (allowed to be) used by this class
     */
    public void printAllOffices(){
        throw new UnsupportedOperationException();
    }
}
