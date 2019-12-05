package com.kodilla.trivia;

import javafx.scene.control.ChoiceDialog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QuizzQuestionsReader {
    File file = new File("/Users/zuz/IdeaProjects/TriviaBoardGame/src/resources/MovieQ.csv");
    String line = "";
    String splitBy = "/";
    String [] splitLine;

    public void readFile() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(file));
        while ((line = br.readLine()) != null){
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

        }
    }
}
