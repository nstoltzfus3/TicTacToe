package com.nick.ttt;

import com.nick.ttt.Players.HumanPlayer;
import com.nick.ttt.Players.Player;
import com.nick.ttt.Players.RandomAIPlayer;

import java.util.*;

public class TicTacToeGame {
    // TODO: List fields here.
    // Some gameboard representation.

    private TicTacToeBoard gameBoard;
    private Player[] players;

    // TODO: Make constructor
    public TicTacToeGame() {
        this.gameBoard = new TicTacToeBoard();
    }

    public TicTacToeBoard getGameBoard() {
        return this.gameBoard;
    }

    public void setGameBoard(TicTacToeBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public char index(int ref) {
        return this.getGameBoard().getBoard()[ref];
    }



    public void twoPlayer() {
        Scanner sc = new Scanner(System.in);

        Player playerOne = new HumanPlayer('X', false);
        Player playerTwo = new HumanPlayer('O', false);

        this.players = new Player[]{playerOne, playerTwo};

        System.out.print("Enter a name for player 1: ");
        playerOne.setName(sc.next());
        System.out.print("Enter a name for player 2: ");
        playerTwo.setName(sc.next());

        boolean gameOver = false;
        do {
            for (Player player : players) {
                System.out.println(player.getName() + ", it's your turn. Pick a move: ");

                player.makeMove(this.getGameBoard());
                this.getGameBoard().drawBoard();

                if (this.getGameBoard().gameWon()) {
                    System.out.println(player.getName() + " is the winner!!!");
                    gameOver = true;
                    break;
                }
            }

        } while (!gameOver);
    }

    public void onePlayer() {
        Scanner sc = new Scanner(System.in);


        Player playerOne = new HumanPlayer('X', false);
        Player playerTwo = new RandomAIPlayer('O', false);

        this.players = new Player[]{playerOne, playerTwo};

        System.out.print("Enter a name for player 1: ");
        playerOne.setName(sc.next());
        playerTwo.setName("Random AI Destructor");

        boolean gameOver = false;
        do {
            for (Player player : players) {
                System.out.println(player.getName() + ", it's your turn. Pick a move: ");
                this.getGameBoard().drawBoard();
                player.makeMove(this.getGameBoard());


                if (this.getGameBoard().gameWon()) {
                    System.out.println(player.getName() + " is the winner!!!");
                    gameOver = true;
                    break;
                }
            }

        } while (!gameOver);
    }

    public static void main(String[] args) {
        // print welcome message
        System.out.print("###############################\n  WELCOME TO TIC TAC " +
                "TOE GAME\n###############################\n");
        System.out.println("You will make your move by entering a position number, 1 - 9, corresponding to the board " +
                "below.");
        TicTacToeGame sample = new TicTacToeGame();
        sample.setGameBoard(new TicTacToeBoard(new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8'}));
        sample.getGameBoard().drawBoard();

        TicTacToeGame ttt = new TicTacToeGame();


        Scanner myScan = new Scanner(System.in);

        while (true) {
            System.out.println("Would you like to play vs a human or a AI (1 = human, 2 = AI). If you are done playing, enter 'q'.");
            String response = myScan.next();
            if (response.equals("q")) {
                break;
            }
            if (Integer.parseInt(response) == 1) {
                ttt.twoPlayer();
            } else if (Integer.parseInt(response) == 2) {
                ttt.onePlayer();
            } else {
                System.out.print("Please enter a valid number, enjoy!");
            }
        }

    }
}
