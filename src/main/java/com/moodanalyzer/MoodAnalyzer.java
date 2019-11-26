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
        try {

            if (message.contains("Happy"))
                return "SAD";
            else
                return "HAPPY";
        }
        catch (NullPointerException e)
        {
            return "Please enter proper input";
        }

    }

}
