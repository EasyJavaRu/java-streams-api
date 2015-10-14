package ru.easyjava.java;

import java.util.EnumSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MedianCollector implements Collector<Integer, TreeSet<Integer>, Integer> {
    @Override
    public Supplier<TreeSet<Integer>> supplier() {
        return TreeSet<Integer>::new;
    }

    @Override
    public BiConsumer<TreeSet<Integer>, Integer> accumulator() {
        return TreeSet::add;
    }

    @Override
    public BinaryOperator<TreeSet<Integer>> combiner() {
        return (l, r) -> { l.addAll(r); return l; };
    }

    @Override
    public Function<TreeSet<Integer>, Integer> finisher() {
        return s -> {
            long size = s.size();
            if (size%2==0) {
                return new Double(s
                        .stream()
                        .skip(size % 2+2)
                        .limit(2)
                        .mapToInt(i->i)
                        .average()
                        .getAsDouble())
                        .intValue();
            }
            return s
                    .stream()
                    .skip(size % 2+2)
                    .findFirst()
                    .get();
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.CONCURRENT);
    }
}
