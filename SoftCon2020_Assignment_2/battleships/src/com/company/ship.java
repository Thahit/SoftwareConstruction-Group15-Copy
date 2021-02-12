package com.company;


public interface ship {
    /**
     * @return int shiplength
     */
    int shipLength();
    /**
     * @return Char how the ship looks like
     */
    String shipChar();

    /**
     * places the ships
     * Input: String[][] myboard, ship s
     */
    void Place(String[][] myboard, ship s);
}