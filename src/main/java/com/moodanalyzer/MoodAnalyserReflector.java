package com.moodanalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
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
            return constructor.newInstance(message,message);
        } catch (InstantiationException e) {
            throw new MoodAnalysisException("Method Not Instantiate",MoodAnalysisException.ExceptionType.NOT_INSTANTIATE);
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException("Define proper method name",MoodAnalysisException.ExceptionType.NO_ACCESS);
        } catch (InvocationTargetException e) {
            throw new MoodAnalysisException("Method not Invoked",MoodAnalysisException.ExceptionType.METHOD_INVOCATION_ISSEU);
        }

    }

    public static MoodAnalyzer createMoodAnalyzser() throws MoodAnalysisException {

        try {
            Class MoodAnalyserClass=Class.forName("com.moodanalyzer.RealMoodAnalyser");
            Constructor newConstructor=MoodAnalyserClass.getConstructor();
            Object myobj=newConstructor.newInstance();
            return (MoodAnalyzer)myobj;

        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException("Define proper Class name",MoodAnalysisException.ExceptionType.NO_SUCH_CLASS);
        } catch (NoSuchMethodException e) {
            //e.printStackTrace();
            throw new MoodAnalysisException("No such method is present",MoodAnalysisException.ExceptionType.No_SUCH_METHOD);
        } catch (IllegalAccessException e) {
            throw new MoodAnalysisException("Define proper method name",MoodAnalysisException.ExceptionType.NO_ACCESS);
        } catch (InstantiationException e) {
            throw new MoodAnalysisException("Method Not Instantiate",MoodAnalysisException.ExceptionType.NOT_INSTANTIATE);
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

    public static Object invokeMethod(Object moodAnalysisObject, String methodName) throws MoodAnalysisException {

        try {
            return moodAnalysisObject.getClass().getMethod(methodName).invoke(moodAnalysisObject);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException("Define proper method name", MoodAnalysisException.ExceptionType.No_SUCH_METHOD);
        }
        catch (IllegalAccessException | InvocationTargetException e)
        {
            throw new MoodAnalysisException("May be issued with Data Entered", MoodAnalysisException.ExceptionType.NO_ACCESS);

        }

    }

    public static void setFieldValue(Object myObject, String fieldName, String fieldValue) throws MoodAnalysisException {

        try {
            Field field= myObject.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(myObject,fieldValue);

        } catch (NoSuchFieldException e ){
            throw new MoodAnalysisException("Define Proper Field Name", MoodAnalysisException.ExceptionType.No_SUCH_METHOD);
        }catch (IllegalAccessException e) {
            throw new MoodAnalysisException("May be issued with Data Entered", MoodAnalysisException.ExceptionType.NO_ACCESS);

        }

    }





}
