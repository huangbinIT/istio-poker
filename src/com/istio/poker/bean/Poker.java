package com.istio.poker.bean;

public class Poker implements Comparable<Object> {
    private Color color;
    private Point point;

    public Poker(Color color, Point point) {
        this.color = color;
        this.point = point;
    }

    public Color getColor () {
        return color;
    }

    public void setColor (Color color) {
        this.color = color;
    }

    public Point getPoint () {
        return point;
    }

    public void setPoint (Point point) {
        this.point = point;
    }

    @Override
    public int compareTo (Object o) {
        Poker poker = (Poker) o;
        int colorResult = this.color.compareTo(poker.color);
        if (colorResult != 0) {
            return colorResult;
        } else {
            return this.point.compare(poker.point);
        }
    }

    @Override
    public boolean equals (Object o) {
        return this.compareTo(o) == 0;
    }

    @Override
    public String toString () {
        return this.color + ":" + this.point;
    }
}
