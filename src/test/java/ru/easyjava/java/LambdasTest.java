package ru.easyjava.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyString;
import static org.junit.Assert.*;

public class LambdasTest {
    private static final String EXPECTED = "Hello, world";

    private Lambdas testedObject = new Lambdas();

    @Test
    public void testGreet() throws Exception {
        assertThat(testedObject.greet(), is(EXPECTED));
    }

    @Test
    public void testOldSchooldGreet() throws Exception {
        assertThat(testedObject.oldSchoolGreet(), is(EXPECTED));
    }

    @Test(expected = IllegalStateException.class)
         public void testClosedStream() {
        Stream<String> s = Arrays.stream(new String[]{"TEST", "STREAM"});
        s.count();

        s.noneMatch(String::isEmpty);
    }

    @Test
    public void testHaveHello() {
        assertTrue(testedObject.haveHello());
    }

    @Test
    public void testHaveNoCrocodile() {
        assertTrue(testedObject.haveNoCrocodiles());
    }

    @Test
    public void testAllNotEmpty() {
        assertTrue(testedObject.allStringsNotEmpty());
    }

    @Test
    public void testMedianStringLength() {
        assertThat(testedObject.medianStringLength(), is(4));
    }
}