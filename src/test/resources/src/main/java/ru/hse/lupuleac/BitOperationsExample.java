package ru.hse.lupuleac;

public class BitOperationsExample {
    public void example1() {
        int bitmask = 0x000F;
        int val = 0x2222;
        val |= bitmask;
        val &= bitmask;
        val ^= bitmask;
        val >>= 4;
        val <<= 4;
        val >>>= 6;
        boolean a = true | false;
        Boolean c = false;
        boolean b = a & a;
        Boolean d = b | c;
    }

    public void example2() {
        int a = 60;
        int b = 13;
        int c = a & b;
        c = a | b;
        c = a ^ b;
        c = a << 5;
        c = b >> 5;
        c = b >>> 1;
        c = ~a;
        boolean d = true;
        boolean f = false;
        f |= d;
    }
}
