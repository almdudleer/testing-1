package com.almdudleer.labs.testing.lab1.power_series;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ArctanTest {

    private final double DELTA = 1E-6;

    @ParameterizedTest(name = "#{index} Test atan function with Value = {arguments}")
    @ValueSource(doubles = {Double.NEGATIVE_INFINITY, -1.7e308, -10e300, -10e100, -10e80, -10e9, -10e7, -10e5, -10e3,
            -10, -9, -7, -5, -3, -2, -1.8, -1.7, -1.5, -1.333333, -1.21312312312, -1.111111, -1.0000001, -1, -0.9, -0.8,
            -0.7323232, -0.4, -0.221123, -0.111111, -0.04412312, -0.00000004, 0, 0.00000004, 0.04412312, 0.111111,
            0.221123, 0.4, 0.7323232, 0.8, 0.9, 1, 1.0000001, 1.111111, 1.21312312312, 1.333333, 1.5, 1.7, 1.8, 2,
            3, 5, 7, 9, 10, 10e3, 10e5, 10e7, 10e9, 10e80, 10e100, 10e300, 1.7e308, Double.POSITIVE_INFINITY})
    void testAtanWithValue(double point) {
        assertEquals(Math.atan(point), Expanded.arctan(point, DELTA), DELTA);
    }
}
