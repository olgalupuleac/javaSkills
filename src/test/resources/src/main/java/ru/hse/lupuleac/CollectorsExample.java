package ru.hse.lupuleac;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collectors.*;

public class CollectorsExample {
    public void example(List<String> givenList) {
        Set<String> result1 = givenList.stream()
                .collect(toSet());
        List<String> result2 = givenList.stream()
                .collect(toCollection(LinkedList::new));
        Map<String, Integer> result3 = givenList.stream()
                .collect(toMap(Function.identity(), String::length, (i1, i2) -> i1));
        List<String> result4 = givenList.stream()
                .collect(collectingAndThen(toList(), ImmutableList::copyOf));
        String result5 = givenList.stream()
                .collect(joining());
        Long result6 = givenList.stream()
                .collect(counting());
        DoubleSummaryStatistics result7 = givenList.stream()
                .collect(summarizingDouble(String::length));
        Optional<String> result8 = givenList.stream()
                .collect(maxBy(Comparator.naturalOrder()));

    }

    public class ImmutableSetCollector<T>
            implements Collector<T, ImmutableSet.Builder<T>, ImmutableSet<T>> {

        @Override
        public Supplier<ImmutableSet.Builder<T>> supplier() {
            return ImmutableSet::builder;
        }

        @Override
        public BiConsumer<ImmutableSet.Builder<T>, T> accumulator() {
            return ImmutableSet.Builder::add;
        }

        @Override
        public BinaryOperator<ImmutableSet.Builder<T>> combiner() {
            return (left, right) -> left.addAll(right.build());
        }

        @Override
        public Function<ImmutableSet.Builder<T>, ImmutableSet<T>> finisher() {
            return ImmutableSet.Builder::build;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Sets.immutableEnumSet(Characteristics.UNORDERED);
        }
    }
}
