package com.istio.poker.comparator;

import com.istio.poker.bean.Poker;
import com.istio.poker.bean.Type;

public class PokersUtils {

    public static Type getType (Poker[] pokers) {
        if (isBaoZi(pokers)) {
            return Type.BAO_ZI;
        }

        if (isTongHuaShun(pokers)) {
            return Type.TONG_HUA_SHUN;
        }

        if (isTongHua(pokers)) {
            return Type.TONG_HUA;
        }

        if (isShunZi(pokers)) {
            return Type.SHUN_ZI;
        }

        if (isDuiZi(pokers)) {
            return Type.DUI_ZI;
        }

        return Type.SAN_PAI;
    }

    public static boolean isBaoZi (Poker[] pokers) {
        return pokers[0].equals(pokers[1]) && pokers[1].equals(pokers[2]);
    }

    public static boolean isTongHuaShun (Poker[] pokers) {
        return isTongHua(pokers) && isShunZi(pokers);
    }

    public static boolean isShunZi (Poker[] pokers) {
        return pokers[0].getPoint().compare(pokers[1].getPoint()) == 1
                && pokers[1].getPoint().compare(pokers[2].getPoint()) == 1;
    }

    public static boolean isTongHua (Poker[] pokers) {
        return pokers[0].getColor().equals(pokers[1].getColor()) && pokers[1].getColor().equals(pokers[2].getColor());
    }

    public static boolean isDuiZi (Poker[] pokers) {
        return pokers[0].getPoint().equals(pokers[1].getPoint()) || pokers[1].getPoint().equals(pokers[2].getPoint())
                || pokers[0].getPoint().equals(pokers[2].getPoint());
    }
}
