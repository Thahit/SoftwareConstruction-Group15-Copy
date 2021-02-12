package com.swcgroup15.assignment4;

public interface State {
    /**
     * @param bill, CreditCard's limit behaves based on Creditcard current status (Regular, Golden, Platinum)
     */
    void useCreditCard(float bill);

    /**
     *
     * @param customer
     * @return Upgraded Status. Throws exception if highest status has been reached
     */
    State upgrade(Customer customer);

    /**
     *
     * @param customer
     * @return Downgraded Status. Throws exception if lowest status has been reached
     */
    State downgrade (Customer customer);
}