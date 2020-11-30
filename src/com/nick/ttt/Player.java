package com.nick.ttt;

// maybe we'll extend this later and make an AIPlayerClass and a HumanPlayerClass
public class Player {

    private String name;
    private boolean isAI;
    private char symbol; // 'X' or 'O'

    // constructor
    public Player(char symbol, boolean isAI){

        // if symbol is not 'X' or 'O' throw an error
        if(symbol=='X' || symbol=='O'){
            this.symbol=symbol;
        } else{
            throw new RuntimeException("Symbol must be 'X' or 'O'");
        }
        this.isAI = isAI;
    }
    // getters
    public String getName() { return name; }
    public char getSymbol(){
        return symbol;
    }
    public boolean getAI(){
        return isAI;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }
}
