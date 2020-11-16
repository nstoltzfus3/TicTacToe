package com.nick.ttt;

public class Main {
    public static void main(String[] args) {
        //for testing
        Player john = new Player("John", 'X', false);
        Player AI = new Player("Crazy Good", 'O', true);
        System.out.println(john.getName());
        System.out.println(john.getAI());
        System.out.println(john.getSymbol());
        System.out.println(AI.getName());
        System.out.println(AI.getAI());
        System.out.println(AI.getSymbol());

        Player badSymbol = new Player("error?", 'w', true);
        System.out.println(badSymbol.getName());
    }
}
