package com.kodilla.trivia;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Tile extends Rectangle {

    private Color aquamarine = Color.AQUAMARINE;
    private Color blue = Color.LIGHTSTEELBLUE;
    private Color green = Color.BLANCHEDALMOND;
    private Color pink = Color.PINK;
    private Color purple = Color.MEDIUMPURPLE;
    private Color red = Color.RED;

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


}
