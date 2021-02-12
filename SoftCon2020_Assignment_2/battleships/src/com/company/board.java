package com.company;

import java.util.*;

public class board {
    static protected Hashtable  <Character, Integer> CoordinateTranslation() {
        //creating dictionary aka hashtable:
        Hashtable<Character, Integer> xAxis = new Hashtable<>();
        xAxis.put('A',0);
        xAxis.put('B',1);
        xAxis.put('C',2);
        xAxis.put('D',3);
        xAxis.put('E',4);
        xAxis.put('F',5);
        xAxis.put('G',6);
        xAxis.put('H',7);
        xAxis.put('I',8);
        xAxis.put('J',9);
        return  xAxis;
    }
    // transforming letters to array indices
    static Integer   transformXAxis(Character x) {
        Hashtable<Character, Integer> xAxis= CoordinateTranslation();
        return xAxis.get(x);
    }

    static String[][] generateBoard() {

        String[][] gameboard = new String[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                gameboard[i][j] = "[ ]";
            }
        }
        return gameboard;
    }

    static void printBoard(String[][] x) {
        System.out.print("\nYour board is:\n\n");
        System.out.print("   |[A][B][C][D][E][F][G][H][I][J]\n---|------------------------------\n");
        for (int i = 0; i < 10; i++) {
            System.out.print("["+i+"]|");
            for (int j = 0; j < 10; j++) {
                System.out.print(x[i][j]);
            }
            System.out.println();
        }
    }
    // puts the ships into the array
    static public void printShip(int x1,int x2,int y1,int y2,ship s, String[][] board){
        for(int i = x1; i <= x2; i++){
            board[y1][i] = s.shipChar();
        }
        for(int i = y1; i <= y2; i++){
            board[i][x1] = s.shipChar();
        }
    }
}