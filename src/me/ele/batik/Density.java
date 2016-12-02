package me.ele.batik;

public enum Density {
    // times of DPI

    SDPI(0.125f),
    MDPI(0.25f),
    LDPI(0.5f),
    StdDPI(1),
    HDPI(2),
    XHDPI(4);

    /*
    StdDPI(1);
    XLDPI(0.64f),
    XXHDPI(1.65f),
    XXXHDPI(1.85f),
    XXXXHDPI(2);

    */

    float multiplier;

    Density(float multiplier) {
        this.multiplier = multiplier;
    }

    float getMultiplier() {
        return multiplier;
    }
}
