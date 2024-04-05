package org.example.function;

import org.example.logariphmic.Ln;
import org.example.logariphmic.Log;
import org.example.trigonometric.Csc;
import org.example.trigonometric.Sin;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;
import static java.math.RoundingMode.HALF_EVEN;
import static java.math.RoundingMode.HALF_UP;

public class FunctionsSystem implements ApproximatedUnaryFunction{
    private final Sin sin;
    private final Csc csc;
    private final Ln ln;
    private final Log log3;
    private final Log log5;

    public FunctionsSystem() {
        this.sin = new Sin();
        this.csc = new Csc();
        this.ln = new Ln();
        this.log3 = new Log(3);
        this.log5 = new Log(5);
    }

    public BigDecimal calculate(BigDecimal x, BigDecimal precision){
        if (x.compareTo(ZERO) <= 0){
            return csc.calculate(x, precision).multiply(csc.calculate(x,precision)).setScale(precision.scale(), HALF_EVEN);
        } else {
            return ((((ln.calculate(x, precision)
                    .multiply(log3.calculate(x, precision)))
                    .divide(log5.calculate(x, precision),HALF_UP))
                    .multiply(log5.calculate(x, precision)))
                    .divide(log5.calculate(x, precision), HALF_UP))
                    .multiply(log3.calculate(x,precision).pow(2))
                    .setScale(precision.scale(), HALF_EVEN);
        }
    }
}
