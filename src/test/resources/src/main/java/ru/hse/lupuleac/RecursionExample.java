package ru.hse.lupuleac;

public class RecursionExample {
    public int factorial(int n) {
        if(n == 0) {
            return 1;
        }
        return n * factorial(n);
    }
}
