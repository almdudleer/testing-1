package com.almdudleer.labs.testing.lab2.integration;

import com.almdudleer.labs.testing.lab2.MathStubBuilder;
import com.almdudleer.labs.testing.lab2.MyMath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationLevel3 {
    private static final double testPrecision = 10E-4;
    private static MyMath math;

    @BeforeAll
    static void setUp() throws IOException {
        math = MathStubBuilder.createMathStub("sin", "cos", "ln");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "mock_tables/system.csv")
    void testSystem(double arg, double expected) {
        Assertions.assertEquals(expected, math.system(arg, testPrecision), testPrecision);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "mock_tables/csc.csv")
    void testCsc(double arg, double expected) {
        assertEquals(expected, math.csc(arg, testPrecision), testPrecision);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "mock_tables/tan.csv")
    void testTan(double arg, double expected) {
        assertEquals(expected, math.tan(arg, testPrecision), testPrecision);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "mock_tables/complexTrigonometricFunction.csv")
    void testComplexTrigonometricFunction(double arg, double expected) {
        assertEquals(expected, math.complexTrigonometricFunction(arg, testPrecision), testPrecision);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "mock_tables/log.csv")
    void testLog(double base, double arg, double expected) {
        assertEquals(expected, math.log(base, arg, testPrecision), testPrecision);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "mock_tables/complexLogFunction.csv")
    void testComplexLogFunction(double arg, double expected) {
        assertEquals(expected, math.complexLogFunction(arg, testPrecision), testPrecision);
    }
}
