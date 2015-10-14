package ru.easyjava.java;

import java.util.EnumSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Example of custom collectors, that calculates median value of a stream.
 */
public class MedianCollector
        implements Collector<Integer, TreeSet<Integer>, Integer> {
    @Override
    public final Supplier<TreeSet<Integer>> supplier() {
        return TreeSet<Integer>::new;
    }

    @Override
    public final BiConsumer<TreeSet<Integer>, Integer> accumulator() {
        return TreeSet::add;
    }

    @Override
    public final BinaryOperator<TreeSet<Integer>> combiner() {
        return (l, r) -> { l.addAll(r); return l; };
    }

    @Override
    public final Function<TreeSet<Integer>, Integer> finisher() {
        return s -> {
            long size = s.size();
            if (size % 2 == 0) {
                return Double.valueOf(s
                        .stream()
                        .skip(size % 2 + 2)
                        .limit(2)
                        .mapToInt(i->i)
                        .average()
                        .getAsDouble())
                        .intValue();
            }
            return s
                    .stream()
                    .skip(size % 2 + 2)
                    .findFirst()
                    .get();
        };
    }

    @Override
    public final Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.CONCURRENT);
    }
}
