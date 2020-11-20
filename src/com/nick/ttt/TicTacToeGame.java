package com.nick.ttt;

import javax.security.auth.callback.TextInputCallback;
import java.util.ArrayList;
import java.util.Arrays;

public class TicTacToeGame {
    // TODO: List fields here.
    // Some gameboard representation.
    private char[] gameBoard;

    // TODO: Make constructor
    public TicTacToeGame() {
        this.gameBoard = new char[]{0, 0, 0, 0, 0, 0, 0, 0, 0}; // initialize a blank "board"
    }

    // TODO: Generate Getters and Setters
    public char[] getGameBoard() {
        return gameBoard;
    }

    // TODO: Required methods below
    /*
    1. Be able to index to a specific square.
        index(<some reference to a position>)
        return: value at that position
    2. Detect the end of a game. Returns true if the game is over.
        gameIsOver()
        return: boolean
    3. Method to place a piece on the board.
        placePiece(<piece X or O>, <position>)
        return: void
    4.
     */

    public char index(int ref) {
        return getGameBoard()[ref];
    }

    public void drawBoard() { // visual display for the human
        char[] board = this.getGameBoard();
        System.out.println(" " + board[0] + " ¦ " + board[1] + " ¦ " + board[2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[3] + " ¦ " + board[4] + " ¦ " + board[5]);
        System.out.println("---+---+---");
        System.out.println(" " + board[6] + " ¦ " + board[7] + " ¦ " + board[8]);
    }

    public void placePiece(char xo, int pos) {
        this.getGameBoard()[pos] = xo;
    }

    public ArrayList<Integer> findEmpties() {
        ArrayList<Integer> empties = new ArrayList<>();
        char[] board = this.getGameBoard();
        for (int i = 0; i < board.length; i++) {
            if (board[i] == 0) {
                empties.add(i);
            }
        }
        return empties;
    }

    public static void main(String[] args) {
        TicTacToeGame ttt = new TicTacToeGame();
    }
}
