package com.chainofbakeries;

/**
 * The type Bread bakery. It only supports Bread
 */
public class BreadBakery extends Bakery {

    /**
     * creates a BreadBakery
     *
     * @param Address of the bakery
     * @param Name of the bakery
     */
    public BreadBakery(String[] Address, String Name){
        super(Address, Name);
    }

    /**
     * @throws UnsupportedOperationException since method is not (allowed to be) used by this class
     */
    @Override
    public Sweets createCake(){
        throw new UnsupportedOperationException();
    }

    /**
     * @throws UnsupportedOperationException since method is not (allowed to be) used by this class
     */
    @Override
    public Sweets addCream(Sweets something) {
        throw new UnsupportedOperationException();
    }

    /**
     * @throws UnsupportedOperationException since method is not (allowed to be) used by this class
     */
    @Override
    public Sweets addStrawberry(Sweets something) {
        throw new UnsupportedOperationException();
    }

    /**
     * @throws UnsupportedOperationException since method is not (allowed to be) used by this class
     */
    @Override
    public Sweets addChocolate(Sweets something) {
        throw new UnsupportedOperationException();
    }
}
