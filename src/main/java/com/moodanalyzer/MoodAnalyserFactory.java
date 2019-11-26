package com.moodanalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    public static MoodAnalyzer createMoodAnalyser(String message) throws MoodAnalysisException {

        try {
            Class newMoodAnalyserClass=Class.forName("com.moodanalyzer.MoodAnalyzer1");
            Constructor newConstructor=newMoodAnalyserClass.getConstructor(String.class);
            Object newObj=newConstructor.newInstance(message);
            return (MoodAnalyzer) newObj;

        } catch (ClassNotFoundException | NoSuchMethodException e) {
            // e.printStackTrace();
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;

    }

}
