package ru.hse.lupuleac;

import java.util.ArrayList;
import java.util.List;

public class BoxingAndUnboxingExample {
    public static void example1() {
        List<Integer> li = new ArrayList<>();
        for (int i = 1; i < 50; i += 2)
            li.add(i);
    }

    public static int sumEven(List<Integer> li) {
        int sum = 0;
        for (Integer i : li)
            if (i % 2 == 0)
                sum += i;
        return sum;
    }

    public static int absoluteValue(int i) {
        return (i < 0) ? -i : i;
    }

    public static void unboxing() {
        Integer i = new Integer(-8);

        // 1. Unboxing through method invocation
        int absVal = absoluteValue(i);
        System.out.println("absolute value of " + i + " = " + absVal);

        List<Double> ld = new ArrayList<>();
        ld.add(3.1416);    // Π is autoboxed through method invocation.

        // 2. Unboxing through assignment
        double pi = ld.get(0);
        System.out.println("pi = " + pi);
    }
}
