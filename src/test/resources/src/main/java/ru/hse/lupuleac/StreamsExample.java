package ru.hse.lupuleac;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class StreamsExample {
    public static void example() {
        List list = new ArrayList();
        list.stream().filter(x -> true).count();
    }
}
