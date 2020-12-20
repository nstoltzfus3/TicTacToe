package com.nick.ttt;

import com.nick.ttt.Players.HumanPlayer;
import com.nick.ttt.Players.Player;

public class Main {
    public static void main(String[] args) {
        //for testing
        Player john = new HumanPlayer( 'X', false);
        Player AI = new HumanPlayer( 'O', true);
        System.out.println(john.getAI());
        System.out.println(john.getSymbol());
        System.out.println(AI.getAI());
        System.out.println(AI.getSymbol());

    }
}
