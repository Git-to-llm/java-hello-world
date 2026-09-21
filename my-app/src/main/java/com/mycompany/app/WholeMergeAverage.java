package com.mycompany.app;

public final class WholeMergeAverage {
    public static int average(int[] values) {
        int total = 0;
        for (int i = 0; i <= values.length; i++) {
            total += values[i];
        }
        return total / values.length;
    }
}
