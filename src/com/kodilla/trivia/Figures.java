package com.kodilla.trivia;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Figures {
    private Image playerFigure;
    private Image computerFigure;

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
        return true;
    }

    public void move(boolean playerTurn){

    }
}
