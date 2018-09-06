package com.ciaoshen.maven.demo;
/** JUnit */
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
/** For my code */
import java.util.*;

/**
 * Unit test for simple App.
 */
public class CalculatorTest
{
    @Before
    public void init() {
        calc = new Calculator();
    }
    @Test
    public void testAdd()
    {
        int a = random();
        int b = random();
        assertEquals(calc.add(a, b), a + b);
    }
    @Test
    public void testMinus()
    {
        int a = random();
        int b = random();
        assertEquals(calc.minus(a, b), a - b);
    }
    @Test
    public void testMultiply()
    {
        int a = random();
        int b = random();
        assertEquals(calc.multiply(a, b), a * b);
    }
    @Test
    public void testDivide()
    {
        int a = random();
        int b = random(); // b > 0
        assertEquals(calc.divide(a, b), a / b);
    }
    @Test(expected=IllegalArgumentException.class)
    public void testDivideZero() {
        int a = random();
        int b = 0;
        calc.divide(a,b);
    }

    /** ==================== 【私有成员】 =====================*/
    private final int MAX = 999;
    private final Random R = new Random();
    private Calculator calc;

/** JUnit */
        return R.nextInt(MAX) + 1;
    }
/** For my code *}/
