package com.kodilla.trivia;

import javafx.scene.control.ChoiceDialog;

import java.util.ArrayList;
import java.util.List;

public class Question {
    QuestionReader questionReader;
    private List<String[]> questions;

    public String read(){
        String [] reader = questionReader.getQuestion();
        return reader[0];
    }

    public List<String[]> choices(){
        questions = new ArrayList<String[]>();
        questions.add(questionReader.getQuestion());
        return questions;

    }


    ChoiceDialog<String> ch = new ChoiceDialog<>();
}
