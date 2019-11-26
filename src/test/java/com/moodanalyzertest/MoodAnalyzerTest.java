package com.moodanalyzertest;

import com.moodanalyzer.MoodAnalyzer;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    @Test
    public void ifInputSadOrHappy_ShouldReturnSadOrHappyMood() {

        MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
        String result=moodAnalyzer.analyseMood("I am in Any Mood");
        Assert.assertEquals("HAPPY",result);


    }
}
