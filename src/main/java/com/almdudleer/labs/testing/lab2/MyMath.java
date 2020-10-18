package com.almdudleer.labs.testing.lab2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;


public class MyMath {

    public static final int MIN_ITERATION = 1500;

    public static void main(String[] args) {
        System.out.println("Sin(x)");
        System.out.println(MyMath.sin(Math.PI, 10e-6));
        System.out.println(MyMath.sin(Math.PI / 2, 10e-6));
        System.out.println(MyMath.sin(Math.PI / 3, 10e-6));
        System.out.println(MyMath.sin(Math.PI / 6, 10e-6));
        System.out.println("Cos(x)");
        System.out.println(MyMath.cos(Math.PI, 10e-6));
        System.out.println(MyMath.cos(Math.PI / 2, 10e-6));
        System.out.println(MyMath.cos(Math.PI / 3, 10e-6));
        System.out.println(MyMath.cos(Math.PI / 6, 10e-6));
        System.out.println("Ln(x)");
        System.out.println(MyMath.ln(1.5, 10e-6));
        System.out.println(MyMath.ln(Math.E, 10e-6));
        System.out.println(MyMath.ln(Math.E * Math.E, 10e-6));
    }

    public static double sin(double angle, double precision) {
        BigDecimal sum = BigDecimal.ZERO;
        long n = 0;
        BigDecimal x = BigDecimal.valueOf(angle);
        BigDecimal term = BigDecimal.valueOf(angle);
        BigInteger factorial = BigInteger.ONE;
        BigDecimal power = BigDecimal.valueOf(angle);
        sum = sum.add(term);
        double diff = term.doubleValue();
        while (diff > precision) {
            n++;
            int sign = n % 2 == 0 ? 1 : -1;
            power = power.multiply(x).multiply(x);
            factorial = factorial.multiply(BigInteger.valueOf(n * 2)).multiply(BigInteger.valueOf(n * 2 + 1));
            BigDecimal nextTerm = BigDecimal.valueOf(sign).multiply(power).divide(new BigDecimal(factorial), MathContext.DECIMAL64);
            diff = nextTerm.subtract(term).abs().doubleValue();
            term = nextTerm;
            sum = sum.add(term);
        }
        return sum.doubleValue();
    }

    public static double cos(double x, double precision) {
        return Math.sqrt(Math.abs(1 - Math.pow(sin(x, precision * precision), 2)));
    }

    public static double csc(double x, double precision) {
        return 1 / sin(x, precision);
    }

    public static double tan(double x, double precision) {
        return sin(x, precision) / cos(x, precision);
    }

    public static double ln(double x, double precision) {
        if (x < 0) {
            throw new IllegalArgumentException();
        }
        double x_;
        if (x > 2) {
            x_ = 1 / x - 1;
        } else {
            x_ = x - 1;
        }

        BigDecimal sum = BigDecimal.ZERO;

        long n = 1;
        BigDecimal arg = BigDecimal.valueOf(x_);
        BigDecimal term = BigDecimal.valueOf(x_);
        BigDecimal power = BigDecimal.valueOf(x_);
        sum = sum.add(term);
        double diff = term.doubleValue();

        while (diff > precision || n < MIN_ITERATION) {
            n++;
            int sign = n % 2 == 0 ? -1 : 1;
            power = power.multiply(arg);
            BigDecimal nextTerm = BigDecimal.valueOf(sign).multiply(power).divide(BigDecimal.valueOf(n), MathContext.DECIMAL64);
            diff = nextTerm.subtract(term).abs().doubleValue();
            term = nextTerm;
            sum = sum.add(term);
        }

        if (x > 2) {
            return -sum.doubleValue();
        } else {
            return sum.doubleValue();
        }
    }

    public static double log(double base, double x, double precision) {
        return ln(x, precision) / ln(base, precision);
    }

}