package com.almdudleer.labs.testing.lab2.integration;

import com.almdudleer.labs.testing.lab2.MyMath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.IOException;

public class IntegrationLevel1 {
    private static final double testPrecision = 10E-6;
    private static MyMath math;

    @BeforeAll
    static void setUp() throws IOException {
        math = MathStubBuilder.createMathStub(testPrecision, "complexLogFunction", "complexTrigonometricFunction");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "mock_tables/system.csv")
    void testSystem(double arg, double expected) {
        Assertions.assertEquals(expected, math.system(arg, testPrecision));
    }
}
