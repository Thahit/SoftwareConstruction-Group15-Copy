package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Opponent implements Player, Observable{
    private static int amount_of_ships;
    private static List<Ship> reference = new ArrayList<>(); // so subjects-methods can be applied
    private static ArrayList<String> reference_attack = new ArrayList<>(); // so subjects-methods can be applied
    public String[][] Memory = Board.GenerateBoard();

    //singleton
    private volatile static Opponent OneOpponent;

    private Opponent() {}
    public static Opponent OneOpponent() {
        if (OneOpponent == null) {
            synchronized (Opponent.class) {
                if (OneOpponent == null) {
                    OneOpponent = new Opponent();
                }
            }
        }
        return OneOpponent;
    }

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

    public void StartGame(String[][] myboard){
        ShipList shipIterator = new ShipList();
        Iterator shipList = shipIterator.createIterator();

        reference = shipList.fullShipList(); // copying the original list

        amount_of_ships = reference.size();
        // generating the ships
        while (shipList.hasNext()){
            this.Place(myboard, shipList.currentShip(), this);
            shipList.next();
        }
    }
    public static int getAmount_of_ships(){
        return amount_of_ships;
    }
    public static List<Ship> getShipList() {
        return reference;
    }

    public void Place(String[][] myboard, Ship s, Player p){

        String[] carrierCoordinate = new String[1];
        carrierCoordinate[0] = GenerateCoordinates(s.shipLength());

        while (! controller.CheckCoordinates( carrierCoordinate[0],  s.shipLength(), myboard)) {
            carrierCoordinate[0] = GenerateCoordinates(s.shipLength());
        }

        // getting coordinates
        int x1 = Board.TransformXAxis(carrierCoordinate[0].charAt(0));
        int y1 = Integer.parseInt(String.valueOf(carrierCoordinate[0].charAt(1)));
        int x2 = Board.TransformXAxis(carrierCoordinate[0].charAt(3));
        int y2 = Integer.parseInt(String.valueOf(carrierCoordinate[0].charAt(4)));

        //draw ship
        Board.PrintShip(x1,x2,y1,y2, s, myboard);
    }
    private String GenerateShootingCoordinates(){
        Random rand = new Random();
        int help= rand.nextInt(10);// generates number to convert to char

        char Coord1 = (char) (help+65);//letter
        int Coord2 = rand.nextInt(10);

        String s = String.format("%c%d", Coord1,Coord2);
        return s;

    }
    private String GenerateCoordinates(int len){
        Random rand = new Random();

        int Direction=rand.nextInt(2);//0,1 for hor/vert

        if (Direction==0) {//hor

            int help= rand.nextInt(10-len);// generates number to convert to char

            char Coord1 = (char) (help+65);//letter
            int Coord2 = rand.nextInt(10-len);
            int Coord3 = (char) (help+len+65-1);//letter
            int Coord4 = Coord2;

            String s = String.format("%c%d %c%d", Coord1,Coord2 ,Coord3,Coord4);
            return s;
        }else{
            int help= rand.nextInt(10-len);// generates number to convert to char

            char Coord1 = (char) (help+65);//letter
            int Coord2 = rand.nextInt(10-len);
            int Coord3 = (char) (help+65);//letter
            int Coord4 = Coord2+len-1;
            String s = String.format("%c%d %c%d", Coord1,Coord2 ,Coord3,Coord4);
            return s;
        }
    }

    public boolean Attack(String[][] Board){
        String[] att = new String[1];
         att[0]=this.GenerateShootingCoordinates();
        while(!controller.ValidShot(att[0],this.Memory)){
             att[0]=this.GenerateShootingCoordinates();
        }

        //update Map
        reference_attack.add(0,att[0]); // override

        System.out.println(String.format("The Computer attacks position %s", reference_attack.get(0)));
        if(!(controller.Hitcheck(Board, att[0]))){
            Memory[Integer.parseInt(String.valueOf(att[0].charAt(1)))][com.company.Board.TransformXAxis(att[0].charAt(0))]="[O]";// no hit
            Board[Integer.parseInt(String.valueOf(att[0].charAt(1)))][com.company.Board.TransformXAxis(att[0].charAt(0))]="[O]";
            System.out.println("The computer missed");
        }
        else{
            Memory[Integer.parseInt(String.valueOf(att[0].charAt(1)))][com.company.Board.TransformXAxis(att[0].charAt(0))] = "[X]"; // hit
            Board[Integer.parseInt(String.valueOf(att[0].charAt(1)))][com.company.Board.TransformXAxis(att[0].charAt(0))]="[X]";
            Playable.notifyCorrespondingObservers(Memory); // updates corresponding ship and if destroyed, it will be deleted from ship list
            System.out.println("Your boat was hit!");
            if(Playable.getShipList().size() == 0){
                return true;
            }
        }
        return false;
    }
    public static ArrayList<String> get_reference_attack(){
        return reference_attack;
    }

    /*
    The following methods are the second observable subject's methods (out of two, playable is the other one)
     */
    public static void NotifyCorrespondingObservers(String[][] p) {
        outerloop:
        for (Ship s : reference) {
            for (int i = 0; i < s.getCoordinates().size(); i++) {
                if (s.getCoordinates().get(i).equals(Playable.get_reference_attack().get(0))) {
                    if (s.update(s)) {
                        // "shows" the destroyed ships
                        ArrayList<String> DrawCoordinates=s.getCoordinates();
                        for(String c: DrawCoordinates){
                            p[Integer.parseInt(String.valueOf(c.charAt(1)))][Board.TransformXAxis(c.charAt(0))]=s.shipChar();
                        }
                        RemoveObserver(s);
                    }
                    break outerloop;
                }
            }
        }
    }

    protected static void RemoveObserver(Ship a_ship) {
        reference.remove(a_ship);
        System.out.println(String.format("You destroyed a %s", a_ship.Name()));
    }
}