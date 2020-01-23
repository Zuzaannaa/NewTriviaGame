package com.kodilla.trivia;

import javafx.scene.image.Image;

public class Figures {
    private TriviaBoard triviaBoard;
    private DiceRoll roll;
    private Image playerFigure;
    private Image computerFigure;

    public boolean personTurn = false;
    public boolean computerTurn = false;

    public Figures(Image playerFigure, Image computerFigure) {
        this.playerFigure = playerFigure;
        this.computerFigure = computerFigure;
    }


    public Image getPlayerFigure() {
        return playerFigure;
    }

    public Image getComputerFigure() {
        return computerFigure;
    }

    public boolean playerTurn(){
        return false;
    }

    public void move(){
        for(int i = 0; i < roll.getDie(); i ++){
            if(triviaBoard.owl1Position % 2 == 1){
                TriviaBoard.personPlayerXPosition += 80;
            }
            if(triviaBoard.owl1Position % 2 == 0){
                TriviaBoard.personPlayerXPosition -= 80;
            }
            if(TriviaBoard.personPlayerXPosition > 740){
                TriviaBoard.personPlayerYPosition -= 80;
                TriviaBoard.personPlayerXPosition -=80;
                triviaBoard.owl1Position ++;
            }
            if(TriviaBoard.personPlayerXPosition < 80){
                TriviaBoard.personPlayerYPosition -= 80;
                TriviaBoard.personPlayerXPosition += 80;
                triviaBoard.owl1Position ++;
            }
            if(TriviaBoard.personPlayerXPosition < 20 || TriviaBoard.personPlayerYPosition < 20){
                TriviaBoard.personPlayerXPosition = 20;
                TriviaBoard.personPlayerYPosition = 20;
                triviaBoard.start = false;
            }
        }

    }
}
