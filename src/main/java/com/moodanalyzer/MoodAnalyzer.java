package com.moodanalyzer;

public class MoodAnalyzer {

    String message;

    public String MoodAnalyzer(String message) {
        this.message = message;
        return analyseMood();
    }

    public String MoodAnalyzer() {

        return analyseMood();

    }

    public String analyseMood()
    {
        if (message.contains("Sad"))
            return "SAD";
        else
            return "HAPPY";
    }

}
