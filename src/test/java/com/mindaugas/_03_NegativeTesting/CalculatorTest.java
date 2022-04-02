package com.mindaugas._03_NegativeTesting;

import com.mindaugas._01_RememberingUnitTests.Calculator;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class CalculatorTest {

    private Calculator calculator;

    // Junit lifecycle annotations
    @Before
    public void setup(){
        calculator = new Calculator();
    }


    // Positive path testing - we test that everything works under normal circumstances

    @Test
    // about: https://dzone.com/articles/7-popular-unit-test-naming
    public void testAddGivenTwoPositiveIntegersReturnsCorrectSum(){
        // given (create all necessary artifacts)
        // Calculator calculator = new Calculator();

        // when
        int result = calculator.add(5, 6);

        // then
        assertEquals(11, result);

        // teardown (clean all artifacts created for testing)
        calculator = null; // ... this is not needed; just for illustration
    }


    // Negative path - test that failures happen predictably

    @Test(expected = IllegalArgumentException.class)
    public void testAddGivenTwoINTMAXIntegersFailsWithInputException(){
        // when
        int result = calculator.add(Integer.MAX_VALUE, 6);
        // then
        assertEquals(11, result);
    }

    // Testing for exceptions using a different methodology
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void add_integerMaxPlus1_raisesException(){
        // then
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("One or both value too big!");

        // given
        int firstNum = Integer.MAX_VALUE;
        int secondNum = 1;

        int result = calculator.add(firstNum, secondNum);
    }

    @Parameters
    public static List<Integer[]> parameters() {
        return Arrays.asList(new Integer[][] {
                {1, 1, 2},
                {2, 4, 6},
                {1, 6, 7},
                {4, 1, 5}
        });
    }

    @Parameter(0)
    public int argument1;

    @Parameter(1)
    public int argument2;

    @Parameter(2)
    public int expectedResult;

    @Test
    public void testAdd() {
        // given
        Calculator calculator = new Calculator();
        // when
        int result = calculator.add(argument1, argument2);
        // then
        assertEquals(expectedResult, result);

    }
}