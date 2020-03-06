package com.my.training.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Money {

    public static BigDecimal roundBigDecimal(final BigDecimal val) {
        return  val.setScale(2, RoundingMode.HALF_EVEN);
    }

    public static String stringBigDecimal(final BigDecimal val) {
        return  roundBigDecimal(val).toString();
    }
}
