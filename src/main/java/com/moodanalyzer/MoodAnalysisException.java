package com.moodanalyzer;

public class MoodAnalysisException extends Exception {

    enum ExceptionType
    {
        ENTERED_Null, ENTERED_EMPTY

    }

    ExceptionType type;

    public MoodAnalysisException(String message) {

        super(message);
    }

    public MoodAnalysisException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}




