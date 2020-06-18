package com.borikov.day3;

import com.borikov.day3.creator.BallCreator;
import com.borikov.day3.creator.BasketCreator;
import com.borikov.day3.entity.Ball;
import com.borikov.day3.entity.Basket;
import com.borikov.day3.enumtype.Color;
import com.borikov.day3.enumtype.Size;
import com.borikov.day3.exception.IncorrectDataException;
import com.borikov.day3.service.BasketService;

public class Main {

    public static void main(String[] args) {
        BallCreator ballCreator = new BallCreator();
        BasketCreator basketCreator = new BasketCreator();
        try {
            Ball ball = ballCreator.createBall(Color.BLACK, Size.S, 15);
            Basket basket = basketCreator.createBasket(35);
            System.out.println(basket.getCapacity());
            BasketService basketService = new BasketService();
            System.out.println(basketService.countBallsByColor(basket, Color.WHITE));
            System.out.println(basketService.calculateBallsWeight(basket));
        } catch (IncorrectDataException e) {
            e.printStackTrace();
        }
    }
}
