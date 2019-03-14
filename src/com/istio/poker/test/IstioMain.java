package com.istio.poker.test;

import java.util.concurrent.CyclicBarrier;

import com.istio.poker.adjude.Adjudicator;
import com.istio.poker.play.Player;

public class IstioMain {

    public static void main (String[] args) {
        Adjudicator adjudicator = new Adjudicator(3);
        CyclicBarrier barrier = new CyclicBarrier(3);
        Player player1 = new Player(barrier, "Tim");
        adjudicator.addPlayer(player1);
        Player player2 = new Player(barrier, "James");
        adjudicator.addPlayer(player2);
        Player player3 = new Player(barrier, "John");
        adjudicator.addPlayer(player3);

        new Thread(player1).start();
        new Thread(player2).start();
        new Thread(player3).start();
        new Thread(adjudicator).start();
    }

}
