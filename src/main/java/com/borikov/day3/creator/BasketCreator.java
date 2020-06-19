package com.borikov.day3.creator;

import com.borikov.day3.entity.Ball;
import com.borikov.day3.entity.Basket;
import com.borikov.day3.enumtype.Color;
import com.borikov.day3.enumtype.Size;
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

    public Basket createFillUpBasket() {
        Basket basket = new Basket(200);
        basket.add(new Ball(Color.RED, Size.XXS, 1));
        basket.add(new Ball(Color.BLUE, Size.XS, 2));
        basket.add(new Ball(Color.GREEN, Size.S, 3));
        basket.add(new Ball(Color.GOLD, Size.M, 4));
        basket.add(new Ball(Color.ORANGE, Size.L, 5));
        basket.add(new Ball(Color.PURPLE, Size.XL, 6));
        basket.add(new Ball(Color.GREY, Size.XXL, 7));
        basket.add(new Ball(Color.GREY, Size.L, 8));
        basket.add(new Ball(Color.GREY, Size.M, 9));
        return basket;
    }
}
