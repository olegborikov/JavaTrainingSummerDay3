package com.borikov.day3.creator;

import com.borikov.day3.entity.Basket;
import com.borikov.day3.exception.IncorrectDataException;
import com.borikov.day3.validator.BasketValidator;

public class BasketCreator {
    public Basket createBasket(double capacity) throws IncorrectDataException {
        BasketValidator basketValidator = new BasketValidator();
        if (!basketValidator.isCapacityInLimit(capacity)) {
            throw new IncorrectDataException();
        }
        return new Basket(capacity);
    }
}
