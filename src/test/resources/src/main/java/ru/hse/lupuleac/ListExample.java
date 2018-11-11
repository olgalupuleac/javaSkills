package ru.hse.lupuleac;

import java.util.*;

public class ListExample {
    public static void example1() {
        ArrayList<String> al = new ArrayList<String>();
        al.add("Amit");
        al.add("Vijay");
        al.add("Kumar");
        al.add(1, "Sachin");
        System.out.println("Element at 2nd position: " + al.get(2));
        for (String s : al) {
            System.out.println(s);
        }
    }

    public static void example2() {
        List<String> listA = new ArrayList<>();
        List<String> listB = new LinkedList<>();
        List<String> listC = new Vector<>();
        List listD = new Stack();
        listA.add("element 1");
        listB.add(0, "element 4");
        listC.addAll(listA);
    }
}
