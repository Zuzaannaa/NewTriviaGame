package com.kodilla.trivia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class QuestionReader {
    private String movieQ = "MovieQ.csv";
    BufferedReader br = null;
    String line = "";
    String csvSplitBy = "/";
    private String [] question;

    public String readQuestion() {
        try {
            br = new BufferedReader(new FileReader(movieQ));
            while ((line = br.readLine()) != null) {
                question = line.split(csvSplitBy);
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
        return question[0] + question[1] + question[2];

    }

    public QuestionReader(String movieQ, BufferedReader br, String line, String csvSplitBy, String[] question) {
        this.movieQ = movieQ;
        this.br = br;
        this.line = line;
        this.csvSplitBy = csvSplitBy;
        this.question = question;
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

    public String[] getQuestion() {
        return question;
    }
}
