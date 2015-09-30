package ru.easyjava.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class Collections {
    private final static Collection<User> data;

    static {
        data = new ArrayList<>();
        data.add(new User("TEST",1));
        data.add(new User("LOGIN",2));
        data.add(new User("EXAMPLE",3));
    }

    public Collection<String> getLogins() {
        return data
                .stream()
                .map(User::getLogin)
                .collect(Collectors.toList());
    }

    public Collection<String> highLevelLogins() {
        return data
                .stream()
                .filter(u -> u.getAccessLevel() > 1)
                .map(User::getLogin)
                .collect(Collectors.toSet());
    }
}
