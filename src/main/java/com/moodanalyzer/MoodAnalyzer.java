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

    public String analyseMood(String message) throws MoodAnalysisException {
        this.message = message;
        return analyseMood();
    }

    public String analyseMood() throws MoodAnalysisException {
        try {

            if (message.contains("Happy"))
                return "SAD";
            else
                return "HAPPY";
        }
        catch (NullPointerException e)
        {
            throw new MoodAnalysisException("Please enter proper input");
        }

    }

}
