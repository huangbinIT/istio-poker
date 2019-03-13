package com.istio.poker.bean;

public enum Point {
    AZ("A", 13), KING("K", 12), QUEEN("Q", 11), JACK("J", 10), TEN("10", 9), NIEN("9", 8), EIGHT("8", 7), SEVEN("7", 6),
    SIX("6", 5), FIVE("5", 4), FOUR("4", 3), THREE("3", 2), TWO("2", 1);

    private String point;
    private int weight;

    private Point(String point, int weight) {
        this.point = point;
        this.weight = weight;
    }

    public int compare (Point p) {
        return this.weight - p.weight;
    }

    public int getWeight () {
        return this.weight;
    }
    
    @Override
    public String toString () {
        return this.point;
    }
}
