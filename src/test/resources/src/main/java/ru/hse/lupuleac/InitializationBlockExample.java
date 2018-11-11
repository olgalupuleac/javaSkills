package ru.hse.lupuleac;

public class InitializationBlockExample {
    private int a;
    {
        a = 6;
    }

    private static int b;
    static {
        b = 7;
    }
}
