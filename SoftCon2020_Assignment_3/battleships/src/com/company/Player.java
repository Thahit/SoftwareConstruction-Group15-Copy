package com.company;

public interface Player {
    /**
     * Creates the boats and places them
     * Input: String[][] myboard
     */
    void StartGame(String[][] myboard);
    /**
     * places the ships
     * Input: String[][] myboard, Ship s, Player p
     */
    void Place(String[][] myboard, Ship s, Player p);
    /**
     * @return boolean value - true, if all ships are destroyed, false otherwise. Shoots at targeted field on enemy board
     * Input: String[][] myboard
     */
    boolean Attack(String[][] Board);
    /**
     * Shows the memoryboard of the Player(what they hit/missed...)
     */
    void RecallGamestate();
}