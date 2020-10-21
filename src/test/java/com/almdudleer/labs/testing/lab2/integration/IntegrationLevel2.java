package com.almdudleer.labs.testing.lab2.integration;

import com.almdudleer.labs.testing.lab2.MyMath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationLevel2 {
    private static final double testPrecision = 10E-6;
    private static MyMath math;

    @BeforeAll
    static void setUp() throws IOException {
        math = MathStubBuilder.createMathStub("sin", "cos", "tan", "csc", "log");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "mock_tables/system.csv")
    void testSystem(double arg, double expected) {
        Assertions.assertEquals(expected, math.system(arg, testPrecision), testPrecision);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "mock_tables/complexTrigonometricFunction.csv")
    void testComplexTrigonometricFunction(double arg, double expected) {
        assertEquals(expected, math.complexTrigonometricFunction(arg, testPrecision), testPrecision);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "mock_tables/complexLogFunction.csv")
    void testComplexLogFunction(double arg, double expected) {
        assertEquals(expected, math.complexLogFunction(arg, testPrecision), testPrecision);
    }
}
