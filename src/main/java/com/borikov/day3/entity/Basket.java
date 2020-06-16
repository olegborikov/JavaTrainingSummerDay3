package com.borikov.day3.entity;

import java.util.ArrayList;

public class Basket {
    private static final int MAX_SIZE = 200;
    private static final int MIN_SIZE = 10;

    private double capacity;
    private ArrayList<Ball> balls;

    public Basket(double capacity, ArrayList<Ball> balls) {
        this.capacity = capacity;
        this.balls = balls;
    }

    public double getCapacity() {
        return capacity;
    }

    public ArrayList<Ball> getBalls() {
        return (ArrayList<Ball>) balls.clone();
    }

    public void setBalls(ArrayList<Ball> balls) {
        this.balls = balls;
    }

    public boolean add(Ball ball) {
        return balls.add(ball);
    }

    public boolean remove(Ball ball) {
        return balls.remove(ball);
    }
}
