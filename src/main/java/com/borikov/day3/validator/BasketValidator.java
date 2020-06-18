package com.borikov.day3.validator;

public class BasketValidator {
    private static final double MAX_CAPACITY = 200;

    public boolean isCapacityInLimit(double capacity) {
        boolean result = false;
        if (capacity > 0 && capacity < MAX_CAPACITY) {
            result = true;
        }
        return result;
    }
}
