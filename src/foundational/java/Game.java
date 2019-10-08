package foundational.java;

import java.util.HashMap;
import java.util.Scanner;

public class Game {
    private static int player1Score = 0;
    private static int player2Score = 0;
    private static HashMap<String, Integer> history = new HashMap<>();

    protected static void mainMenu() {
        System.out.println("\n1. Type 'play' to play.");
        System.out.println("2. Type 'history' to view your game history.");
        System.out.println("3. Type 'quit' to stop playing.\n");

        String input = getInput();
        for (int i = 3; i > 0; i--) {
            if (input != null && input.equals("play")) play();
            else if (input.equals("history")) history();
            else if (input.equals("quit")) {
                System.out.println("Sad to see you go :(");
                System.exit(0);
            }
            else {
                System.out.println("\nInvalid input, you have " + i + " tries before app shuts down");
                input = getInput();
            }
        }

    }

    private static void  play() {
        System.out.println("\nWould you like to play with another player or computer?");
        System.out.println("1. Type 'player' to play against another measly human.");
        System.out.println("2. Type 'computer' to play against the mighty computer.");

        String input = getInput();
        for (int i = 3; i > 0; i--) {
            if (input != null && input.equals("player")) {
                System.out.println("Welcome to the game of the humans");

                //initiate player1
                Player player1 = new InitiatePlayer();
                System.out.println("Input the name of first player");
                String name = getInput();
                player1.setName(name);
                System.out.println("What is your move (rock, paper, scissors) " + player1.getName() + "?");
                player1.setMove(playMove());

                //initiate player2
                Player player2 = new InitiatePlayer();
                System.out.println("Input the name of second player");
                String name2 = getInput();
                player2.setName(name2);
                System.out.println("What is your move (rock, paper, scissors) " + player2.getName()+ "?");
                player2.setMove(playMove());
                declareWinner(player1, player2);

            } else if (input.equals("computer")) {
                System.out.println("\nNow play against Ex Machina");
                Player player1 = new InitiatePlayer();
                System.out.println("Input the name of first player");
                player1.setName(getInput());
                System.out.println("What is your move (rock, paper, scissors) " + player1.getName() + "?");
                player1.setMove(playMove());
                InitiatePlayer player2 = new InitiatePlayer();
                player2.computerPlayer(player2);
                declareWinner(player1, player2);

            } else if (input.equals("quit")){
                mainMenu();
            } else {
                System.out.println("\nInvalid input, you have " + i + " attempt/s before app shuts down. Type 'quit' to go back");
                input = getInput();
            }
        }
    }
    private static void declareWinner (Player player1, Player player2) {

        String winner = null;

        if (player1.getMove().equals(player2.getMove())) {
            winner = "It was a tie with the move of " + player1.getMove() + " by " + player1.getName() + " and " + player2.getName();
        } else if (player1.getMove().equals("rock")) {
            if (player2.getMove().equals("scissors")) {
                winner = player1.getName() + " wins with amazing move of " + player1.getMove() + " against " + player2.getMove() + ".";
                player1Score++;
            } else {
                winner = player2.getName() + " wins with the amazing move of " + player2.getMove() + " against " + player1.getMove() + ".";
                player2Score++;
            }
        } else if (player1.getMove().equals("scissors")) {
            if (player2.getMove().equals("paper")){
                winner = player1.getName() + " wins with amazing move of " + player1.getMove() + " against " + player2.getMove() + ".";
                player1Score++;
            } else {
                winner = player2.getName() + " wins with the amazing move of " + player2.getMove() + " against " + player1.getMove() + ".";
                player2Score++;
            }
        } else if (player1.getMove().equals("paper")) {
            if (player2.getMove().equals("rock")){
                winner = player1.getName() + " wins with amazing move of " + player1.getMove() + " against " + player2.getMove() + ".";
                player1Score++;
            } else {
                winner = player2.getName() + " wins with the amazing move of " + player2.getMove() + " against " + player1.getMove() + ".";
                player2Score++;
            }
        }

        System.out.println(winner);
        player1.setScore(player1Score);
        player2.setScore(player2Score);
        history.put(player1.getName(), player1.getScore());
        history.put(player2.getName(), player2.getScore());
        System.out.println(player1.getName() + ": " + player1.getScore() + " | " + player2.getName() + ": " + player2.getScore());
        System.out.println("\nLet the games continue." );
        mainMenu();
    }

    //play the move and check if it is valid against the available options with 3 attempts
    public static String playMove () {
        String move = getInput();
        for (int i = 3; i > 0; i--) {
            if (move.equals("rock") || move.equals("paper") || move.equals("scissors")) return move;
            else {
                System.out.println("Invalid move, you have " + i + " tries left before game exits");
                move = getInput();
            }
        }
        return move;
    }

    //show history or ask them to play with no history
    private static void history() {
        if (history.size() > 0) {
//            System.out.println(history);

            history.entrySet().stream().forEach(System.out::println);
        } else System.out.println("No history, play to create some");

        mainMenu();
    }
    //helper method to get user input
    private static String getInput() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().toLowerCase();
        return input;
    }
}
