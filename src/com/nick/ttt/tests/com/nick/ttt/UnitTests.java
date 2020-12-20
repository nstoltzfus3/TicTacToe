package com.nick.ttt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

class UnitTests {
    /**
     * Tests placing a single piece on an empty board.
     */

    @Test
    void placePiece() {
        TicTacToeGame game = new TicTacToeGame();
        for(int i = 0; i < game.getGameBoard().getBoard().length; i++){
            game.getGameBoard().placePiece('X', i);
            Assertions.assertEquals('X', game.index(i));
        }

        //test 'O'
        TicTacToeGame game1 = new TicTacToeGame();
        for(int i = 0; i < game1.getGameBoard().getBoard().length; i++){
            game1.getGameBoard().placePiece('O', i);
            Assertions.assertEquals('O', game1.index(i));
        }
    }

    /**
     * Tests the find all empties sub functions.
     */
    @Test
    void findEmptyNumber() {
        TicTacToeBoard emptyBoard = new TicTacToeBoard();
        Assertions.assertTrue(validateEmptyNumber(emptyBoard, 9));

        TicTacToeBoard allXBoard = new TicTacToeBoard(new char[]{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'});
        Assertions.assertTrue(validateEmptyNumber(allXBoard, 0));

        TicTacToeBoard allOBoard = new TicTacToeBoard(new char[]{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'});
        Assertions.assertTrue(validateEmptyNumber(allOBoard, 0));

        TicTacToeBoard someEmpties = new TicTacToeBoard(new char[]{' ', ' ', ' ', 'X', 'O', ' ', ' ', 'X','O'});
        Assertions.assertTrue(validateEmptyNumber(someEmpties, 5));
    }

    //a helper method for findEmpties()
    boolean validateEmptyNumber(TicTacToeBoard board, int n){
        //empty character is declared in case it is refactored.
        //originally I put the value in the loop but interestingly '0'==0 even if they are both chars
        //while 0==(char) 0 returns true.
        //since an empty game board is initialized as charArray of 0 not a charArray of '0' this matters

        char[] boardChars = board.getBoard();
        ArrayList<Integer> emptyLocations = board.findEmpties();
        int totalEmpties = 0;
        for (int i = 0; i < emptyLocations.size(); i++) {
            //take each empty location and see if it is actually empty in the board.
            int loc = emptyLocations.get(i);
            if (boardChars[loc] == ' ') {
                totalEmpties++;
            }
        }
        return totalEmpties == n;
    }

    @Test
    void gameWon() {
        TicTacToeBoard xWinInARow = new TicTacToeBoard();
        xWinInARow.placePiece('X', 0);
        xWinInARow.placePiece('O', 4);
        xWinInARow.placePiece('X', 2);
        xWinInARow.placePiece('O', 5);
        xWinInARow.placePiece('X', 1);
        Assertions.assertTrue(xWinInARow.gameWon());

        TicTacToeBoard xWinInAColumn = new TicTacToeBoard();
        xWinInAColumn.placePiece('X', 0);
        xWinInAColumn.placePiece('O', 1);
        xWinInAColumn.placePiece('X', 8);
        xWinInAColumn.placePiece('O', 5);
        xWinInAColumn.placePiece('X', 6);
        xWinInAColumn.placePiece('O', 7);
        xWinInAColumn.placePiece('X', 3);
        Assertions.assertTrue(xWinInAColumn.gameWon());

        TicTacToeBoard oWinOnADiagonal = new TicTacToeBoard();
        oWinOnADiagonal.placePiece('X', 1);
        oWinOnADiagonal.placePiece('O', 0);
        oWinOnADiagonal.placePiece('X', 3);
        oWinOnADiagonal.placePiece('O', 4);
        oWinOnADiagonal.placePiece('X', 6);
        oWinOnADiagonal.placePiece('O', 8);
        Assertions.assertTrue(oWinOnADiagonal.gameWon());
    }
}
