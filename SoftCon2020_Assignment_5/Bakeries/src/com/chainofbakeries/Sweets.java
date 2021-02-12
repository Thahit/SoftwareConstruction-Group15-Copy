package com.chainofbakeries;

/**
 * The type Sweets. It implements Pastries. That way bakery has only one calc-method.
 * @see com.chainofbakeries.Bakery#calcPricePastry(Pastries)
 * It also allows us to expand this program and add other type of Pastries, e.g. candy
 */
public abstract class Sweets implements Pastries {
    /**
     * @throws UnsupportedOperationException
     */
    public double cost() {
        throw new UnsupportedOperationException();
    }
}

