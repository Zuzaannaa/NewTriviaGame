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
    List<String> choices = new ArrayList<>();
    ChoiceDialog<String> dialog = new ChoiceDialog<>(choices.get(0), choices);
    Optional<String> q = dialog.showAndWait();

    public void readFile() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(file));
        while ((line = br.readLine()) != null){
            splitLine = line.split(splitBy);

            choices.add(splitLine[1]);
            choices.add(splitLine[2]);

            //ChoiceDialog<String> dialog = new ChoiceDialog<>(choices.get(0), choices);
            dialog.setHeaderText("Answer The Question!");
            dialog.setContentText(splitLine[0]);

            //Optional<String> q = dialog.showAndWait();
            q.ifPresent(answer -> System.out.println("Your choice: " + answer));

            Optional<String> correctAnswer = Optional.of("Pocahontas");

        }
    }

    public QuizzQuestionsReader(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public String getLine() {
        return line;
    }

    public String getSplitBy() {
        return splitBy;
    }

    public String[] getSplitLine() {
        return splitLine;
    }

    public List<String> getChoices() {
        return choices;
    }

    public ChoiceDialog<String> getDialog() {
        return dialog;
    }

    public Optional<String> getQ() {
        return q;
    }
}
