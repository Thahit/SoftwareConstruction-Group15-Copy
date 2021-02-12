package com.company;

public class TheGame {

    // loops through PlayerAttack and EnemyAttack --> if either returns true --> Game over
    public static void Loop(String[][] playerBoard, String[][] EnemyBoard, Player Self, Player Opp) {
        boolean player_status;
        boolean opponent_status;

        do {
           printStats(playerBoard, Self);

           /*
            //these boards might help to "cheat" for testing
            System.out.println("\n\ncurrently cheating board is (opponents board:\n");
            Board.PrintBoard(EnemyBoard); // currently printing enemys board
            System.out.println("\nThe opponent's Memoryboard is:");

            Opp.RecallGamestate();*/

            player_status = Self.Attack(EnemyBoard); //maps have to be printed again before game is completly over!!!!!
            if(player_status){
                printStats(playerBoard, Self);
                break;
            }
            opponent_status = Opp.Attack(playerBoard);
            if(opponent_status){
                printStats(playerBoard, Self);
                break;
            }
        }while(!(player_status || opponent_status));

        if (player_status) {
            System.out.println("Congratulations, you won!");
        } else {
            System.out.println("Sorry, you lost!");
        }
    }

    private static void printStats(String[][] playerBoard, Player Self){
        System.out.println("\nYour board is:\n");
        Board.PrintBoard(playerBoard);
        System.out.println("\nThe opponent's board is:");
        Self.RecallGamestate();
        System.out.println(String.format("\nYour scoreboard:\n   - Player remaining boats: %d\n   - Enemy boats destroyed: %d\n", Playable.getShipList().size(), Opponent.getAmount_of_ships() - Opponent.getShipList().size()));
    }
}