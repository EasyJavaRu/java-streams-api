package ru.easyjava.java;

/**
 * Example object with fields.
 */
public class User {
    /**
     * Some string property.
     */
    private String login;

    /**
     * Some integer property.
     */
    private Integer accessLevel;

    /**
     * Year of birth.
     */
    private Integer yob;

    /**
     * Simple constructor.
     * @param l login value,
     * @param a access level value.
     */
    public User(final String l, final Integer a) {
        this.login = l;
        this.accessLevel = a;
        this.yob = Integer.MIN_VALUE;
    }

    /**
     * Full constructor.
     * @param l login value,
     * @param a access level value.
     * @param y year of birth value.
     */
    public User(final String l, final Integer a, final Integer y) {
        this.login = l;
        this.accessLevel = a;
        this.yob = y;
    }

    /**
     * accessLevel getter.
     * @return accessLevel value.
     */
    public final Integer getAccessLevel() {
        return accessLevel;
    }

    /**
     * accessLevel setter.
     * @param a new value.
     */
    public final void setAccessLevel(final Integer a) {
        this.accessLevel = a;
    }

    /**
     * Login getter.
     * @return login value.
     */
    public final String getLogin() {
        return login;
    }

    /**
     * Login setter.
     * @param l new value.
     */
    public final void setLogin(final String l) {
        this.login = l;
    }

    /**
     * YoB getter.
     * @return YoB value
     */
    public final Integer getYob() {
        return yob;
    }

    /**
     * YoB setter.
     * @param y new YoB value
     */
    public final void setYob(final Integer y) {
        this.yob = y;
    }
}
