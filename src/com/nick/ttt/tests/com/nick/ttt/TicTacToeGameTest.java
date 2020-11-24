package com.nick.ttt;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeGameTest {
    TicTacToeGame game = new TicTacToeGame();
    //TODO make every gameboard
    //TODO for real, make a plan. maybe don't make every gameboard. 

//    ArrayList<TicTacToeGame> makeAllBoards(){
//    ArrayList<TicTacToeGame> allLegalBoards = new ArrayList<TicTacToeGame>(205); //i know there are less than 205 game boards
//        for (int i = 0; i < allLegalBoards.size(); i++) {
//            //make all the 5 X wins
//            for(int j=0; j < allLegalBoards.get(i).getGameBoard().length; j++){
//
//            }
//
//            //make all the 7 X wins
//
//            //make all the 9 x wins
//
//            //make all the ties
//
//            //make all the 6 O wins
//
//            //make all the 8 O wins
//        }
//        return allLegalBoards;
//    }


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
    //findEmpties returns an ArrayList with ints of the LOCATION of empty locations aka '0'
    //However, findEmpties is not ordered.
    @Test
    //'0' means empty
    //TODO - look into how to compare arrays in test methods.
    //TODO - Setup test game states to pass as inputs.
    void findEmpties() {
        char empty = '0'; //redefine this when empty character becomes null ''
        int numBoards = 9; //use numBoards so there's fewer locations to udpate and to make the loops more readable.
        ArrayList<TicTacToeGame> testXBoards = new ArrayList<TicTacToeGame>(numBoards);
        ArrayList<TicTacToeGame> testOBoards = new ArrayList<TicTacToeGame>(numBoards);
        //puts TicTacToeGame inside ArrayList. without this the space is reserved, but not initialized
        for(int i=0; i < numBoards; i++){
            testXBoards.add(new TicTacToeGame());
            testOBoards.add(new TicTacToeGame());
        }


   //     TicTacToeGame emptyBoard = new TicTacToeGame();
        //sets up the boards to test
        //compares to X and O boards in case one board is changed from the other
        for(int i=0; i< numBoards; i++){
            //game board length should always be 9. if it gets an out of bounds error that shows an issue, possibly with the constructor
            for(int j=i; j < 9;j++ ){
                testXBoards.get(i).placePiece('X', j);
                testOBoards.get(i).placePiece('O',j);
            }
        }

        //tests each board
        //the first board is all 'X' or all 'O' so should be empty arraylist
        //the second board should be the first element is NOT
        //the last board should be all X or all O so everything should have a value
        for(int i=0; i < numBoards; i++){
            ArrayList<Integer> emptyX = testXBoards.get(i).findEmpties();
            ArrayList<Integer> emptyO = testOBoards.get(i).findEmpties();
//            emptyX.sort();
//            emptyO.sort();
            //doing it in separate loops in case there is a situation where they have different sizes
            for(int j=i+1; j < emptyX.size(); j++){
                //compare emptyX to to testXboard
                //the ORDER the arraylist are NOT the same, but they should have the same values but in different places
                //see if every location in emptyX is found in testXBoard
                //Xtest
              //  System.out.println("current Xboard " + testXBoards.get(i).getGameBoard().toString() + " current emptyX " + emptyX.toString());
                assertTrue(emptyX.contains(testXBoards.get(i).getGameBoard()[j]));
                //Otest
                assertTrue(emptyO.contains(testOBoards.get(i).getGameBoard()[j]));
            }

        }

    }
}