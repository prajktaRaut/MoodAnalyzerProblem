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

        if (message == null) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_NULL);
        }
        else if (message.isEmpty())
        {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTERED_EMPTY);
        }

        return null;
    }


}
