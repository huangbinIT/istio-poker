package com.istio.poker.bean;

public enum Type {
    BAO_ZI("BAOZI", 6), TONG_HUA_SHUN("TONGHUASHUN", 5), TONG_HUA("TONGHUA", 4), SHUN_ZI("SHUNZI", 3),
    DUI_ZI("DUIZI", 2), SAN_PAI("SANPAI", 1);

    private String type;
    private int weight;

    private Type(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    public int compare (Type type) {
        return this.weight - type.weight;
    }
}
