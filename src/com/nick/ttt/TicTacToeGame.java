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



    public static void main(String[] args) {
        TicTacToeGame ttt = new TicTacToeGame();
    }
}
