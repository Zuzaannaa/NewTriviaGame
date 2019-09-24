package com.kodilla.trivia;

public class DiceRoll {

    public int die = 6;

    public void roll(){
        die = (int)(Math.random() * 6) + 1;
        System.out.println(die);
    }


    public int getDie() {
        return die;
    }

    @Override
    public String toString() {
        return "DiceRoll{" +
                "die=" + die +
                '}';
    }
}
