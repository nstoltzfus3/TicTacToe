package com.nick.ttt.Players;

import com.nick.ttt.TicTacToeBoard;

import java.util.ArrayList;
import java.util.Random;

public class RandomAIPlayer extends Player {
    public RandomAIPlayer(char symbol, boolean isAI) {
        super(symbol, isAI);
    }

    public void makeMove(TicTacToeBoard board) {
        ArrayList<Integer> empties = board.findEmpties(); // 3,5,6,7,8
        Random random = new Random();
        int move = random.nextInt(empties.size()); // 0-4
        board.placePiece(this.getSymbol(), empties.get(move));
    }
}
