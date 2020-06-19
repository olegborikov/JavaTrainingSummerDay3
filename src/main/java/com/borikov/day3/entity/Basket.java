package com.borikov.day3.entity;

import com.borikov.day3.enumtype.Size;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private final double capacity;
    private ArrayList<Ball> balls;

    public Basket(double capacity) {
        this.capacity = capacity;
        this.balls = new ArrayList<>();
    }

    public double getCapacity() {
        return capacity;
    }

    public List<Ball> getBalls() {
        return (List<Ball>) balls.clone();
    }

    public boolean add(Ball ball) {
        boolean result = false;
        if (ball != null && calculateBusyCapacity()
                + ball.getSize().getVolume() <= capacity) {
            result = balls.add(ball);
        }
        return result;
    }

    public boolean remove(Ball ball) {
        return balls.remove(ball);
    }

    public Ball get(int index) {
        return balls.get(index);
    }

    public double calculateBusyCapacity() {
        double busyCapacity = 0;
        for (int i = 0; i < balls.size(); i++) {
            Size size = balls.get(i).getSize();
            busyCapacity += size.getVolume();
        }
        return busyCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Basket basket = (Basket) o;
        if (capacity != basket.capacity) {
            return false;
        }
        if (balls == null) {
            if (basket.balls != null) {
                return false;
            }
        } else {
            if (!balls.equals(basket.balls)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return (int) (31 * capacity + ((balls != null) ? balls.hashCode() : 0));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Basket{");
        sb.append("capacity=").append(capacity);
        sb.append(", balls=").append(balls);
        sb.append('}');
        return sb.toString();
    }
}
