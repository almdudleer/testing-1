package com.almdudleer.labs.testing.power_series;

import java.util.function.BiFunction;

public class Expanded {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(arctan(1, 1.0e-6));
        long diff = System.currentTimeMillis() - start;
        System.out.println(Math.PI/4);
        System.out.println("Took time: " + diff + "ms");
    }

    public static double arctan(double x, double precision) {
        BiFunction<Double, Integer, Double> xFun;
        if ((x <= 1) && (x >= -1)) {
            xFun = (x_, n_) -> Math.pow(x_, 2 * n_ + 1);
        } else {
            xFun = (x_, n_) -> 1 / Math.pow(x_, 2 * n_ + 1);
        }

        double sum = 0;
        int n = 0;
        double term = Double.POSITIVE_INFINITY;
        while (Math.abs(term) > precision) {
            double mult1 = n % 2 == 0 ? 1 : -1;
            double mult2 = 1 / (double) (2 * n + 1);
            double mult3 = xFun.apply(x, n);
            term = mult1*mult2*mult3;
            sum += term;
            n += 1;
        }

        double res;
        if ((x <= 1) && (x >= -1)) {
            res = sum;
        } else if (x > 1) {
            res = (Math.PI / 2) - sum;
        } else {
            res = - (Math.PI / 2) - sum;
        }

        return res;
    }
}
