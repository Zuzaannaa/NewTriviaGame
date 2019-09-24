package com.kodilla.trivia;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {



    public Tile() {


        setWidth(TriviaBoard.tileSize);
        setHeight(TriviaBoard.tileSize);

        setStroke(Color.BLACK);
    }
}
