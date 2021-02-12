package com.company;

public interface Observable {
    /**
     * Notifies corresponding Observer. Observer is a ship and corresponding is a ship that got hit by the attack.
     * If a ship got hit, it will call update on it.
     */
    static void NotifyCorrespondingObservers() {};


    /**
     * if a ship has sunken, it'll be removed from the list and is therefore no longer an Observer
     */
    static void RemoveObserver(Ship a_ship){};
}