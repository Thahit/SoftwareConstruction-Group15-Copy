package com.company;

import java.util.*;

public class Board {
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
    static Integer TransformXAxis(Character x) {
        Hashtable<Character, Integer> xAxis= CoordinateTranslation();
        return xAxis.get(x);
    }

    static String[][] GenerateBoard() {

        String[][] gameboard = new String[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                gameboard[i][j] = "[ ]";
            }
        }
        return gameboard;
    }

    static void PrintBoard(String[][] x) {
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
    static public void PrintShip(int x1, int x2, int y1, int y2, Ship s, String[][] board){
        if(x1==x2){
            for(int i = y1; i <= y2; i++){
                board[i][x1] = s.shipChar();
                String data = String.format("%c%d",(char) x1+65, i);
                s.getCoordinates().add(data);
            }
        }else {
            for (int i = x1; i <= x2; i++) {
                board[y1][i] = s.shipChar();
                String data = String.format("%c%d",(char) i+65, y1);
                s.getCoordinates().add(data); // e.g. [B2, B3, B4] --> string
            }
        }
    }
}