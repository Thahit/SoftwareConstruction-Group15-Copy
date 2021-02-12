package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Playable implements Player, Observable {
    private static ArrayList<Ship> reference = new ArrayList<>(); // so subjects-methods can be applied
    private static ArrayList<String> reference_attack = new ArrayList<>(); // so subjects-methods can be applied
    public String[][] Memory =  Board.GenerateBoard();

    public void RecallGamestate() {
        System.out.print("\n   |[A][B][C][D][E][F][G][H][I][J]\n---|------------------------------\n");
        for (int i = 0; i < 10; i++) {
            System.out.print("["+i+"]|");
            for (int j = 0; j < 10; j++) {
                System.out.print(this.Memory[i][j]);
            }
            System.out.println();
        }
    }

    public void StartGame(String[][] myboard) {
        //generate ships
        ShipList shipIterator = new ShipList();
        Iterator shipList = shipIterator.createIterator();

        reference = shipList.fullShipList(); // copying the original list

        while (shipList.hasNext()){
            this.Place(myboard, shipList.currentShip(), this);
            shipList.next();
        }
    }

    public static List<Ship> getShipList() {
        return reference;
    }

    public void Place(String[][] myboard, Ship s, Player p) {

        String[] carrierCoordinate = new String[1];
        Scanner sc = new Scanner(System.in);
        System.out.print(String.format("Please enter the position of your "+ s.Name())+": ");
        carrierCoordinate[0] = sc.nextLine();

        while (!controller.CheckCoordinates(carrierCoordinate[0], s.shipLength(), myboard)) {
            System.out.print("The specified input is invalid\n");
            System.out.print(String.format("Please enter the position of your "+ s.Name())+": ");
            carrierCoordinate[0] = sc.nextLine();
        }

        // getting coordinates
        int x1 = Board.TransformXAxis(carrierCoordinate[0].charAt(0));
        int y1 = Integer.parseInt(String.valueOf(carrierCoordinate[0].charAt(1)));
        int x2 = Board.TransformXAxis(carrierCoordinate[0].charAt(3));
        int y2 = Integer.parseInt(String.valueOf(carrierCoordinate[0].charAt(4)));

        //draw ship
        Board.PrintShip(x1, x2, y1, y2, s, myboard);
    }

    public  boolean Attack(String[][] Board){ // if PlayerAttack = true --> Player won
        String[] att = new String[1];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the position you want to attack: ");
        att[0] = sc.nextLine();
        while(!controller.ValidShot(att[0], this.Memory)){
            System.out.print("The specified input is invalid\n");
            System.out.println("Please enter the position of your attack again : ");
            att[0] = sc.nextLine();
        }
        //update Map
        reference_attack.add(0,att[0]); // override

        if(!(controller.Hitcheck(Board, att[0]))){
            Memory[Integer.parseInt(String.valueOf(att[0].charAt(1)))][com.company.Board.TransformXAxis(att[0].charAt(0))]= "[O]"; // no hit
            System.out.println("Miss");
        }
        else{
            Memory[Integer.parseInt(String.valueOf(att[0].charAt(1)))][com.company.Board.TransformXAxis(att[0].charAt(0))] = "[X]"; // hit
            System.out.println("You hit a boat!");
            Opponent.NotifyCorrespondingObservers(Memory); // updates corresponding ship and if destroyed, it will be deleted from ship list

            if(Opponent.getShipList().size() == 0){
                return true;
            }
        }
        return false;
    }
    public static ArrayList<String> get_reference_attack(){
        return reference_attack;
    }

    /*
    The following methods are the first observable subject's methods (out of two, opponent is the other one)
     */
    public static void notifyCorrespondingObservers(String[][] p) {
        outerloop:
        for (Ship s : reference) {
            for (int i = 0; i < s.getCoordinates().size(); i++) {
                if (s.getCoordinates().get(i).equals(Opponent.get_reference_attack().get(0))) {
                    if (s.update(s)) {
                        // "shows" the destroyed ships
                        ArrayList<String> DrawCoordinates=s.getCoordinates();
                        for(String c: DrawCoordinates){
                            p[Integer.parseInt(String.valueOf(c.charAt(1)))][Board.TransformXAxis(c.charAt(0))]=s.shipChar();
                        }
                        removeObserver(s);
                    }
                    break outerloop;
                }
            }
        }
    }

    protected static void removeObserver(Ship a_ship) {
        reference.remove(a_ship);
        System.out.println(String.format("Your %s was destroyed", a_ship.Name()));
    }
}