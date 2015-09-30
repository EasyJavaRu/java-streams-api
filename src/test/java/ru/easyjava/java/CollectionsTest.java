package ru.easyjava.java;

import org.junit.Test;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

public class CollectionsTest {
    private Collections testedObject = new Collections();

    @Test
    public void testLogins() {
        assertThat(testedObject.getLogins(), contains("TEST", "LOGIN", "EXAMPLE"));
    }

    @Test
    public void testHighLevelLogins() {
        assertThat(testedObject.highLevelLogins(), contains("LOGIN", "EXAMPLE"));
    }
}