package com.borikov.day3.validator;

public class BallValidator {
    private static final double MAX_VALUE_WEIGHT = 100;

    public boolean isWeightInLimit(double weight) {
        boolean result = false;
        if (weight > 0 && weight < MAX_VALUE_WEIGHT) {
            result = true;
        }
        return result;
    }
}
