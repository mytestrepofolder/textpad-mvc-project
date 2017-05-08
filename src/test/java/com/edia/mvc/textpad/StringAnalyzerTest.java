package com.edia.mvc.textpad;

import org.junit.Assert;
import org.junit.Test;

import com.edia.mvc.textpad.readability.StringAnalyzer.Stats;
import com.edia.mvc.textpad.readability.StringAnalyzer;;


public class StringAnalyzerTest {
  @Test
  public void testSimple() {
    
    Stats s = StringAnalyzer.analyze("This is one sentence.This is another sentence.");
    Assert.assertEquals(2, s.getNumSentences());
    Assert.assertEquals(1, s.getNumComplexWords());
    Assert.assertEquals(8, s.getNumWords());
  }
}
