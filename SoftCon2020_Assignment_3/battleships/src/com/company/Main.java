package com.company;

public class Main {

    public static void main(String[] args) {
        SetUpBoard();
    }

    public static void SetUpBoard() {
        System.out.println("Welcome to Battleship!!\n");

//        generating board and players
        String[][] myboard = Board.GenerateBoard();
        Player self=new Playable();
        self.StartGame(myboard);
        String[][] Enboard = Board.GenerateBoard();
        Player Opponent= com.company.Opponent.OneOpponent();
        Opponent.StartGame(Enboard);
        TheGame.Loop(myboard, Enboard, self,Opponent);

        //For Testing Purpose use these coordinates (A1 A6 for carrier, B1 B4 for Battleship 1 etc.)
        //A1 A6   H1 H4  C1 C4 A0 C0   D0 F0   D1 D3   D4 D5   D6 D7   D8 D9   J8 J9
    }
}