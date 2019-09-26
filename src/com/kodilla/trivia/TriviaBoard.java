package com.kodilla.trivia;

import javafx.animation.TranslateTransition;
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
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;


public class TriviaBoard extends Application {

    DiceRoll roll;

    public static Label diceRollResult;

    public static final int tileSize = 80;
    public static final int columns = 10;
    public static final int rows = 10;


    //players icons
    public Image personPlayer;
    public Image computerPlayer;


    public int playerPosition1 = 1;
    public int playerPosition2 = 1;

    public boolean personTurn = true;
    public boolean computerTurn = true;

    public static int personPlayerXPosition = 10;
    public static int personPlayerYPosition = 740;

    public static int computerPlayerXPosition = 40;
    public static int computerPlayerYPosition = 740;

    public int owl1Position;
    public int owl2Position;

    public boolean start = true;
    public boolean finish = false;



    private Group tileBoard = new Group();


    //creates the board of 100 tiles
    private Pane createBoard(){
        Pane board = new Pane();
        board.setPrefSize(200 + (rows * tileSize), columns * tileSize);
        board.getChildren().addAll(tileBoard);

        Color aquamarine = Color.AQUAMARINE;
        Color blue = Color.BLUE;
        Color green = Color.GREEN;
        Color pink = Color.PINK;
        List<Color> colors = new ArrayList();
        colors.add(aquamarine);
        colors.add(blue);
        colors.add(green);
        colors.add(pink);

        for(int i = 0; i < columns; i ++ ){
            for(int n = 0; n < rows; n ++){
                Tile tile = new Tile();
                tile.setTranslateX(n * tileSize);
                tile.setTranslateY((i * tileSize));
                if((n + i) % 2 == 0){
                    tile.setFill(aquamarine);
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



        Button personButton = new Button("Player");
        personButton.setTranslateX(860);
        personButton.setTranslateY(60);
        personButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(start) {
                    if (personTurn) {
                        roll = new DiceRoll();
                        roll.roll();
                        int result = roll.getDie();
                        diceRollResult = new Label();
                        diceRollResult.setTranslateX(890);
                        diceRollResult.setTranslateY(300);
                        diceRollResult.setText(String.valueOf(result));

                        board.getChildren().add(diceRollResult);

                        movePlayer();
                        setPlayerPosition1(personPlayerXPosition, personPlayerYPosition, personPlayer);
                        personTurn = true;
                        start = true;



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
                        roll = new DiceRoll();
                        roll.roll();
                        int result = roll.getDie();
                        diceRollResult = new Label();
                        diceRollResult.setTranslateX(890);
                        diceRollResult.setTranslateY(300);
                        diceRollResult.setText(String.valueOf(result));

                        board.getChildren().add(diceRollResult);

                    }
                }
            }
        });

        tileBoard.getChildren().addAll(per, com, startTheGame, personButton, computerButton);




        return board;
    }

    private void movePlayer(){
        for(int i = 0; i < roll.getDie(); i ++){
            if(owl1Position % 2 == 1){
                personPlayerXPosition += 80;
            }
            if(owl1Position % 2 == 0){
                personPlayerXPosition -= 80;
            }
            if(personPlayerXPosition > 760){
                personPlayerYPosition -= 80;
                personPlayerXPosition -=80;
                owl1Position ++;
            }
            if(personPlayerXPosition < 40){
                personPlayerYPosition -= 80;
                personPlayerXPosition += 80;
                owl1Position ++;
            }
            if(personPlayerXPosition < 40 || personPlayerYPosition < 40){
                personPlayerXPosition = 40;
                personPlayerYPosition = 40;
            }
        }
    }

    private void setPlayerPosition1(int x, int y, Image player){
        TranslateTransition animate = new TranslateTransition(Duration.millis(1000));
        animate.setToX(x);
        animate.setToY(y);
        animate.setAutoReverse(false);
        animate.play();
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
