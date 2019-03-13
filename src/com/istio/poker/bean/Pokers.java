package com.istio.poker.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pokers {
    private static List<Poker> pokers = new ArrayList<Poker>(52);

    static {
        pokers.add(new Poker(Color.SPADE, Point.AZ));
        pokers.add(new Poker(Color.SPADE, Point.KING));
        pokers.add(new Poker(Color.SPADE, Point.QUEEN));
        pokers.add(new Poker(Color.SPADE, Point.JACK));
        pokers.add(new Poker(Color.SPADE, Point.TEN));
        pokers.add(new Poker(Color.SPADE, Point.NIEN));
        pokers.add(new Poker(Color.SPADE, Point.EIGHT));
        pokers.add(new Poker(Color.SPADE, Point.SEVEN));
        pokers.add(new Poker(Color.SPADE, Point.SIX));
        pokers.add(new Poker(Color.SPADE, Point.FIVE));
        pokers.add(new Poker(Color.SPADE, Point.FOUR));
        pokers.add(new Poker(Color.SPADE, Point.THREE));
        pokers.add(new Poker(Color.SPADE, Point.TWO));
        pokers.add(new Poker(Color.HEART, Point.AZ));
        pokers.add(new Poker(Color.HEART, Point.KING));
        pokers.add(new Poker(Color.HEART, Point.QUEEN));
        pokers.add(new Poker(Color.HEART, Point.JACK));
        pokers.add(new Poker(Color.HEART, Point.TEN));
        pokers.add(new Poker(Color.HEART, Point.NIEN));
        pokers.add(new Poker(Color.HEART, Point.EIGHT));
        pokers.add(new Poker(Color.HEART, Point.SEVEN));
        pokers.add(new Poker(Color.HEART, Point.SIX));
        pokers.add(new Poker(Color.HEART, Point.FIVE));
        pokers.add(new Poker(Color.HEART, Point.FOUR));
        pokers.add(new Poker(Color.HEART, Point.THREE));
        pokers.add(new Poker(Color.HEART, Point.TWO));
        pokers.add(new Poker(Color.CLUB, Point.AZ));
        pokers.add(new Poker(Color.CLUB, Point.KING));
        pokers.add(new Poker(Color.CLUB, Point.QUEEN));
        pokers.add(new Poker(Color.CLUB, Point.JACK));
        pokers.add(new Poker(Color.CLUB, Point.TEN));
        pokers.add(new Poker(Color.CLUB, Point.NIEN));
        pokers.add(new Poker(Color.CLUB, Point.EIGHT));
        pokers.add(new Poker(Color.CLUB, Point.SEVEN));
        pokers.add(new Poker(Color.CLUB, Point.SIX));
        pokers.add(new Poker(Color.CLUB, Point.FIVE));
        pokers.add(new Poker(Color.CLUB, Point.FOUR));
        pokers.add(new Poker(Color.CLUB, Point.THREE));
        pokers.add(new Poker(Color.CLUB, Point.TWO));
        pokers.add(new Poker(Color.DIAMOND, Point.AZ));
        pokers.add(new Poker(Color.DIAMOND, Point.KING));
        pokers.add(new Poker(Color.DIAMOND, Point.QUEEN));
        pokers.add(new Poker(Color.DIAMOND, Point.JACK));
        pokers.add(new Poker(Color.DIAMOND, Point.TEN));
        pokers.add(new Poker(Color.DIAMOND, Point.NIEN));
        pokers.add(new Poker(Color.DIAMOND, Point.EIGHT));
        pokers.add(new Poker(Color.DIAMOND, Point.SEVEN));
        pokers.add(new Poker(Color.DIAMOND, Point.SIX));
        pokers.add(new Poker(Color.DIAMOND, Point.FIVE));
        pokers.add(new Poker(Color.DIAMOND, Point.FOUR));
        pokers.add(new Poker(Color.DIAMOND, Point.THREE));
        pokers.add(new Poker(Color.DIAMOND, Point.TWO));
    }

    public static int getSize () {
        return pokers.size();
    }

    public static Poker getPoker () {
        int index = (int) (Math.random() * 1000 * 31);
        index = index & (52 - 1);
        return pokers.remove(index);
    }

}
