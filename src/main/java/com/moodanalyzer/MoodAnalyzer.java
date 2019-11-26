package com.moodanalyzer;

public class MoodAnalyzer {

    public String analyseMood(String input)
    {
        if (input.contains("Sad"))
            return "SAD";
        else
            return "HAPPY";
    }

}
