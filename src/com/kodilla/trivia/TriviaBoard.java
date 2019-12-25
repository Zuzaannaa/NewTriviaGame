package com.kodilla.trivia;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;


public class TriviaBoard extends Application {

    DiceRoll roll;
    Tile tile;
    QuizzQuestionsReader quiz;
    QuestionReader questionReader;
    Question question;

    public static Label diceRollResult = new Label();

    public static final int columns = 10;
    public static final int rows = 10;


    //players icons
    public Image personPlayer;
    public Image computerPlayer;


    public int playerPosition = 1;
    public int computerPosition = 1;

    public boolean personTurn = false;
    public boolean computerTurn = false;

    public static int personPlayerXPosition = 10;
    public static int personPlayerYPosition = 740;

    public static int computerPlayerXPosition = 40;
    public static int computerPlayerYPosition = 740;

    public int owl1Position = 1;
    public int owl2Position = 1;

    public boolean start = false;
    public boolean finish = false;



    private Group tileBoard = new Group();


    //creates the board of 100 tiles
    private Pane createBoard() {
        Pane board = new Pane();
        board.setPrefSize(200 + (rows * Tile.tileSize), columns * Tile.tileSize);
        board.getChildren().addAll(tileBoard);
        board.getChildren().add(diceRollResult);


        for (int i = 0; i < columns; i++) {
            for (int n = 0; n < rows; n++) {
                tile = new Tile();
                tile.setTranslateX(Tile.tileSize * n);
                tile.setTranslateY(Tile.tileSize * i);

                List<Color> tileColor = tile.color();
                Random random = new Random();
                tile.setFill(tileColor.get(random.nextInt(tileColor.size())));
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

                start = true;
                personTurn = true;
                computerTurn = false;

                per.setTranslateX(personPlayerXPosition);
                per.setTranslateY(personPlayerYPosition);

                com.setTranslateX(computerPlayerXPosition);
                com.setTranslateY(computerPlayerYPosition);

            }
        });



        Button personButton = new Button("Player");
        personButton.setTranslateX(860);
        personButton.setTranslateY(60);
        personButton.setOnAction(event -> {
            if(start) {
                if (personTurn) {
                    File file = new File("/Users/zuz/IdeaProjects/TriviaBoardGame/src/resources/MovieQ.csv");
                    String line = "";
                    String splitBy = "/";
                    String [] splitLine;

                    BufferedReader br = null;
                    try {
                        br = new BufferedReader(new FileReader(file));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    while (true){
                            try {
                                if ((line = br.readLine()) == null) break;
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            splitLine = line.split(splitBy);

                            List<String> choices = new ArrayList<>();
                            choices.add(splitLine[1]);
                            choices.add(splitLine[2]);

                            ChoiceDialog<String> dialog = new ChoiceDialog<>(choices.get(0), choices);
                            dialog.setHeaderText("Answer The Question!");
                            dialog.setContentText(splitLine[0]);

                            Optional<String> q = dialog.showAndWait();
                            q.ifPresent(answer -> System.out.println("Your choice: " + answer));

                            Optional<String> correctAnswer = Optional.of("Pocahontas");

                        if (q.equals(correctAnswer)) {
                            roll = new DiceRoll();
                            roll.roll();
                            int result = roll.getDie();
                            diceRollResult = new Label();
                            diceRollResult.setTranslateX(890);
                            diceRollResult.setTranslateY(300);
                            diceRollResult.setText(String.valueOf(result));
                            board.requestLayout();
                            movePlayer();
                            setPlayerPosition1(personPlayerXPosition, personPlayerYPosition, per);
                            System.out.println("correct");
                            personTurn = false;
                            computerTurn = true;
                        } else {
                            personTurn = false;
                            computerTurn = true;
                            start = true;
                            System.out.println("Wrong answer");
                        }



                    }

                   // roll = new DiceRoll();
                    //roll.roll();
                    //int result = roll.getDie();
                    //diceRollResult = new Label();
                    //diceRollResult.setTranslateX(890);
                    //diceRollResult.setTranslateY(300);
                    //diceRollResult.setText(String.valueOf(result));
                    //board.requestLayout();


                  // board.getChildren().add(diceRollResult);

                    //movePlayer();
                    //setPlayerPosition1(personPlayerXPosition, personPlayerYPosition, per);
                    //personTurn = false;
                    //computerTurn = true;
                    //start = true;

                }
            }
        });




        Button computerButton = new Button("Computer");
        computerButton.setTranslateX(860);
        computerButton.setTranslateY(110);
        computerButton.setOnAction(event -> {
            if(start){
                if(computerTurn){
                    //roll = new DiceRoll();
                    //roll.roll();
                    //int result = roll.getDie();
                    //diceRollResult = new Label();
                    //diceRollResult.setTranslateX(890);
                    //diceRollResult.setTranslateY(300);
                    //diceRollResult.setText(String.valueOf(result));
                    //board.requestLayout();

                    List<String> choices = new ArrayList<>();
                    choices.add("Pocahontas");
                    choices.add("Merida");
                    choices.add("Bella");

                    ChoiceDialog<String> dialog = new ChoiceDialog<>("Merida", choices);
                    dialog.setHeaderText("Answer The Question!");
                    dialog.setContentText("Which Dinsey princess has a racoon as a sidekick?");

                    Optional<String> q = dialog.showAndWait();
                    q.ifPresent(answer -> System.out.println("Your choice: " + answer));

                    Optional<String> correctAnswer = Optional.of("Pocahontas");

                        if (q.equals(correctAnswer)) {
                            roll = new DiceRoll();
                            roll.roll();
                            int result = roll.getDie();
                            diceRollResult = new Label();
                            diceRollResult.setTranslateX(890);
                            diceRollResult.setTranslateY(300);
                            diceRollResult.setText(String.valueOf(result));
                            board.requestLayout();
                            moveComputer();
                            setPlayerPosition1(computerPlayerXPosition, computerPlayerYPosition, com);
                            System.out.println("correct");
                            computerTurn = false;
                            personTurn = true;
                        } else {
                            computerTurn = false;
                            personTurn = true;
                            start = true;
                            System.out.println("Wrong answer");
                        }

                    }



                    //moveComputer();
                    //setPlayerPosition1(computerPlayerXPosition, computerPlayerYPosition, com);

                    //questionReader = new QuestionReader();
                    //question = new Question(questionReader.questionArr[0], questionReader.questionArr[1], questionReader.questionArr[2], 2);
                    //String q = question.getQuestion();
                    //System.out.println(q);

                    //personTurn = true;
                    //computerTurn = false;
                    //start = true;

                    //tileBoard.getChildren().add(diceRollResult);

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
            if(personPlayerXPosition > 740){
                personPlayerYPosition -= 80;
                personPlayerXPosition -=80;
                owl1Position ++;
            }
            if(personPlayerXPosition < 80){
                personPlayerYPosition -= 80;
                personPlayerXPosition += 80;
                owl1Position ++;
            }
            if(personPlayerXPosition < 20 || personPlayerYPosition < 20){
                personPlayerXPosition = 20;
                personPlayerYPosition = 20;
                start = false;
            }
        }
    }

    private void moveComputer(){
        for(int i = 0; i < roll.getDie(); i ++){
            if(owl2Position % 2 == 1){
                computerPlayerXPosition += 80;
            }
            if(owl2Position % 2 == 0){
                computerPlayerXPosition -= 80;
            }
            if(computerPlayerXPosition > 740){
                computerPlayerYPosition -= 80;
                computerPlayerXPosition -=80;
                owl2Position ++;
            }
            if(computerPlayerXPosition < 80){
                computerPlayerYPosition -= 80;
                computerPlayerXPosition += 80;
                owl2Position ++;
            }
            if(computerPlayerXPosition < 20 || computerPlayerYPosition < 20){
                computerPlayerXPosition = 20;
                computerPlayerYPosition = 20;
                start = false;
            }
        }

    }

    private void setPlayerPosition1(int x, int y, ImageView player){
        TranslateTransition animate = new TranslateTransition(Duration.millis(1000));
        animate.setNode(player);
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
