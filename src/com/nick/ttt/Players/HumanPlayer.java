package com.nick.ttt.Players;

import com.nick.ttt.TicTacToeBoard;

import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner sc;


    public HumanPlayer(char symbol, boolean isAI) {
        super(symbol, isAI);
        sc = new Scanner(System.in);
    }

    public void makeMove(TicTacToeBoard board) {

        Integer moveLocation = Integer.parseInt(sc.next());
        if (!board.placePiece(this.getSymbol(), moveLocation)) {
            System.out.println("Not a valid location, " + this.getName() + ", pick another. ");
            makeMove(board);
        }
    }
}
