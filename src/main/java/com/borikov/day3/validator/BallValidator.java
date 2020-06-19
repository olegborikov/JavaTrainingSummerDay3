package com.borikov.day3.validator;

public class BallValidator {
    private static final double MIN_WEIGHT = 0.1;
    private static final double MAX_WEIGHT = 10;

    public boolean isWeightInLimit(double weight) {
        boolean result = false;
        if (weight >= MIN_WEIGHT && weight <= MAX_WEIGHT) {
            result = true;
        }
        return result;
    }
}
