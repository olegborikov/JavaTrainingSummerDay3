package com.borikov.day3.service;

import com.borikov.day3.entity.Ball;
import com.borikov.day3.entity.Basket;
import com.borikov.day3.enumtype.Color;

import java.util.List;

public class BasketService {
    public int countBallsByColor(Basket basket, Color color) {
        int amountOfBalls = 0;
        List<Ball> balls = basket.getBalls();
        for (int i = 0; i < balls.size(); i++) {
            Ball ball = balls.get(i);
            if (ball.getColor() == color) {
                amountOfBalls++;
            }
        }
        return amountOfBalls;
    }

    public double calculateBallsWeight(Basket basket) {
        double ballsWeight = 0;
        List<Ball> balls = basket.getBalls();
        for (int i = 0; i < balls.size(); i++) {
            Ball ball = balls.get(i);
            ballsWeight += ball.getWeight();
        }
        return ballsWeight;
    }
}
