package com.kodilla.trivia;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Tile extends Rectangle {

    public static final int tileSize = 80;

    private Color aquamarine = Color.AQUAMARINE;
    private Color blue = Color.LIGHTSTEELBLUE;
    private Color green = Color.BLANCHEDALMOND;
    private Color pink = Color.PINK;
    private Color purple = Color.MEDIUMPURPLE;
    private Color red = Color.RED;

    private List<Color> colors;

    public Tile() {

        setWidth(tileSize);
        setHeight(tileSize);

        setStroke(Color.BLACK);

        //System.out.println(Color.AQUAMARINE.name());

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
