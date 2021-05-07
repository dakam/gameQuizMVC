package com.dakam.quiz.gameQuiz.logic;

import java.util.HashMap;
import java.util.LinkedList;

public class Thequiz {

    private int answered;
    private int marks;
    private HashMap<String, Integer> quizMap = new HashMap<String, Integer>();
    private LinkedList<String> doneQuiz;

    public Thequiz() {

        quizMap.put("3, 1, 4, 1, 5", 9);
        quizMap.put("1, 1, 2, 3, 5", 8);
        quizMap.put("1, 4, 9, 16, 25", 36);
        quizMap.put("2, 3, 5, 7, 11", 13);
        quizMap.put("1, 2, 4, 8, 16" , 32);

        doneQuiz = new LinkedList<String>();



    }

    public  HashMap<String, Integer> getQuizMap() {
        return quizMap;
    }

    public void addMarks(int mark) {
        this.marks = this.marks+mark;
    }

    public int getMarks() {
        return marks;
    }

    public int getAnswered() {
        return answered;
    }

    public void addAnswered() {
        this.answered = answered+1;
    }

    public LinkedList<String> getDoneQuiz() {
        return doneQuiz;
    }
    public void RecorddoneQuiz(String qn) {
        doneQuiz.add(qn);
    }
}
