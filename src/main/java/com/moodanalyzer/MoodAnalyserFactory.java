package com.moodanalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    public static MoodAnalyzer createMoodAnalyser(String message) throws MoodAnalysisException {

        try {
            Class newMoodAnalyserClass=Class.forName("com.moodanalyzer.MoodAnalyzer");
            Constructor newConstructor=newMoodAnalyserClass.getConstructor(String.class);
            Object newObj=newConstructor.newInstance(message,message);
            return (MoodAnalyzer) newObj;

        } catch (ClassNotFoundException e){
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS);
        }catch (IllegalArgumentException | NoSuchMethodException e){
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.No_SUCH_METHOD);
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;

    }

}
