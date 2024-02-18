import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RegularExpressionMatcherTest {

    ArrayList<String> wordsToTest;
    ArrayList<String> expectedResults;

    @Before
    public void setUp() throws Exception {
        wordsToTest = new ArrayList<String>();
        expectedResults = new ArrayList<String>();
    }

    @Test
    public void test_language1() {
        expectedResults.clear();
        expectedResults.add("a+b");
        expectedResults.add("c(a+b)");
        expectedResults.add("(a+b)(a+b)");
        expectedResults.add("(a+b)(a+b)(a+b)");
        expectedResults.add("(a+b)(a+b)(a+b)(a+b)");
        expectedResults.add("(a+b)(a+b)(a+b)(a+b)(a+b)(a+b)");

        wordsToTest.clear();
        wordsToTest.addAll(expectedResults);
        wordsToTest.add("a");
        wordsToTest.add("b");
        wordsToTest.add("c");
        wordsToTest.add("a+");
        wordsToTest.add("aa+b");
        wordsToTest.add("(a+b)");
        wordsToTest.add("(a+b))");
        wordsToTest.add("(a+b)a+b");
        wordsToTest.add("(a+b)(ab)");
        wordsToTest.add("(a+b)(b+a)");
        wordsToTest.add("(a+b)c");
        wordsToTest.add("c(a+b)(a+b)");
        wordsToTest.add("c(a+b");
        wordsToTest.add("a+ba+b");

        Language1Matcher l1m = new Language1Matcher();
        l1m.setWordsToCompareAgainst(wordsToTest);
        assertEquals("Language 1", expectedResults, l1m.findMatches());
    }

    @Test
    public void test_language2() {
        expectedResults.clear();
        expectedResults.add("02/24");
        expectedResults.add("02-24");
        expectedResults.add("2/24");
        expectedResults.add("2-24");
        expectedResults.add("11/34");
        expectedResults.add("11-34");
        expectedResults.add("09/28");
        expectedResults.add("09-28");
        expectedResults.add("9/28");
        expectedResults.add("9-28");

        wordsToTest.clear();
        wordsToTest.addAll(expectedResults);
        wordsToTest.add("01/23");
        wordsToTest.add("01/35");
        wordsToTest.add("02 24");
        wordsToTest.add("0224");
        wordsToTest.add("224");
        wordsToTest.add("13/24");
        wordsToTest.add("-1/25");
        wordsToTest.add("082024");
        wordsToTest.add("08//24");
        wordsToTest.add("08--25");

        Language2Matcher l2m = new Language2Matcher();
        l2m.setWordsToCompareAgainst(wordsToTest);
        assertEquals("Language 2", expectedResults, l2m.findMatches());
    }

    @Test
    public void test_language3() {
        expectedResults.clear();
        expectedResults.add("0123210");
        expectedResults.add("030");
        expectedResults.add("03000");
        expectedResults.add("0000300");
        expectedResults.add("0011112232110");
        expectedResults.add("0033300");
        expectedResults.add("012333210");
        expectedResults.add("0011122223322222110");
        expectedResults.add("0113333310");
        expectedResults.add("023220");

        wordsToTest.clear();
        wordsToTest.addAll(expectedResults);
        wordsToTest.add("0123");
        wordsToTest.add("3210");
        wordsToTest.add("013210");
        wordsToTest.add("012310");
        wordsToTest.add("0230");
        wordsToTest.add("011223220");
        wordsToTest.add("12321");
        wordsToTest.add("0110");
        wordsToTest.add("00000");
        wordsToTest.add("0112232322110");

        Language3Matcher l3m = new Language3Matcher();
        l3m.setWordsToCompareAgainst(wordsToTest);
        assertEquals("Language 3", expectedResults, l3m.findMatches());
    }
}

