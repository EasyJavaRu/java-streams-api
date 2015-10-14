package ru.easyjava.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * EXample of Stream API collection operations.
 */
public class Collections {
    /**
     * Sample data holder.
     */
    private static final Collection<User> DATA;

    static {
        DATA = new ArrayList<>();
        DATA.add(new User("TEST", 1));
        DATA.add(new User("LOGIN", 2));
        DATA.add(new User("EXAMPLE", 2 + 1));
    }

    /**
     * Example of collection transform.
     * @return collection of logins.
     */
    public final Collection<String> getLogins() {
        return DATA
                .stream()
                .map(User::getLogin)
                .collect(Collectors.toList());
    }

    /**
     * Example of collection filtering.
     * @return collections of users
     * with access level higher then 1
     */
    public final Collection<String> highLevelLogins() {
        return DATA
                .stream()
                .filter(u -> u.getAccessLevel() > 1)
                .map(User::getLogin)
                .collect(Collectors.toSet());
    }
}
