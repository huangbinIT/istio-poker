package com.istio.poker.adjude;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

import com.istio.poker.bean.Pokers;
import com.istio.poker.bean.PokersEntity;
import com.istio.poker.play.Player;

public class Adjudicator implements Runnable {
    private Pokers pokers;
    private PokersEntity entity;
    private Object entityLock = new Object();
    private boolean playerReady = false;
    private boolean pokersReady = false;
    private int playerNum;
    private CountDownLatch latch;
    private Object latchLock = new Object();
    private AtomicBoolean canshow = new AtomicBoolean(false);

    private List<Player> players;
    private LinkedBlockingQueue<Player> activePlayers = new LinkedBlockingQueue<Player>();

    public Adjudicator(int playerNum) {
        this.playerNum = playerNum;
        resetLatch();
        wash();
        System.out.println("Adjudicator is ready!");
    }

    public void addPlayer (Player player) {
        if (this.players == null) {
            this.players = new ArrayList<Player>();
        }
        if (this.playerReady) {
            throw new RuntimeException("The player queue was already filled up!");
        }
        this.players.add(player);
        player.setAdjudicator(this);
    }

    public void wash () {
        this.pokers = new Pokers();
        this.pokersReady = true;
        System.out.println("Pokers was washed!");
    }

    @Override
    public void run () {
        while (true) {
            playersReady();
            while (this.playerReady && this.pokersReady) {
                deal();
                dispatch();
            }
            changeShow(true);
            System.out.println("Player show the pokers......");

            await();

            System.out.println("The end!");

            resetLatch();
        }
    }

    private void await () {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.canshow.getAndSet(false);
    }

    private void changeShow (boolean isShow) {
        this.canshow.getAndSet(isShow);
    }

    private void playersReady () {
        activePlayers.addAll(this.players);
        this.playerReady = true;
        System.out.println("Player is readying!");
    }

    public void resetLatch () {
        synchronized (latchLock) {
            this.latch = new CountDownLatch(this.playerNum);
        }
    }

    public CountDownLatch getLatch () {
        synchronized (latchLock) {
            return this.latch;
        }
    }

    private void dispatch () {
        if (this.playerReady) {
            Player player = this.activePlayers.poll();
            player.setPokersEntity(entity);
        }

        if (this.activePlayers.isEmpty()) {
            this.playerReady = false;
        }
    }

    public void deal () {
        synchronized (entityLock) {
            this.entity = PokersEntity.createEntity();
            System.out.println("deal ---> " + this.entity);
        }
    }

    public boolean isCanShow () {
        return this.canshow.get();
    }

}
