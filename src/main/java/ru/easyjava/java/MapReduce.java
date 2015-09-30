package ru.easyjava.java;

import java.util.*;
import java.util.stream.Collectors;

public class MapReduce {
    private final static Collection<User> data;

    static {
        data = new ArrayList<>();
        data.add(new User("TEST",1, 1980));
        data.add(new User("LOGIN",2, 1970));
        data.add(new User("EXAMPLE",3, 1990));
    }

    static String removeDuplicates(String s) {
        StringBuilder noDupes = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String si = s.substring(i, i + 1);
            if (noDupes.indexOf(si) == -1) {
                noDupes.append(si);
            }
        }
        return noDupes.toString();
    }

    public Double averageAge() {
        Integer currentYear = 2015;
        return data
                .stream()
                .mapToInt(u -> currentYear - u.getYob())
                .average()
                .getAsDouble();
    }

    public String getCommonSymbols() {
        return data
                .stream()
                .map(User::getLogin)
                .reduce("", (p, c) -> removeDuplicates(p + c));
    }

    public String logins() {
        return data
                .stream()
                .map(User::getLogin)
                .collect(Collectors.joining(",", "User names: '", "'"));
    }

    public Collection<String> loginsCollections() {
        return data
                .stream()
                .map(User::getLogin)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Set<String> loginsSet() {
        return data
                .stream()
                .map(User::getLogin)
                .collect(Collectors.toSet());
    }

    public Map<Integer, String> yobLoginsMap() {
        return data
                .stream()
                .collect(Collectors.toMap(User::getYob, User::getLogin));
    }

    public Map<Integer, String> yobLoginsMultiKeys() {
        Collection<User> local = new ArrayList<>(data);
        local.add(new User("OLD", 2, 1970));
        local.add(new User("YOUNG", 1, 1990));
        return local
                .stream()
                .collect(Collectors.toMap(User::getYob, User::getLogin, (s, a) -> s + ", " + a));
    }
}
