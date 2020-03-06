package com.my.training.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MoneyToStringTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                { new BigDecimal("100.012345"), "100.01"},
                {new BigDecimal("100.056"), "100.06"},
                {new BigDecimal("100.054"), "100.05"},
                {new BigDecimal("100.050"), "100.05"},
                {new BigDecimal("1"), "1.00"},
        });
    }

    private BigDecimal input;

    private String expect;

    public MoneyToStringTest(final BigDecimal input, final String expect) {
        this.input = input;
        this.expect = expect;
    }

    @Test
    public void stringBigDecimal_returnCorrectValue() {
        final String actual = Money.stringBigDecimal(input);
        assertEquals(expect, actual);
    }

}