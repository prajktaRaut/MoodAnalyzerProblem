package com.moodanalyzertest;

import com.moodanalyzer.MoodAnalyserFactory;
import com.moodanalyzer.MoodAnalysisException;
import com.moodanalyzer.MoodAnalyzer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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

        MoodAnalyzer moodAnalyzer= MoodAnalyserFactory.createMoodAnalyser("I am in debug mode");

        boolean result=moodAnalyzer.equals(moodAnalyzer);

        Assert.assertTrue(result);

    }
}
