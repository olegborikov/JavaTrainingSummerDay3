package com.borikov.day3.entity;

public enum Material {
    CONCRETE(2.3),
    PAPER(0.7),
    COPPER(8.9),
    SILVER(10.5),
    ALUMINIUM(2.7),
    IRON(7.8),
    RUBBER(1.2);

    private double densityOfMaterial;

    Material(double densityOfMaterial) {
        this.densityOfMaterial = densityOfMaterial;
    }

    public double getDensityOfMaterial() {
        return densityOfMaterial;
    }
}
