package com.example.arunalu;

import java.sql.Time;

public class ProgressInfo {
    int NoCorrectWords;
    int NoIncorrectWords;
    String CorrectWords;
    String IncorrectWords;
    String PronouncedWords;
    String AverageTime;
    String PercentageOfSuccess;

    public ProgressInfo() {
    }

    public ProgressInfo(int noCorrectWords, int noIncorrectWords, String correctWords, String incorrectWords, String pronouncedWords, String averageTime, String percentageOfSuccess) {
        NoCorrectWords = noCorrectWords;
        NoIncorrectWords = noIncorrectWords;
        CorrectWords = correctWords;
        IncorrectWords = incorrectWords;
        PronouncedWords = pronouncedWords;
        AverageTime = averageTime;
        PercentageOfSuccess = percentageOfSuccess;
    }

    public int getNoCorrectWords() {
        return NoCorrectWords;
    }

    public void setNoCorrectWords(int noCorrectWords) {
        NoCorrectWords = noCorrectWords;
    }

    public int getNoIncorrectWords() {
        return NoIncorrectWords;
    }

    public void setNoIncorrectWords(int noIncorrectWords) {
        NoIncorrectWords = noIncorrectWords;
    }

    public String getCorrectWords() {
        return CorrectWords;
    }

    public void setCorrectWords(String correctWords) {
        CorrectWords = correctWords;
    }

    public String getIncorrectWords() {
        return IncorrectWords;
    }

    public void setIncorrectWords(String incorrectWords) {
        IncorrectWords = incorrectWords;
    }

    public String getPronouncedWords() {
        return PronouncedWords;
    }

    public void setPronouncedWords(String pronouncedWords) {
        PronouncedWords = pronouncedWords;
    }

    public String getAverageTime() {
        return AverageTime;
    }

    public void setAverageTime(String averageTime) {
        AverageTime = averageTime;
    }

    public String getPercentageOfSuccess() {
        return PercentageOfSuccess;
    }

    public void setPercentageOfSuccess(String percentageOfSuccess) {
        PercentageOfSuccess = percentageOfSuccess;
    }

    @Override
    public String toString() {
        return "ProgressInfo{" +
                "NoCorrectWords=" + NoCorrectWords +
                ", NoIncorrectWords=" + NoIncorrectWords +
                ", CorrectWords='" + CorrectWords + '\'' +
                ", IncorrectWords='" + IncorrectWords + '\'' +
                ", PronouncedWords='" + PronouncedWords + '\'' +
                ", AverageTime='" + AverageTime + '\'' +
                ", PercentageOfSuccess='" + PercentageOfSuccess + '\'' +
                '}';
    }
}
