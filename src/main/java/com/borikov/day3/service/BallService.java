package com.borikov.day3.service;

import com.borikov.day3.entity.Ball;

import static java.lang.Math.*;

public class BallService {
    public double calculateBallVolume(Ball ball) {
        return (4. / 3) * PI * pow(ball.getRadius(), 3);
    }

    public double calculateBallWeight(Ball ball) {
        double densityOfMaterial = ball.getMaterial().getDensityOfMaterial();
        return calculateBallVolume(ball) * densityOfMaterial;
    }
}
