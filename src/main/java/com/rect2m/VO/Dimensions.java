package com.rect2m.VO;

public final class Dimensions {
    private final double length;
    private final double width;
    private final double height;

    public Dimensions(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double calculateVolume() {
        return length * width * height;
    }

    public boolean fitsMaxDimensions(Dimensions maxDimensions) {
        return length <= maxDimensions.length && width <= maxDimensions.width && height <= maxDimensions.height;
    }
}

