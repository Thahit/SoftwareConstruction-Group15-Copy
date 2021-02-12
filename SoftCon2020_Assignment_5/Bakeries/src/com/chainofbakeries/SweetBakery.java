package com.chainofbakeries;

/**
 * The type Sweet bakery. It only supports Sweets
 */
public class SweetBakery extends Bakery{
    /**
     * Creates a SweetBakery
     *
     * @param Address of the bakery
     * @param Name of the bakery
     */
    public SweetBakery(String[] Address, String Name){
        super(Address, Name);
    }

    /**
     * @throws UnsupportedOperationException since method is not (allowed to be) used by this class
     */
    @Override
    public Bread createSandwich(){
        throw new UnsupportedOperationException();
    }

    /**
     * @throws UnsupportedOperationException since method is not (allowed to be) used by this class
     */
    @Override
    public Bread addHam(Bread something){
        throw new UnsupportedOperationException();
    }

    /**
     * @throws UnsupportedOperationException since method is not (allowed to be) used by this class
     */
    @Override
    public Bread addTomatoes(Bread something){
        throw new UnsupportedOperationException();
    }

    /**
     * @throws UnsupportedOperationException since method is not (allowed to be) used by this class
     */
    @Override
    public Bread addCheese(Bread something){
        throw new UnsupportedOperationException();
    }

    /**
     * @throws UnsupportedOperationException since method is not (allowed to be) used by this class
     */
    @Override
    public Bread addTuna(Bread something){
        throw new UnsupportedOperationException();
    }
}
