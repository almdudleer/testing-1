package com.almdudleer.labs.testing.lab2.integration;

import com.almdudleer.labs.testing.lab2.MyMath;
import com.opencsv.CSVReader;
import org.mockito.Mockito;

import java.io.FileReader;
import java.io.IOException;

import static org.mockito.Mockito.doReturn;

public class MathStubBuilder {
    private static final String mockTablesPath = "src/test/resources/com/almdudleer/labs/testing/lab2/integration/mock_tables/";

    public static MyMath createMathStub(double precision, String... stubFns) throws IOException {
        MyMath mathMock = Mockito.mock(MyMath.class, Mockito.CALLS_REAL_METHODS);
        for (String fn : stubFns) {
            for (String[] line : new CSVReader(new FileReader( mockTablesPath + fn + ".csv")).readAll()) {
                double returnValue = Double.parseDouble(line[1]);
                switch (fn) {
                    case "sin":
                         doReturn(returnValue).when(mathMock).sin(Double.parseDouble(line[0]), precision);
                        break;
                    case "cos":
                         doReturn(returnValue).when(mathMock).cos(Double.parseDouble(line[0]), precision);
                        break;
                    case "csc":
                         doReturn(returnValue).when(mathMock).csc(Double.parseDouble(line[0]), precision);
                        break;
                    case "tan":
                         doReturn(returnValue).when(mathMock).tan(Double.parseDouble(line[0]), precision);
                        break;
                    case "ln":
                        doReturn(returnValue).when(mathMock).ln(Double.parseDouble(line[0]), precision);
                        break;
                    case "log":
                         doReturn(Double.parseDouble(line[2])).when(mathMock).log(
                                Double.parseDouble(line[0]),
                                Double.parseDouble(line[1]),
                                precision
                        );
                        break;
                    case "complexLogFunction":
                         doReturn(returnValue).when(mathMock)
                                 .complexLogFunction(Double.parseDouble(line[0]), precision);
                        break;
                    case "complexTrigonometricFunction":
                         doReturn(returnValue).when(mathMock)
                                .complexTrigonometricFunction(Double.parseDouble(line[0]), precision);
                        break;
                    case "system":
                         doReturn(returnValue).when(mathMock).system(Double.parseDouble(line[0]), precision);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown function: " + fn);

                }
            }
        }
        return mathMock;
    }
}
