package com.nick.ttt;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UnitTests {
    TicTacToeGame game = new TicTacToeGame();
    
    //passes IFF
    //The board gets updated with the new piece
    @Test
    void placePiece() {
        //test 'X'
        for(int i=0; i<game.getGameBoard().length; i++){
            game.placePiece('X', i);
            assertEquals('X', game.index(i));
        }

        //test 'O'
        for(int i=0; i<game.getGameBoard().length; i++){
            game.placePiece('O', i);
            assertEquals('O', game.index(i));
        }
    }

    //passes IFF
    //1 finds every empty
    //2 Does not detect squares as empty if they have content
    //findEmpties returns an ArrayList<Integer> with LOCATION of empty squares
    @Test
    void findEmpties() {
        TicTacToeGame emptyBoard = new TicTacToeGame();

        //declaring using a char array constructor because if I make the boards using placePiece that relies on placePiece working
        TicTacToeGame allXBoard = new TicTacToeGame(new char[]{'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'});
        TicTacToeGame allOBoard = new TicTacToeGame(new char[]{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'});
        TicTacToeGame someEmpties = new TicTacToeGame(new char[]{0, 0, 0, 'X', 'O', 0, 0, 'X','O'});

        assertTrue(validateEmpties(allXBoard));
        assertTrue(validateEmpties(allOBoard));
        assertTrue(validateEmpties(emptyBoard));
        assertTrue(validateEmpties(someEmpties));

    }

    //a helper method for findEmpties()
    boolean validateEmpties(TicTacToeGame board){
        //empty character is declared in case it is refactored.
        //originally I put the value in the loop but interestingly '0'==0 returns false
        //while '0'==(char) 0 returns true.
        //since an empty game board is initialized as charArray of 0 not a charArray of '0' this matters
        char empty = 0;
        char[] boardChars = board.getGameBoard();
        ArrayList<Integer> emptyLocations = board.findEmpties();
        for(int i=0; i < emptyLocations.size();i++){
            //take each empty location and see if it is actually empty in the board.
            int loc = emptyLocations.get(i);
            if(boardChars[loc]!=empty){
                return false;
            }
        }
        return true;

    }
}