package com.moodanalyzertest;

import com.moodanalyzer.MoodAnalyzer;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    @Test
    public void ifMeesageIs_SadMood_ShouldReturnSadMood() {

        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String result=moodAnalyzer.analyseMood("I am in Sad Mood");
        Assert.assertEquals("SAD",result);

    }

    @Test
    public void IfMessageIs_AnyMood_ShouldReturnHappyMood_() {

        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Any Mood");
        String result=moodAnalyzer.analyseMood();
        Assert.assertEquals("HAPPY",result);

    }

    @Test
    public void ifInputIs_AnyParameter_ShouldReturnSadOrHappyMood() {

        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String result=moodAnalyzer.analyseMood("I am in Happy Mood");
        Assert.assertEquals("HAPPY",result);

    }

    @Test
    public void ifInputIs_Null_ShouldReturnSadOrHappyMood() {

        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String result=moodAnalyzer.analyseMood();
        Assert.assertEquals("SAD",result);

    }

}
