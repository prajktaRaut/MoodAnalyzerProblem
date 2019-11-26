package com.moodanalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    public static MoodAnalyzer createMoodAnalyser(String message) {

        try {
            Class newMoodAnalyserClass=Class.forName("com.moodanalyzer.MoodAnalyzer");
            Constructor newConstructor=newMoodAnalyserClass.getConstructor(String.class);
            Object newObj=newConstructor.newInstance(message);
            return (MoodAnalyzer) newObj;

        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
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
