package ru.hse.lupuleac;

import java.math.BigInteger;

public class BigIntegerExample {
    public static BigInteger factorial(int value) {
        BigInteger res = BigInteger.valueOf(1);
        for (int i = 1; i <= value; i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }
}
