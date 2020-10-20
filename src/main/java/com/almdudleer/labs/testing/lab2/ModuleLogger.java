package com.almdudleer.labs.testing.lab2;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModuleLogger {
    private static final MyMath myMath = new MyMath();
    private static final double precision = 10E-4;

    private static final List<String> moduleNames = Arrays.asList(
            "sin", "cos", "csc", "tan", "ln",
            "complexLogFunction", "complexTrigonometricFunction",
            "system", "log2", "log3", "log5", "log10"
    );


    public static void main(String[] args) throws IOException {
        double step = 2.5;
        final double startX = -10;
        final double endX = 10;
        final String logDirName = "./out/logs";

        if (args.length > 0) {
            step = Double.parseDouble(args[0]);
        }

        writeAllModuleOutputs(startX, endX, step, logDirName);
    }

    public static void writeAllModuleOutputs(
            double startX,
            double endX,
            double step,
            String logDirName
    ) throws IOException {

        for (String moduleName : moduleNames) {
            writeModuleOutputs(startX, endX, step, logDirName, moduleName);
        }
    }

    public static double calcModuleOutput(String moduleName, double x, double precision) {
        switch (moduleName) {
            case "sin":
                return myMath.sin(x, precision);
            case "cos":
                return myMath.cos(x, precision);
            case "csc":
                return myMath.csc(x, precision);
            case "tan":
                return myMath.tan(x, precision);
            case "ln":
                return myMath.ln(x, precision);
            case "complexLogFunction":
                return myMath.complexLogFunction(x, precision);
            case "complexTrigonometricFunction":
                return myMath.complexTrigonometricFunction(x, precision);
            case "system":
                return myMath.system(x, precision);
            case "log2":
                return myMath.log(2, x, precision);
            case "log3":
                return myMath.log(3, x, precision);
            case "log5":
                return myMath.log(5, x, precision);
            case "log10":
                return myMath.log(10, x, precision);
            default:
                throw new IllegalArgumentException("Unknown function: " + moduleName);
        }
    }

    public static void writeModuleOutputs(
            double startX,
            double endX,
            double step,
            String dirName,
            String moduleName
    ) throws IOException {
        File dir = new File(dirName);
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                throw new IOException("Could not create directory " + dir);
            }
        }

        List<String[]> outputs = new ArrayList<>();
        for (double x = startX; x < endX; x += step) {
            double output = calcModuleOutput(moduleName, x, precision);
            outputs.add(new String[]{Double.toString(x), Double.toString(output)});
        }
        File file = new File(dirName, moduleName + ".csv");
        CSVWriter writer = new CSVWriter(new FileWriter(file));
        writer.writeAll(outputs, false);
        writer.flush();
        writer.close();
    }
}
