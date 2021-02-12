package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        setUpBoard();
    }

    public static void setUpBoard() {
        System.out.println("Welcome to Battleship!!\n");

        //generating board and ships
        String[][] myboard = board.generateBoard();
        ship carrier1 = new Carrier();
        ship battleship1 = new Battleship();
        ship battleship2 = new Battleship();
        ship submarine1 = new Submarine();
        ship submarine2 = new Submarine();
        ship submarine3 = new Submarine();
        ship patrolBoat1 = new PatrolBoat();
        ship patrolBoat2 = new PatrolBoat();
        ship patrolBoat3 = new PatrolBoat();
        ship patrolBoat4 = new PatrolBoat();
        List<ship> Shiplist = new ArrayList<>(Arrays.asList(carrier1, battleship1,battleship2, submarine1
                , submarine2, submarine3,patrolBoat1,patrolBoat2, patrolBoat3,patrolBoat4));

        // generating the ships
        for (ship s:Shiplist){
            s.Place(myboard, s);
        }
        //For Testing Purpose use these coordinates (A1 A6 for carrier, B1 B4 for Battleship 1 etc.)
        //A1 A6   B1 B4  C1 C4 A0 C0   D0 F0   D1 D3   D4 D5   D6 D7   D8 D9   E8 E9

        //final board
        board.printBoard(myboard);
    }
}
