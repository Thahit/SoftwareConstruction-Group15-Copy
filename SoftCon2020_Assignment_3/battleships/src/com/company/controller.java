package com.company;

import java.util.Hashtable;

public class controller {
    // valid placement coordinates?
    static boolean CheckCoordinates(String coordiante, int boatLen, String[][] b) {
        if (coordiante.length() !=5){
            return false;//check len
        }
        //check coordinates
        // letters
        Hashtable<Character, Integer> translationDict= Board.CoordinateTranslation();
        if (!(translationDict.containsKey(coordiante.charAt(0))) || !(translationDict.containsKey(coordiante.charAt(3)))){
            return false;
        }
        // ints
        if ((! Character.isDigit(coordiante.charAt(1)) ) || (! Character.isDigit(coordiante.charAt(4)))){
            return false;
        }
        //check for space
        if (coordiante.charAt(2)!=' '){
            return false;
        }
        //check correct len
        //horizontal
        if(coordiante.charAt(0)==coordiante.charAt(3)){
            if ((coordiante.charAt(4)+1)-coordiante.charAt(1) ==boatLen) {// correct len
                for (int i=Integer.parseInt(String.valueOf(coordiante.charAt(1)))    ; i <=Integer.parseInt(String.valueOf(coordiante.charAt(4)))   ; i++){
                    if(!b[i][Board.TransformXAxis(coordiante.charAt(3))].equals("[ ]")){
                        return false; // there is already stg.
                    }
                }
                return true;
            }
        }//Vert...
        else if(coordiante.charAt(4)==coordiante.charAt(1)) {
            if ((Board.TransformXAxis(coordiante.charAt(3))+1) - ((Board.TransformXAxis(coordiante.charAt(0)))) == boatLen) {// correct len
                for (int i = Board.TransformXAxis(coordiante.charAt(0)); i <= Board.TransformXAxis(coordiante.charAt(3))   ; i++){
                    if(! b[Integer.parseInt(String.valueOf(coordiante.charAt(1)))][i].equals("[ ]")) {
                        return false; // there is already stg.
                    }
                }
                return true;
            }
        }
        return false;
    }
    // valid shot coordiates entered?
    static boolean ValidShot (String coordinateShot, String[][] targetboard){
        if (coordinateShot.length() !=2){
            return false;//check len
        }

        //check coordinates
        // letters
        Hashtable<Character, Integer> translationDict= Board.CoordinateTranslation();
        if (!(translationDict.containsKey(coordinateShot.charAt(0)))){
            return false;
        }
        // ints
        if (! Character.isDigit(coordinateShot.charAt(1))){
            return false;
        }
        //check if valid target
        if(targetboard[Integer.parseInt(String.valueOf(coordinateShot.charAt(1)))][Board.TransformXAxis(coordinateShot.charAt(0))].equals("[ ]")){
            return true;
        }
        return false;

    }
    // did something get hit?
    static boolean Hitcheck(String[][] Board, String att){
        if(Board[Integer.parseInt(String.valueOf(att.charAt(1)))][com.company.Board.TransformXAxis(att.charAt(0))].equals("[ ]")){
            return false;
        }
        return true;
    }
}