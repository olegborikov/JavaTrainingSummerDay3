package com.borikov.day3.entity;

public class Ball {
    private static final double MAX_RADIUS = 3.5;
    private static final double MIN_RADIUS = 0.1;

    private static long id_generate = 0;
    private long ballId;
    private Color color;
    private double radius;
    private Material material;

    public Ball(Color color, double radius, Material material) {
        this.ballId = id_generate++;
        this.color = color;
        this.radius = radius;
        this.material = material;
    }

    public long getBallId() {
        return ballId;
    }

    public Color getColor() {
        return color;
    }

    public double getRadius() {
        return radius;
    }

    public Material getMaterial() {
        return material;
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
        if (radius != ball.radius) {
            return false;
        }
        if (ballId != ball.ballId) {
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
        if (material == null) {
            if (ball.material != null) {
                return false;
            }
        } else {
            if (!material.equals(ball.material)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return (int) (31 * radius + ballId
                + ((color != null) ? color.hashCode() : 0)
                + ((material != null) ? material.hashCode() : 0));
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ball{");
        sb.append("ballId=").append(ballId);
        sb.append(", color=").append(color);
        sb.append(", radius=").append(radius);
        sb.append(", material=").append(material);
        sb.append('}');
        return sb.toString();
    }
}
