package com.my.training.util;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MoneyTestRound {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"100.012345", new BigDecimal("100.01")},
                {"100.056", new BigDecimal("100.06")},
                {"100.054", new BigDecimal("100.05")},
                {"100.050", new BigDecimal("100.05")},
                {"1", new BigDecimal("1.00")}
        });
    }

    private String input;

    private BigDecimal expect;

    public MoneyTestRound(final String input, final BigDecimal expect) {
        this.input = input;
        this.expect = expect;
    }

    @Test
    public void roundBigDecimal_returnCorrectValue() {
        final BigDecimal bigDecimal = new BigDecimal(input);
        final BigDecimal actual = Money.roundBigDecimal(bigDecimal);
        assertEquals(expect, actual);
    }

}