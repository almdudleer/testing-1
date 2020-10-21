package com.almdudleer.labs.testing.lab2;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModuleLogger {
    private final double precision;
    private final MyMath myMath;
    private final String logDirName;

    private static final List<String> moduleNames = Arrays.asList(
            "sin", "cos", "csc", "tan", "ln",
            "complexLogFunction", "complexTrigonometricFunction",
            "system", "log2", "log3", "log5", "log10"
    );


    public static void main(String[] args) throws IOException {
        double step = 0.5;
        final double startX = -6;
        final double endX = 6;

        if (args.length > 0) {
            step = Double.parseDouble(args[0]);
        }

        ModuleLogger moduleLogger1 = new ModuleLogger(MathStubBuilder.createMathStub("sin", "cos", "ln", "tan", "csc", "log", "complexLogFunction", "complexTrigonometricFunction"), "./out/logs/integrationStep1", 10E-6);
        ModuleLogger moduleLogger2 = new ModuleLogger(MathStubBuilder.createMathStub("sin", "cos", "ln", "tan", "csc", "log"), "./out/logs/integrationStep2", 10E-6);
        ModuleLogger moduleLogger3 = new ModuleLogger(MathStubBuilder.createMathStub("sin", "cos", "ln"), "./out/logs/integrationStep3", 10E-4);
        ModuleLogger moduleLogger4 = new ModuleLogger(new MyMath(), "./out/logs/integrationStep4", 10E-4);

        if (args.length > 0) {
            step = Double.parseDouble(args[0]);
        }

        moduleLogger1.writeModuleOutputs("system", step, startX, endX);
        moduleLogger2.writeModuleOutputs("system", step, startX, endX);
        moduleLogger3.writeModuleOutputs("system", step, startX, endX);
        moduleLogger4.writeModuleOutputs("system", step, startX, endX);
    }

    public ModuleLogger(MyMath myMath, String logDirName, double precision) throws IOException {
        this.myMath = myMath;
        this.precision = precision;

        File dir = new File(logDirName);
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                throw new IOException("Could not create directory " + dir);
            }
        }

        this.logDirName = logDirName;
    }

    public void writeAllModuleOutputs(
            double step,
            double startX,
            double endX
    ) throws IOException {
        for (String moduleName : moduleNames) {
            writeModuleOutputs(moduleName, step, startX, endX);
        }
    }

    public double calcModuleOutput(String moduleName, double x, double precision) {
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

    public void writeModuleOutputs(
            String moduleName,
            double step,
            double startX,
            double endX
    ) throws IOException {
        List<String[]> outputs = new ArrayList<>();
        for (double x = startX; x < endX; x += step) {
            double output = calcModuleOutput(moduleName, x, precision);
            outputs.add(new String[]{Double.toString(x), Double.toString(output)});
        }
        File file = new File(logDirName, moduleName + ".csv");
        CSVWriter writer = new CSVWriter(new FileWriter(file));
        writer.writeAll(outputs, false);
        writer.flush();
        writer.close();
    }
}
