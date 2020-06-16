package com.borikov.day3.service;

import com.borikov.day3.entity.Ball;
import com.borikov.day3.entity.Basket;
import com.borikov.day3.entity.Color;
import com.borikov.day3.exception.OutOfCapacityException;

import java.util.ArrayList;

public class BasketService {
    public void addBall(Basket basket, Ball newBall) throws OutOfCapacityException {
        ArrayList<Ball> balls = basket.getBalls();
        double busyCapacity = calculateCommonCapacity(balls);
        double newBallCapacity = calculateCommonCapacity(newBall);
        if (busyCapacity + newBallCapacity > basket.getCapacity()) {
            throw new OutOfCapacityException();
        }
        balls.add(newBall);
      //  basket.setBalls(balls);
    }

    public void addBalls(Basket basket, ArrayList<Ball> newBalls) throws OutOfCapacityException {
        ArrayList<Ball> balls = basket.getBalls();
        double busyCapacity = calculateCommonCapacity(balls);
        double newBallCapacity = calculateCommonCapacity(newBalls);
        if (busyCapacity + newBallCapacity > basket.getCapacity()) {
            throw new OutOfCapacityException();
        }
        balls.addAll(newBalls);
        basket.setBalls(balls);
    }

    public int getBallsByColor(Basket basket, Color color) {
        int amountOfBalls = 0;
        ArrayList<Ball> balls = basket.getBalls();
        amountOfBalls = (int) balls.stream().filter(ball -> ball.getColor() == color).count();
        return amountOfBalls;
    }

    public double calculateWeightOfBalls(Basket basket) {
        double weight = 0;
        BallService ballService = new BallService();
        ArrayList<Ball> balls = basket.getBalls();
        for(Ball ball : balls){
            weight += ballService.calculateBallWeight(ball);
        }
        return weight;
    }

    private double calculateCommonCapacity(ArrayList<Ball> balls) {
        BallService ballService = new BallService();
        double busyCapacity = 0;
        for (Ball ball : balls) {
            busyCapacity += ballService.calculateBallVolume(ball);
        }
        return busyCapacity;
    }

    private double calculateCommonCapacity(Ball ball) {
        BallService ballService = new BallService();
        return ballService.calculateBallVolume(ball);
    }
}
