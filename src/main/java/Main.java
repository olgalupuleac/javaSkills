/*import java.math.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.*;
import java.nio.charset.*;
import java.util.function.*;
import java.util.logging.*;
public class Main {
    public interface Message<T> {
        String getTo();

        T getContent();
    }
    public static class MailMessage implements Message<String> {

        private String from;
        private String to;
        private String content;

        public MailMessage(String from, String to, String content) {
            this.from = from;
            this.to = to;
            this.content = content;
        }

        public String getFrom() {
            return from;
        }

        public String getTo() {
            return to;
        }

        public String getContent() {
            return content;
        }
    }

    public static class Salary implements Message<Integer> {
        private String from;
        private String to;
        private int salary;

        public Salary(String from, String to, int salary) {
            this.from = from;
            this.to = to;
            this.salary = salary;
        }

        public String getFrom() {
            return from;
        }

        public String getTo() {
            return to;
        }

        @Override
        public Integer getContent() {
            return getSalary();
        }

        public int getSalary() {
            return salary;
        }
    }

    public static class MailService<T> implements Consumer<Message<T>> {
        Map<String, List<T>> map = new HashMap<>();

        @Override
        public void accept(Message<T> o) {
            map.computeIfAbsent(o.getTo(), s -> new ArrayList<>()).add(o.getContent());
        }

        public Map<String, List<T>> getMailBox() {
            return map;
        }
    }

    public interface Map<K, V extends List> extends java.util.Map<K, V> {
        V get(Object key);
    }

    public static class HashMap<K, V extends List> extends java.util.HashMap<K,V> implements Map<K,V>
    {
        @Override
        public V get(Object key) {
            V value = super.get(key);
            return super.getOrDefault(key, (V) Collections.emptyList());
        }
    }

}*/
/*
import java.math.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.*;
import java.nio.charset.*;
import java.util.function.*;
import java.util.logging.*;
class Pair <F, S> {
    private F first;
    private S second;

    private Pair(F f, S s) {
        first = f;
        second = s;
    }

    public static <F, S> Pair<F, S> of(F f, S s) {
        return new Pair<F, S>(f, s);
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    public boolean equals(Pair<? extends F, ? extends S>  p) {
        return p.getFirst().equals(first) && p.getSecond().equals(second);
    }

    public int hashCode() {
        return first.hashCode() + second.hashCode() * 1000;
    }

}
//363 57792 10
//363 AND step = 57792 AND attempt = 9*/
/*
public class Main {
    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double result = 0;
        double step = 1e-6;
        int qty = Math.abs( (b - a)/step);
        for (i = 0; i < qty; i++) {
            result += f.applyAsDouble(a + step)
        }
        result *= step;

        return result;
    }
}
*/
