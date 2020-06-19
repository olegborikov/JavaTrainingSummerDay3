package com.borikov.day3.entity;

import com.borikov.day3.enumtype.Color;
import com.borikov.day3.enumtype.Size;

public class Ball {
    private final Color color;
    private final Size size;
    private final double weight;

    public Ball(Color color, Size size, double weight) {
        this.color = color;
        this.size = size;
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public Size getSize() {
        return size;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        if (weight != ball.weight) {
            return false;
        }
        if (color == null) {
            if (ball.color != null) {
                return false;
            }
        } else {
            if (!color.equals(ball.color)) {
                return false;
            }
        }
        if (size == null) {
            if (ball.size != null) {
                return false;
            }
        } else {
            if (!size.equals(ball.size)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return (int) (31 * weight + ((color != null) ? color.hashCode() : 0)
                + ((size != null) ? size.hashCode() : 0));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ball{");
        sb.append("color=").append(color);
        sb.append(", size=").append(size);
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }
}
