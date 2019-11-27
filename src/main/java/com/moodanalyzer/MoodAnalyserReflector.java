package com.moodanalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserReflector {

    public static Constructor<?> getConstructor(Class<?> ... param) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.moodanalyzer.RealMoodAnalyser12");
            return moodAnalyserClass.getConstructor(param);

        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException("Define proper Class name", MoodAnalysisException.ExceptionType.NO_SUCH_CLASS);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException("No such method is present", MoodAnalysisException.ExceptionType.No_SUCH_METHOD);
        }

    }

    public static Object createMoodAnalyser(Constructor<?> constructor, Object ... message) throws MoodAnalysisException {

        try {
            return constructor.newInstance(message);
        } catch (InstantiationException e) {
            throw new MoodAnalysisException("Method Not Instantiate",MoodAnalysisException.ExceptionType.NOT_INSTANTIATE);
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException("Define proper method name",MoodAnalysisException.ExceptionType.NO_ACCESS);
        } catch (InvocationTargetException e) {
            throw new MoodAnalysisException("Method not Invoked",MoodAnalysisException.ExceptionType.METHOD_INVOCATION_ISSEU);
        }

    }

    public static MoodAnalyzer createMoodAnalyser(String message) throws MoodAnalysisException {

        try {
            Class newMoodAnalyserClass=Class.forName("com.moodanalyzer.MoodAnalyzer");
            Constructor newConstructor=newMoodAnalyserClass.getConstructor(String.class);
            Object newObj=newConstructor.newInstance(message,message);
            return (MoodAnalyzer) newObj;

        } catch (ClassNotFoundException e){
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS);
        } catch (IllegalArgumentException | NoSuchMethodException e){
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.No_SUCH_METHOD);
        }
        catch (IllegalAccessException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_ACCESS);
        } catch (InstantiationException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NOT_INSTANTIATE);
        } catch (InvocationTargetException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.METHOD_INVOCATION_ISSEU);
        }

    }

}
