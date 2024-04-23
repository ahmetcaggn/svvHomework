// B211202030
// Ahmetcan Ersoy
// Software Verification And Validation Homework1
// https://github.com/ahmetcaggn/svvHomework

package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testDivision1() {
        assertEquals(5, Calculator.divide(10, 2));
    }

    @Test
    void testDivision2() {
        assertEquals(2.5, Calculator.divide(10, 4));
    }

    @Test
    void testDivision3() {
        assertEquals(5, Calculator.divide(12.5f, 2.5f));
    }

    @Test
    void testDivision4() {
        assertEquals(4, Calculator.divide(10, 2.5f));
    }

    @Test
    void testDivision5() {
        assertEquals(2.5f, Calculator.divide(12.5f, 5));
    }

    @Test
    void testDivision6() {
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> Calculator.divide(12.5f, 0),
                "IllegalArgumentException expected."
        );

        // Optional. To check whether the error messages match.
        assertEquals("Illegal Argument Exception.", exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "10f,     2f,     5f",
            "10f,     4f,     2.5f",
            "12.5f,   2.5f,   5f",
            "10f,     2.5f,   4f",
            "12.5f,   5f,     2.5f"
    })
    void testDivision7(float a, float b, float expected) {
        assertEquals(expected, Calculator.divide(a, b));
    }
}