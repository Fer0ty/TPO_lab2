package org.example;

import org.example.function.ApproximatedUnaryFunction;
import org.example.function.FunctionsSystem;
import org.example.logariphmic.Ln;
import org.example.logariphmic.Log;
import org.example.trigonometric.Csc;
import org.example.trigonometric.Sin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {


    public static void writeToCsv(
            String filename,
            ApproximatedUnaryFunction function,
            BigDecimal from,
            BigDecimal to,
            BigDecimal step,
            BigDecimal precision
    ) throws IOException {
        final Path path = Paths.get(filename);
        final File file = new File(path.toUri());
        if (file.exists()) file.delete();
        file.createNewFile();
        final PrintWriter pw = new PrintWriter(file);
        for (BigDecimal current = from; current.compareTo(to) <= 0; current = current.add(step)) {
            pw.println(current + "," + function.calculate(current, precision));
        }
        pw.close();
    }

    public static void main(String[] args) throws IOException {
        final Sin sin = new Sin();
        final Csc csc = new Csc();
        final Ln ln = new Ln();
        final Log log3 = new Log(3);
        final Log log5 = new Log(5);
        final Log log10 = new Log(10);
        final FunctionsSystem functionsSystem = new FunctionsSystem();

        writeToCsv(
                "csv/sin.csv",
                sin,
                new BigDecimal(-1),
                new BigDecimal(1),
                new BigDecimal("0.1"),
                new BigDecimal("0.0000000001"));
        writeToCsv(
                "csv/csc.csv",
                csc,
                new BigDecimal(1),
                new BigDecimal(2),
                new BigDecimal("0.1"),
                new BigDecimal("0.0000000001"));
        writeToCsv(
                "csv/ln.csv",
                ln,
                new BigDecimal(1),
                new BigDecimal(20),
                new BigDecimal("0.1"),
                new BigDecimal("0.0000000001"));
        writeToCsv(
                "csv/log3.csv",
                log3,
                new BigDecimal(1),
                new BigDecimal(15),
                new BigDecimal("0.1"),
                new BigDecimal("0.00000000001"));
        writeToCsv(
                "csv/log5.csv",
                log5,
                new BigDecimal(1),
                new BigDecimal(20),
                new BigDecimal("0.1"),
                new BigDecimal("0.00000000001"));
        writeToCsv(
                "csv/log10.csv",
                log10,
                new BigDecimal(1),
                new BigDecimal(20),
                new BigDecimal("0.1"),
                new BigDecimal("0.00000000001"));
        writeToCsv(
                "csv/func.csv",
                functionsSystem,
                new BigDecimal(-3),
                new BigDecimal(3),
                new BigDecimal("0.11"),
                new BigDecimal("0.00000000001"));
    }

}



