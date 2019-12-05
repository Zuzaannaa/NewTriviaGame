package com.kodilla.trivia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuestionReader {
    public String movieQ = "/Users/zuz/IdeaProjects/TriviaBoardGame/src/resources/MovieQ.csv";
    BufferedReader br = null;
    String line = "";
    String csvSplitBy = "/";
    public String [] questionArr;
    public List<String> questions = new ArrayList<>();
    public List<String> choices = new ArrayList<>();

    public void readQuestions() {
        try {
            br = new BufferedReader(new FileReader(movieQ));
            while ((line = br.readLine()) != null) {
                questionArr = line.split(csvSplitBy);
                //Question question = new Question(questionArr[0], questionArr[1], questionArr[2], Integer.parseInt(questionArr[3]));
                questions.add(questionArr[0]);
                choices.add(questionArr[1]);
                choices.add(questionArr[2]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public QuestionReader(String movieQ, BufferedReader br, String line, String csvSplitBy, String[] question) {
        this.movieQ = movieQ;
        this.br = br;
        this.line = line;
        this.csvSplitBy = csvSplitBy;
        this.questionArr = question;
    }

    public String getMovieQ() {
        return movieQ;
    }

    public BufferedReader getBr() {
        return br;
    }

    public String getLine() {
        return line;
    }

    public String getCsvSplitBy() {
        return csvSplitBy;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public List<String> getChoices() {
        return choices;
    }

    public String[] getQuestionArr() {
        return questionArr;
    }
}
