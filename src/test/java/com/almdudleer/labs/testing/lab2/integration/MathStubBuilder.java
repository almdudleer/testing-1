package com.almdudleer.labs.testing.lab2.integration;

import com.almdudleer.labs.testing.lab2.MyMath;
import com.opencsv.CSVReader;
import org.mockito.Mockito;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;

public class MathStubBuilder {
    private static final String mockTablesPath =
            "src/test/resources/com/almdudleer/labs/testing/lab2/integration/mock_tables/";

    public static MyMath createMathStub(String... stubFns) throws IOException {
        MyMath mathMock = Mockito.spy(new MyMath());
        Set<String> stubFnsSet = new HashSet<>(Arrays.asList(stubFns));
        for (String fn : stubFnsSet) {
            for (String[] line : new CSVReader(new FileReader(mockTablesPath + fn + ".csv")).readAll()) {
                double returnValue = Double.parseDouble(line[1]);
                switch (fn) {
                    case "sin":
                        doReturn(returnValue).when(mathMock).sin(eq(Double.parseDouble(line[0])), anyDouble());
                        break;
                    case "cos":
                        doReturn(returnValue).when(mathMock).cos(eq(Double.parseDouble(line[0])), anyDouble());
                        break;
                    case "csc":
                        doReturn(returnValue).when(mathMock).csc(eq(Double.parseDouble(line[0])), anyDouble());
                        break;
                    case "tan":
                        doReturn(returnValue).when(mathMock).tan(eq(Double.parseDouble(line[0])), anyDouble());
                        break;
                    case "ln":
                        doReturn(returnValue).when(mathMock).ln(eq(Double.parseDouble(line[0])), anyDouble());
                        break;
                    case "log":
                        doReturn(Double.parseDouble(line[2])).when(mathMock).log(
                                eq(Double.parseDouble(line[0])),
                                eq(Double.parseDouble(line[1])),
                                anyDouble()
                        );
                        break;
                    case "complexLogFunction":
                        doReturn(returnValue).when(mathMock)
                                .complexLogFunction(eq(Double.parseDouble(line[0])), anyDouble());
                        break;
                    case "complexTrigonometricFunction":
                        doReturn(returnValue).when(mathMock)
                                .complexTrigonometricFunction(eq(Double.parseDouble(line[0])), anyDouble());
                        break;
                    case "system":
                        doReturn(returnValue).when(mathMock).system(eq(Double.parseDouble(line[0])), anyDouble());
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown function: " + fn);

                }
            }
        }
        return mathMock;
    }
}
