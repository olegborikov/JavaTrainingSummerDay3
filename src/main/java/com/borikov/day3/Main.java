package com.borikov.day3;

import com.borikov.day3.entity.Ball;
import com.borikov.day3.entity.Basket;
import com.borikov.day3.entity.Color;
import com.borikov.day3.entity.Material;
import com.borikov.day3.exception.OutOfCapacityException;
import com.borikov.day3.service.BasketService;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Basket basket = new Basket(140, null);
        Ball redBall = new Ball(Color.RED,2, Material.PAPER);
        BasketService basketService = new BasketService();
        ArrayList<Ball> balls = new ArrayList<>();
        balls.add(redBall);
        try {
            System.out.println(basket.toString());
            basketService.addBall(basket, redBall);
            System.out.println(basket.toString());
        } catch (OutOfCapacityException e) {
            e.printStackTrace();
        }
    }
}
