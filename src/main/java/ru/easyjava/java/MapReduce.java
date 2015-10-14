package ru.easyjava.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Example of map/reduce operations
 * with Stream API.
 */
public class MapReduce {
    /**
     * Sample data holder.
     */
    private static final Collection<User> DATA;

    /**
     * Year 1970.
     */
    private static final Integer YEAR_1970 = 1970;
    /**
     * Year 1980.
     */
    private static final Integer YEAR_1980 = 1980;
    /**
     * Year 1990.
     */
    private static final Integer YEAR_1990 = 1990;

    /**
     * Current year is 2015 and it will always be 2015 :).
     */
    private static final Integer CURRENT_YEAR = 2015;

    static {
        DATA = new ArrayList<>();
        DATA.add(new User("TEST", 1, YEAR_1980));
        DATA.add(new User("LOGIN", 2, YEAR_1970));
        DATA.add(new User("EXAMPLE", 2 + 1, YEAR_1990));
    }

    /**
     * Removes duplicate symbols from string.
     * @param s string to process
     * @return deduplicated string.
     */
    static String removeDuplicates(final String s) {
        StringBuilder noDupes = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String si = s.substring(i, i + 1);
            if (noDupes.indexOf(si) == -1) {
                noDupes.append(si);
            }
        }
        return noDupes.toString();
    }

    /**
     * Example of build-in reduce function.
     * @return Average age.
     */
    public final Double averageAge() {
        return DATA
                .stream()
                .mapToInt(u -> CURRENT_YEAR - u.getYob())
                .average()
                .getAsDouble();
    }

    /**
     * Example of custom reduce function.
     * @return string with used symbols.
     */
    public final String getCommonSymbols() {
        return DATA
                .stream()
                .map(User::getLogin)
                .reduce("", (p, c) -> removeDuplicates(p + c));
    }

    /**
     * Example of long for of joining collector.
     * @return joined logins string with prefix.
     */
    public final String logins() {
        return DATA
                .stream()
                .map(User::getLogin)
                .collect(Collectors.joining(",", "User names: '", "'"));
    }

    /**
     * Example of generic collection collector.
     * @return ArrayList with logins.
     */
    public final Collection<String> loginsCollections() {
        return DATA
                .stream()
                .map(User::getLogin)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Example of set collector.
     * @return set with logins obly.
     */
    public final Set<String> loginsSet() {
        return DATA
                .stream()
                .map(User::getLogin)
                .collect(Collectors.toSet());
    }

    /**
     * Example of map collector.
     * @return inverted DATA map.
     */
    public final Map<Integer, String> yobLoginsMap() {
        return DATA
                .stream()
                .collect(Collectors.toMap(User::getYob, User::getLogin));
    }

    /**
     * Example of multiple key map collector.
     * @return Logins, grouped by year.
     */
    public final Map<Integer, String> yobLoginsMultiKeys() {
        Collection<User> local = new ArrayList<>(DATA);
        local.add(new User("OLD", 2, YEAR_1970));
        local.add(new User("YOUNG", 1, YEAR_1990));
        return local
                .stream()
                .collect(Collectors.toMap(
                        User::getYob,
                        User::getLogin,
                        (s, a) -> s + ", " + a));
    }
}
