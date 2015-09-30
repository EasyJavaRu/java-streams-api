package ru.easyjava.java;

import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MapReduceTest {
    MapReduce testedObject = new MapReduce();

    @Test
    public void testAverage() {
        assertThat(testedObject.averageAge(), closeTo(35,0.1));
    }

    @Test
    public void testCommonSymbols() {
        assertThat(testedObject.getCommonSymbols(), is("TESLOGINXAMP"));
    }

    @Test
    public  void testLogins() {
        assertThat(testedObject.logins(), is("User names: 'TEST,LOGIN,EXAMPLE'"));
    }

    @Test
    public void testLoginCollections() {
        assertTrue(testedObject.loginsCollections().containsAll(testedObject.loginsSet()));
    }

    @Test
    public void testYobLogin() {
        assertThat(testedObject.yobLoginsMap().get(1980), is("TEST"));
    }

    @Test
    public void testYobMultiLogin() {
        assertThat(testedObject.yobLoginsMultiKeys().get(1970), is("LOGIN, OLD"));
        assertThat(testedObject.yobLoginsMultiKeys().get(1990), is("EXAMPLE, YOUNG"));
    }
}