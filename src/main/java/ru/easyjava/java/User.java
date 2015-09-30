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
     * @param login login value,
     * @param accessLevel access level value.
     */
    public User(final String login, final Integer accessLevel) {
        this.login = login;
        this.accessLevel = accessLevel;
        this.yob=Integer.MIN_VALUE;
    }

    /**
     * Full constructor.
     * @param login login value,
     * @param accessLevel access level value.
     */
    public User(final String login, final Integer accessLevel, final Integer yob) {
        this.login = login;
        this.accessLevel = accessLevel;
        this.yob=yob;
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
     * @param login new value.
     */
    public final void setLogin(final String login) {
        this.login = login;
    }

    /**
     * YoB getter
     * @return YoB value
     */
    public final Integer getYob() {
        return yob;
    }

    /**
     * YoB setter
     * @param yob new YoB value
     */
    public final void setYob(final Integer yob) {
        this.yob = yob;
    }
}
