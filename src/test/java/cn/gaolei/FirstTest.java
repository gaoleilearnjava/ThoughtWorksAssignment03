package cn.gaolei;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FirstTest {
    @Test
    public void testJudgeMethod() {
        List<String> white = new ArrayList<>();
        List<String> black = new ArrayList<>();
        white.add("2H");
        white.add("3D");
        white.add("5S");
        white.add("9C");
        white.add("KD");
        black.add("2D");
        black.add("3H");
        black.add("5C");
        black.add("9S");
        black.add("KH");

        Assert.assertEquals("Tie", TexasHoldem.judgeCards(white, black));
    }
}
