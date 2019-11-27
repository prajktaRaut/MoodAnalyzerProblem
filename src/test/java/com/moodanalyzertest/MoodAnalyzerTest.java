package com.moodanalyzertest;

import com.moodanalyzer.MoodAnalyserReflector;
import com.moodanalyzer.MoodAnalysisException;
import com.moodanalyzer.MoodAnalyzer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Constructor;


public class MoodAnalyzerTest {

    @Test
    public void ifMeesageIs_SadMood_ShouldReturnSadMood() {

        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String result= null;
        try {
            result = moodAnalyzer.analyseMood("I am in Sad Mood");
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("SAD",result);

    }

    @Test
    public void IfMessageIs_AnyMood_ShouldReturnHappyMood_() {

        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Any Mood");
        String result= null;
        try {
            result = moodAnalyzer.analyseMood();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("HAPPY",result);

    }

    @Test
    public void ifInputIs_AnyParameter_ShouldReturnSadOrHappyMood() {

        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String result= null;
        try {
            result = moodAnalyzer.analyseMood("I am in Happy Mood");
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("HAPPY",result);

    }

    @Test
    public void ifInputIs_Null_ShouldReturnSadOrHappyMood() {

        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String result= null;
        try {
            result = moodAnalyzer.analyseMood();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("SAD",result);

    }

    @Test
    public void IfInputInConstructorIs_SadMood_ShouldReturnSad() {

        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Sad Mood");
        String result= null;
        try {
            result = moodAnalyzer.analyseMood();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("SAD",result);

    }

    @Test
    public void IfInputInConstructorIs_HappyMood_ShouldReturnSad() {

        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Happy Mood");
        String result= null;
        try {
            result = moodAnalyzer.analyseMood();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("SAD",result);

    }

    @Test
    public void givenMethod_ToHandle_NullPointerException() {

        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String result= null;
        try {
            result = moodAnalyzer.analyseMood();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("Please enter proper input",result);

    }

    @Test
    public void givenMethod_ToHandle_NullPointerException_ShouldReturnHappy() {

        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String result= null;
        try {
            result = moodAnalyzer.analyseMood();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("HAPPY",result);

    }

    @Test
    public void givenMethod_ToHandleCustomException_ShouldReturnMessage() {

        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        try {
            ExpectedException expectedException = ExpectedException.none();
            expectedException.expect(MoodAnalysisException.class);
            moodAnalyzer.analyseMood(null);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals("Please enter proper input", e.getMessage());
        }
    }

    @Test
    public void givenNullMood_ShouldThrowMoodAnalysisException() {

        MoodAnalyzer realMoodAnalyser = new MoodAnalyzer(null);

        try {

            realMoodAnalyser.analyseMood(null);

        } catch (MoodAnalysisException e) {

            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_NULL,e.exceptionType);

        }

    }

    @Test
    public void givenEmptyMood_ShouldThrowMoodAnalysisException() {

        MoodAnalyzer realMoodAnalyser = new MoodAnalyzer(" ");

        try {

            realMoodAnalyser.analyseMood(" ");

        } catch (MoodAnalysisException e) {

            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_EMPTY,e.exceptionType);

        }

    }

    @Test
    public void ifTwoObjectsAreEquals_shouldReturnTrue() {

        MoodAnalyzer moodAnalyzer= null;
        try {
            moodAnalyzer = MoodAnalyserReflector.createMoodAnalyser("I am in debug mode");
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }

        boolean result=moodAnalyzer.equals(moodAnalyzer);

        Assert.assertTrue(result);

    }

    @Test
    public void whenClassName_IsImproper_ShouldReturnMoodAnalysisException()  {


        try {
            MoodAnalyzer moodAnalyzer= MoodAnalyserReflector.createMoodAnalyser("Improper class name");
            moodAnalyzer.analyseMood();

        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS,e.exceptionType);
        }


    }

    @Test
    public void whenConstructorName_IsImproper_ShouldReturnMoodAnalysisException()  {


        try {
            MoodAnalyzer moodAnalyzer= MoodAnalyserReflector.createMoodAnalyser("Improper method name");
            moodAnalyzer.analyseMood();

        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.No_SUCH_METHOD,e.exceptionType);
        }

    }

    @Test
    public void givenMoodAnanlyserClass_WhenProper_ShouldReturnObject() {

        try {
            Constructor<?> constructor=MoodAnalyserReflector.getConstructor(String.class);
            Object myobject=MoodAnalyserReflector.createMoodAnalyser(constructor,"I am in Happy Mood");
            Assert.assertEquals(new MoodAnalyzer("I am in Happy Mood"),myobject);

        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyserImproperClassNameShouldReturnException() {
        try {
            Constructor<?> constructor =  MoodAnalyserReflector.getConstructor(String.class);
            MoodAnalyserReflector.createMoodAnalyser(constructor,"I am in happy mood");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, e.exceptionType);
        }
    }



}
