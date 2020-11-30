package com.nick.ttt;

import javax.security.auth.callback.TextInputCallback;
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

    public char index(int ref) {
        return this.getGameBoard().getBoard()[ref];
    }

    public void drawBoard() { // visual display for the human
        char[] board = this.getGameBoard().getBoard();
        System.out.println(" " + board[0] + " ¦ " + board[1] + " ¦ " + board[2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[3] + " ¦ " + board[4] + " ¦ " + board[5]);
        System.out.println("---+---+---");
        System.out.println(" " + board[6] + " ¦ " + board[7] + " ¦ " + board[8]);
    }

    public void twoPlayer() {
        Scanner sc = new Scanner(System.in);
        Player playerOne = new Player('O', false);
        Player playerTwo = new Player('X', false);
        this.players = new Player[]{playerOne, playerTwo};

        System.out.print("Enter a name for player 1: ");
        playerOne.setName(sc.next());
        System.out.print("Enter a name for player 2: ");
        playerTwo.setName(sc.next());

        boolean gameOver = false;
        do {
            for (Player player : players) {
                if (this.getGameBoard().gameWon()) {
                    System.out.println(player.getName() + " is the winner!!!");
                    gameOver = true;
                    continue;
                }
                System.out.print(player.getName() + ", it's your turn. Pick a move: ");
                this.getGameBoard().placePiece(player.getSymbol(), Integer.parseInt(sc.next()));
                this.drawBoard();
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
        sample.drawBoard();

        TicTacToeGame ttt = new TicTacToeGame();
        ttt.twoPlayer();
    }
}
