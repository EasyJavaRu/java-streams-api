package ru.easyjava.java;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Streams demonstration.
 */
public class Lambdas {
    /**
     * Source data to process.
     */
    private static final List<String> LONG_WELCOME = Arrays.asList(
            "Hello",
            "and",
            "welcome",
            "to",
            "the",
            "wonderful",
            "world",
            "of",
            "java",
            "8");

    /**
     * We will select words of that length.
     */
    private static final Integer WORD_LENGTH = 5;

    /**
     * Hello world in a modern way.
     * @return "Hello, world"
     */
    public final String greet() {
        return LONG_WELCOME
                .stream()
                .filter(s -> s.length() == WORD_LENGTH)
                .collect(Collectors.joining(", "));
    }

    /**
     * Old fashioned hello world.
     * @return "Hello, world"
     */
    public final String oldSchoolGreet() {
        List<String> result = new ArrayList<>();
        for (String s: LONG_WELCOME) {
            if (s.length() == WORD_LENGTH) {
                result.add(s);
            }
        }

        Iterator<String> it = result.iterator();
        StringBuilder buf = new StringBuilder();
        buf.append(it.next());
        while (it.hasNext()) {
            buf.append(", ");
            buf.append(it.next());
        }

        return buf.toString();
    }

    /**
     * anyMatch() example.
     * @return true
     */
    public final boolean haveHello() {
        return LONG_WELCOME.stream().anyMatch(s->s.equals("Hello"));
    }

    /**
     * noneMatch() example.
     * @return true
     */
    public final boolean haveNoCrocodiles() {
        return LONG_WELCOME.stream().noneMatch(s->s.equals("crocodile"));
    }

    /**
     * allMatch() example
     * @return true
     */
    public final boolean allStringsNotEmpty() {
        return LONG_WELCOME.stream().allMatch(s->!s.isEmpty());
    }
}
