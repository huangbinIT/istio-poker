package com.istio.poker.bean;

import com.istio.poker.comparator.PokersUtils;

public class PokersEntity implements Comparable<Object> {
    private Poker[] pokers;
    private Type type;

    public PokersEntity(Poker[] pokers) {
        this.pokers = sortByPoint(pokers);
        this.type = PokersUtils.getType(pokers);
    }

    private Poker[] sortByPoint (Poker[] pokers) {
        Poker maxPoker = pokers[0];
        Poker midPoker = pokers[1];
        Poker minPoker = pokers[2];

        int max = pokers[0].getPoint().getWeight();
        int mid = pokers[1].getPoint().getWeight();
        int min = pokers[2].getPoint().getWeight();

        Poker temp;
        if (max > mid && max < min) {
            temp = maxPoker;
            maxPoker = minPoker;
            minPoker = temp;
        } else if (max < mid && max > min) {
            temp = maxPoker;
            maxPoker = midPoker;
            midPoker = maxPoker;
        } else if (max < mid && max < min) {
            temp = maxPoker;
            if (mid > min) {
                maxPoker = midPoker;
                midPoker = minPoker;
                minPoker = temp;
            } else {
                maxPoker = minPoker;
                minPoker = maxPoker;
            }
        }

        return new Poker[] { maxPoker, midPoker, minPoker };
    }

    @Override
    public int compareTo (Object o) {
        PokersEntity entity = (PokersEntity) o;
        if (this.type.equals(entity.type)) {
            switch (this.type) {
                case BAO_ZI: {
                    return this.pokers[0].getPoint().compare(entity.pokers[0].getPoint());
                }
                case TONG_HUA_SHUN: {
                    if (this.pokers[0].getColor().compare(entity.pokers[0].getColor()) == 0) {
                        return this.pokers[0].getPoint().compare(entity.pokers[0].getPoint());
                    } else {
                        return this.pokers[0].getColor().compare(entity.pokers[0].getColor());
                    }
                }
                case TONG_HUA: {
                    if (this.pokers[0].getColor().compare(entity.pokers[0].getColor()) == 0) {
                        return this.pokers[0].getPoint().compare(entity.pokers[0].getPoint());
                    } else {
                        return this.pokers[0].getColor().compare(entity.pokers[0].getColor());
                    }
                }
                case SHUN_ZI: {
                    return this.pokers[0].getPoint().compare(entity.pokers[0].getPoint());
                }
                case DUI_ZI: {
                    return this.pokers[1].getPoint().compare(entity.pokers[1].getPoint());
                }
                default: {
                    return this.pokers[0].compareTo(entity.pokers[0]);
                }
            }
        } else {
            return this.type.compare(entity.type);
        }
    }

}
