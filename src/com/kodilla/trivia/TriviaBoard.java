package com.kodilla.trivia;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class TriviaBoard extends Application {

    public static final int tileSize = 80;
    public static final int columns = 10;
    public static final int rows = 10;

    //players icons
    public Image personPlayer;
    public Image computerPlayer;

    public int playerPosition1 = 1;
    public int playerPosition2 = 1;

    public boolean personTurn;
    public boolean computerTurn;

    public static int personPlayerXPosition = 10;
    public static int personPlayerYPosition = 740;

    public static int computerPlayerXPosition = 40;
    public static int computerPlayerYPosition = 740;

    public boolean start = false;
    public boolean finish;


    private Group tileBoard = new Group();

    //creates the board of 100 tiles
    private Pane createBoard(){
        Pane board = new Pane();
        board.setPrefSize(200 + (rows * tileSize), columns * tileSize);
        board.getChildren().addAll(tileBoard);

        Color red = Color.RED;
        Color blue = Color.BLUE;
        Color green = Color.GREEN;
        Color pink = Color.PINK;
        List<Color> colors = new ArrayList();
        colors.add(red);
        colors.add(blue);
        colors.add(green);
        colors.add(pink);

        for(int i = 0; i < columns; i ++ ){
            for(int n = 0; n < rows; n ++){
                Tile tile = new Tile();
                tile.setTranslateX(n * tileSize);
                tile.setTranslateY((i * tileSize));
                if((n + i) % 2 == 0){
                    tile.setFill(red);
                }else{
                    tile.setFill(pink);
                }
                tileBoard.getChildren().add(tile);

            }
        }



        //adding person player figure to the board
        personPlayer = new Image("file:src/resources/owl1.png");
        ImageView per = new ImageView(personPlayer);
        per.setFitWidth(30);
        per.setFitHeight(40);
        per.setTranslateX(personPlayerXPosition);
        per.setTranslateY(personPlayerYPosition);

        //adding computer player figure to the board

        computerPlayer = new Image("file:src/resources/owl2.png");
        ImageView com = new ImageView(computerPlayer);
        com.setFitWidth(30);
        com.setFitHeight(40);
        com.setTranslateX(computerPlayerXPosition);
        com.setTranslateY(computerPlayerYPosition);

        Button startTheGame = new Button("Start the game");
        startTheGame.setTranslateX(860);
        startTheGame.setTranslateY(10);
        startTheGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                startTheGame.setText("Trivia On");
                personPlayerXPosition = 10;
                personPlayerYPosition =740;

                computerPlayerXPosition = 40;
                computerPlayerYPosition = 740;

                per.setTranslateX(personPlayerXPosition);
                per.setTranslateY(personPlayerYPosition);

                com.setTranslateX(computerPlayerXPosition);
                com.setTranslateY(computerPlayerYPosition);

            }
        });

        Label diceResult = new Label("0");
        diceResult.setTranslateX(890);
        diceResult.setTranslateY(300);
        board.getChildren().add(diceResult);


        Button personButton = new Button("Player");
        personButton.setTranslateX(860);
        personButton.setTranslateY(60);
        personButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(start) {
                    if (personTurn) {
                        DiceRoll roll = new DiceRoll();
                        roll.roll();
                        int result = roll.getDie();


                    }
                }

            }
        });

        

        Button computerButton = new Button("Computer");
        computerButton.setTranslateX(860);
        computerButton.setTranslateY(110);
        computerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(start){
                    if(computerTurn){

                    }
                }
            }
        });

        tileBoard.getChildren().addAll(per, com, startTheGame, personButton, computerButton);



        return board;
    }




    public static void main(String[] args){
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        Scene scene = new Scene(createBoard());
        primaryStage.setTitle("Trivia");
        primaryStage.setScene(scene);
        primaryStage.show();



    }
}