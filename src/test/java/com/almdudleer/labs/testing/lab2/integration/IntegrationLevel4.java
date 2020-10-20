package com.almdudleer.labs.testing.lab2.integration;

import com.almdudleer.labs.testing.lab2.MyMath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationLevel4 {
    private static final double testPrecision = 10E-2;
    private static final double calcPrecision = 10E-4;
    private static MyMath math;

    @BeforeAll
    static void setUp() {
        math = new MyMath();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "mock_tables/system.csv")
    void testSystem(double arg, double expected) {
        Assertions.assertEquals(expected, math.system(arg, calcPrecision), testPrecision);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "mock_tables/sin.csv")
    void testSin(double arg, double expected) {
        assertEquals(expected, math.sin(arg, calcPrecision), testPrecision);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "mock_tables/cos.csv")
    void testCos(double arg, double expected) {
        assertEquals(expected, math.cos(arg, calcPrecision), testPrecision);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "mock_tables/csc.csv")
    void testCsc(double arg, double expected) {
        assertEquals(expected, math.csc(arg, calcPrecision), testPrecision);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "mock_tables/tan.csv")
    void testTan(double arg, double expected) {
        assertEquals(expected, math.tan(arg, calcPrecision), testPrecision);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "mock_tables/complexTrigonometricFunction.csv")
    void testComplexTrigonometricFunction(double arg, double expected) {
        assertEquals(expected, math.complexTrigonometricFunction(arg, calcPrecision), testPrecision);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "mock_tables/ln.csv")
    void testLn(double arg, double expected) {
        assertEquals(expected, math.ln(arg, calcPrecision), testPrecision);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "mock_tables/log.csv")
    void testLog(double base, double arg, double expected) {
        assertEquals(expected, math.log(base, arg, calcPrecision), testPrecision);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "mock_tables/complexLogFunction.csv")
    void testComplexLogFunction(double arg, double expected) {
        assertEquals(expected, math.complexLogFunction(arg, calcPrecision), testPrecision);
    }
}
