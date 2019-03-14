package com.istio.poker.play;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import com.istio.poker.adjude.Adjudicator;
import com.istio.poker.bean.PokersEntity;

public class Player implements Runnable {
    private String name;
    private Adjudicator adjudicator;
    private PokersEntity entity;
    private boolean saw = false;
    private CyclicBarrier barrier;

    public Player(CyclicBarrier barrier, String name) {
        this.barrier = barrier;
        this.name = name;
    }

    @Override
    public void run () {
        while (true) {
            if (adjudicator.isCanShow() && !saw) {
                this.show();
                try {
                    this.barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public void setAdjudicator (Adjudicator adjudicator) {
        this.adjudicator = adjudicator;
    }

    public void setPokersEntity (PokersEntity entity) {
        this.entity = entity;
        this.saw = false;
        System.out.println("Player " + this.name + " has got the pokers!");
    }

    public void show () {
        this.entity.openCards();
        System.out.println(this.name + " :: " + this.entity);
        this.saw = true;
        adjudicator.getLatch().countDown();
    }

}
