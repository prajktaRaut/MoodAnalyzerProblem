package com.moodanalyzer;

public class MoodAnalysisException extends Exception {


    public MoodAnalysisException(ExceptionType enteredNull) {

        super(String.valueOf(enteredNull));
        this.exceptionType=enteredNull;
    }

    public enum ExceptionType{

        ENTERED_NULL, ENTERED_EMPTY,NO_SUCH_CLASS,No_SUCH_METHOD

    }

    public ExceptionType exceptionType;

    public MoodAnalysisException(String message, ExceptionType exceptionType) {
        super(message);
        this.exceptionType=exceptionType;
    }

    public MoodAnalysisException(String message) {
        super(message);
    }
}




