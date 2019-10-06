package com.kodilla.trivia;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class Tile extends Rectangle {

    Color aquamarine = Color.AQUAMARINE;
    Color blue = Color.LIGHTSTEELBLUE;
    Color green = Color.BLANCHEDALMOND;
    Color pink = Color.PINK;
    Color purple = Color.MEDIUMPURPLE;
    Color red = Color.RED;

    private List<Color> colors;

    public Tile() {

        setWidth(TriviaBoard.tileSize);
        setHeight(TriviaBoard.tileSize);

        setStroke(Color.BLACK);

    }


    public List<Color> color(){

        colors = new ArrayList<Color>();
        colors.add(aquamarine);
        colors.add(blue);
        colors.add(green);
        colors.add(pink);
        colors.add(purple);
        colors.add(red);

        return colors;

    }

    public List<Color> getColors() {
        return colors;
    }

}
