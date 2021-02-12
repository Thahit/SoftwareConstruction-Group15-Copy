package com.company;

import java.util.ArrayList;

public interface Ship {

    /**
     * @return int shiplength
     */
    int shipLength();
    /**
     * @return Str how the ship looks like
     */
    String shipChar();
    /**
     * @return Str name of ship
     */
    String Name();

    /**
     * @return boolean value - if a ship got hit, it will be updated. If ship has reached its maximum hit-score, it will
     * return boolean value = true. Otherwise false.
     */
    boolean update(Ship s);

    /**
    * @return ArrayList - the ship's corresponding coordinates
     */
    ArrayList getCoordinates();

}