package com.company;

import java.util.Scanner;

public class PatrolBoat  implements ship{
    private static int currentShip; //Ship Nr. in Console
    private final int length = 2;
    private String img = "[P]";

    public int shipLength(){
        return length;
    }

    public String shipChar(){
        return img;
    }

    public void Place(String[][] myboard, ship s){
        currentShip++;
        String[] carrierCoordinate = new String[1];
        Scanner sc = new Scanner(System.in);
        System.out.print(String.format("Please enter the position of your Patrol boat %d: ", currentShip));
        carrierCoordinate[0] = sc.nextLine();

        while (! controller.CheckCoordinates( carrierCoordinate[0],  s.shipLength(), myboard)) {
            System.out.print("The specified input is invalid\n");
            System.out.print(String.format("Please enter the position of your Patrol boat %d: ", currentShip));
            carrierCoordinate[0] = sc.nextLine();
        }

        // getting coordinates
        int x1 = board.transformXAxis(carrierCoordinate[0].charAt(0));
        int y1 = Integer.parseInt(String.valueOf(carrierCoordinate[0].charAt(1)));
        int x2 = board.transformXAxis(carrierCoordinate[0].charAt(3));
        int y2 = Integer.parseInt(String.valueOf(carrierCoordinate[0].charAt(4)));

        //draw ship
        board.printShip(x1,x2,y1,y2, s, myboard);
    }
}
