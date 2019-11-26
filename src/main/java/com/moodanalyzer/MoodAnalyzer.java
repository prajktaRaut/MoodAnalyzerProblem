package com.moodanalyzer;

public class MoodAnalyzer
{
    String message;

    public MoodAnalyzer(String message)
    {
        this.message = message;
    }

    public MoodAnalyzer()
    {
    }

    public String analyseMood(String message)
    {
        this.message = message;
        return analyseMood();
    }

    public String analyseMood()
    {
        if (message.contains("Happy"))
            return "HAPPY";
        else
            return "SAD";
    }

}
