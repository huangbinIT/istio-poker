package com.istio.poker.bean;

import com.istio.poker.comparator.PokersUtils;

public class PokersEntity implements Comparable<Object> {
    private Poker[] pokers;
    private Type type;

    private PokersEntity(Poker[] pokers) {
        this.pokers = pokers;
    }

    public void openCards () {
        sortByPoint();
        this.type = PokersUtils.getType(this.pokers);
    }

    public Type getType () {
        return this.type;
    }

    public static PokersEntity createEntity () {
        Poker poker1 = Pokers.getPoker();
        Poker poker2 = Pokers.getPoker();
        Poker poker3 = Pokers.getPoker();

        return new PokersEntity(new Poker[] { poker1, poker2, poker3 });
    }

    private void sortByPoint () {
        Poker maxPoker = pokers[0];
        Poker midPoker = pokers[1];
        Poker minPoker = pokers[2];

        int max = pokers[0].getPoint().getWeight();
        int mid = pokers[1].getPoint().getWeight();
        int min = pokers[2].getPoint().getWeight();

        Poker[] sortedPokers = null;

        if (max > mid && max > min) {
            if (mid > min) {// max > mid > min
                sortedPokers = new Poker[] { maxPoker, midPoker, minPoker };
            } else {// max > min > mid
                sortedPokers = new Poker[] { maxPoker, minPoker, midPoker };
            }
        } else if (max > mid && max < min) { // min > max > mid
            sortedPokers = new Poker[] { minPoker, maxPoker, midPoker };
        } else if (max < mid && max > min) { // mid > max > min
            sortedPokers = new Poker[] { midPoker, maxPoker, minPoker };
        } else if (max < mid && max < min) {
            if (mid > min) { // mid > min > max
                sortedPokers = new Poker[] { midPoker, minPoker, maxPoker };
            } else { // min > mid > max
                sortedPokers = new Poker[] { minPoker, midPoker, maxPoker };
            }
        } else if (max == mid || max == min || mid == min) {
            if (max == mid && max == min) { // max = mid = min
                sortedPokers = new Poker[] { maxPoker, midPoker, minPoker };
            } else if (max == mid) {
                if (max > min) { // max = mid > min
                    sortedPokers = new Poker[] { maxPoker, midPoker, minPoker };
                } else { // min > max = mid
                    sortedPokers = new Poker[] { minPoker, maxPoker, midPoker };
                }
            } else if (max == min) {
                if (max > mid) { // max = min > mid
                    sortedPokers = new Poker[] { maxPoker, minPoker, midPoker };
                } else { // mid > max = min
                    sortedPokers = new Poker[] { midPoker, maxPoker, minPoker };
                }
            } else { // max > min = mid
                if (max > mid) {
                    sortedPokers = new Poker[] { maxPoker, midPoker, minPoker };
                } else { // min = mid > max
                    sortedPokers = new Poker[] { midPoker, minPoker, maxPoker };
                }
            }
        }

        this.pokers = sortedPokers;
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

    @Override
    public String toString () {
        return "[ " + pokers[0].toString() + " " + pokers[1].toString() + " " + pokers[2].toString() + " " + " ] --> "
                + this.type;
    }

}
