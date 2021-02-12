package com.company;

import java.util.Hashtable;

public class controller {
    static boolean CheckCoordinates(String coordiante, int boatLen, String[][] b) {
        if (coordiante.length() !=5){
            return false;//check len
        }

        //check coordinates
        // letters
        Hashtable<Character, Integer> translationDict= board.CoordinateTranslation();
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
                    if(!b[i][board.transformXAxis(coordiante.charAt(3))].equals("[ ]")){
                        return false; // there is already stg.
                    }
                }
                return true;
            }
        }//Vert...
        else if(coordiante.charAt(4)==coordiante.charAt(1)) {
            if ((board.transformXAxis(coordiante.charAt(3))+1) - ((board.transformXAxis(coordiante.charAt(0)))) == boatLen) {// correct len
                for (int i=board.transformXAxis(coordiante.charAt(0))    ; i <=board.transformXAxis(coordiante.charAt(3))   ; i++){
                    if(! b[Integer.parseInt(String.valueOf(coordiante.charAt(1)))][i].equals("[ ]")) {
                        return false; // there is already stg.
                    }
                }
                return true;
            }
        }
        return false;
    }
}
