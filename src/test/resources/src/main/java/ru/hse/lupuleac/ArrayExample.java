package ru.hse.lupuleac;

public class ArrayExample {
    int a[] = {33, 3, 4, 5};//declaration, instantiation and initialization

    private static void min(int arr[]) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (min > arr[i])
                min = arr[i];

        System.out.println(min);
    }

    public static void example(String args[]) {
        min(new int[]{10, 22, 44, 66});//passing anonymous array to method
    }
}