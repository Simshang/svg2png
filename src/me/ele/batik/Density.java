package me.ele.batik;

public enum Density {

    SDPI(0.25f),
    LDPI(0.5f),
    MDPI(0.75f),
    StdDPI(1),
    HDPI(1.25f),
    XHDPI(1.5f),
    XXHDPI(1.75f),
    XXXHDPI(2);

    float multiplier;

    Density(float multiplier) {
        this.multiplier = multiplier;
    }

    float getMultiplier() {
        return multiplier;
    }
}
