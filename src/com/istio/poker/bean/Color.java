package com.istio.poker.bean;

public enum Color {

    SPADE("♠", 4), HEART("♥", 3), CLUB("♣", 2), DIAMOND("♦", 1);

    private String color;
    private int weight;

    private Color(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public int compare (Color c) {
        return this.weight - c.weight;
    }

    @Override
    public String toString () {
        return this.color;
    }
}
