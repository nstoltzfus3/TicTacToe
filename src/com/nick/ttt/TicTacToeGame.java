package com.nick.ttt;

import javax.security.auth.callback.TextInputCallback;
import java.util.*;

public class TicTacToeGame {
    // TODO: List fields here.
    // Some gameboard representation.
    private char[] gameBoard;
    private final ArrayList<int[]> winConditions;
    private final HashMap<Character, Integer> charToInt;

    // TODO: Make constructor
    public TicTacToeGame() {
        this.gameBoard = new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        this.winConditions = new ArrayList<>();
        this.winConditions.add(new int[]{0, 1, 2});
        this.winConditions.add(new int[]{3, 4, 5});
        this.winConditions.add(new int[]{6, 7, 8});
        this.winConditions.add(new int[]{0, 3, 6});
        this.winConditions.add(new int[]{1, 4, 7});
        this.winConditions.add(new int[]{2, 5, 8});
        this.winConditions.add(new int[]{0, 4, 8});
        this.winConditions.add(new int[]{2, 4, 6});
        this.charToInt = new HashMap<>();
        charToInt.put('x', -1);
        charToInt.put('o', 1);
        charToInt.put(' ', 0);
    }

    // TODO: Generate Getters and Setters
    public char[] getGameBoard() {
        return this.gameBoard;
    }

    public ArrayList<int[]> getWinConditions() {
        return this.winConditions;
    }

    public HashMap<Character, Integer> getCharToInt() {
        return charToInt;
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
        if (this.findEmpties().contains(pos)) {
            this.getGameBoard()[pos] = xo;
        } else {
            System.out.println("Not a valid move. Pick another position.");
        }
    }

    public ArrayList<Integer> findEmpties() {
        ArrayList<Integer> empties = new ArrayList<>();
        char[] board = this.getGameBoard();
        for (int i = 0; i < board.length; i++) {
            if (board[i] == ' ') {
                empties.add(i);
            }
        }
        return empties;
    }

    public boolean gameWon() {
        ArrayList<int[]> wins = this.getWinConditions();
        char[] board = this.getGameBoard();
        HashMap<Character, Integer> map = this.getCharToInt();
        int sum = 0;

        for (int[] arr : wins) {
            for (int i : arr) {
                if (map.containsKey(board[i])) {
                    sum += map.get(board[i]);
                }
            }
            if (sum == 3 || sum == -3) {
                return true;
            } else {
                sum = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TicTacToeGame ttt = new TicTacToeGame();
    }
}
