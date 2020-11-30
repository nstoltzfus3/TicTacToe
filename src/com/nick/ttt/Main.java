package com.nick.ttt;

public class Main {
    public static void main(String[] args) {
        //for testing
        Player john = new Player( 'X', false);
        Player AI = new Player( 'O', true);
        System.out.println(john.getAI());
        System.out.println(john.getSymbol());
        System.out.println(AI.getAI());
        System.out.println(AI.getSymbol());

    }
}
