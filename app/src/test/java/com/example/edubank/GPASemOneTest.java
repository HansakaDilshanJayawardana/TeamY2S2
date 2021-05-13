package com.example.edubank;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class GPASemOneTest {
    private FinalGPA finalGPA;

    @Before
    public void setup() {
        finalGPA = new FinalGPA();
    }

    @Test
    public void test_getGradePoint() {
        String result = String.valueOf(finalGPA.getGradePoint("A+"));
        assertEquals(result, 4.0, Double.parseDouble(result), 0.001);
    }

    @Test
    public void test_getCredit() {
        String result = String.valueOf(finalGPA.getCredit("6"));
        assertEquals(result, 6.0, Double.parseDouble(result), 0.001);
    }

    @Test
    public void test_addGPASemOne() {
        double result = finalGPA.addGPASemOne(4.0, 3.7, 3.3, 3.0, 2.7);
        assertEquals(16.7, result, 0.001);
    }

    @Test
    public void test_calculateGPASemOne() {
        double result = finalGPA.calculateGPASemOne(16.7, 5.0);
        assertEquals(3.34, result, 0.001);
    }

    @Test
    public void test_addCreditsSemOne() {
        double result = finalGPA.addCreditsSemOne(1.0, 2.0, 3.0, 4.0, 5.0);
        assertEquals(15.0, result, 0.001);
    }

    @Test
    public void test_multiplyGradePointsSemOne() {
        double result = finalGPA.multiplyGradePointsSemOne(4.0, 1.0, 3.7, 2.0, 3.3, 3.0, 3.0, 4.0, 2.7, 5.0);
        assertEquals(46.8, result, 0.001);
    }

    @Test
    public void test_calculateCGPASemOne() {
        double result = finalGPA.calculateCGPASemOne(15.0, 46.8);
        assertEquals(3.12, result, 0.001);
    }
}