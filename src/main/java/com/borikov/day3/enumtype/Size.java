package com.borikov.day3.enumtype;

public enum Size {
    XXS(1),
    XS(5),
    S(10),
    M(15),
    L(20),
    XL(25),
    XXL(30);

    private final int volume;

    Size(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }
}
