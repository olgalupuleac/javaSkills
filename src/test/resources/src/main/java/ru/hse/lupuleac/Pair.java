package ru.hse.lupuleac;


import java.util.NoSuchElementException;

class Pair<T,U> {

    private final T first;
    private final U second;


    public T getFirst() {
        if (first == null) {
            throw new NoSuchElementException("No value present");
        }
        return first;
    }
    public U getSecond() {
        if (second == null) {
            throw new NoSuchElementException("No value present");
        }
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair<?, ?> pair = (Pair<?, ?>) o;

        if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
        return !(second != null ? !second.equals(pair.second) : pair.second != null);

    }

    @Override
    public int hashCode() {
        double res = 13;
        int f = 19;
        int s = 37;
        if (this.first != null){
            f = this.first.toString().length();
        }
        if (this.second != null){
            s = this.second.toString().length();
        }
        res = 11 * (f + s) + res * 23;
        return (int)res;
    }

    private Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public static <T,U> Pair<T,U> of(T first, U second) {
        return new Pair<>(first, second);
    }
}

