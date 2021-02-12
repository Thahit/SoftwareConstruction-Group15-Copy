package com.chainofbakeries;

/**
 * The type Sweets dekorator.
 */
public abstract class SweetsDekorator extends Sweets{
    protected Sweets base;
    // i did not change the cost here, and let it get inherited, because it sould not work on the decorator itself
}
