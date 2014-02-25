package com.dliu.dddsample.domain.model.location;

import com.dliu.dddsample.domain.model.location.UNLocode;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by IntelliJ IDEA.
 */
public class UNLocodeTest {
    @Test
    public void testConstructor() {
        assertValid("AAAAA");
        assertValid("ABHKG");
        assertValid("ABHK2");
        assertInvalid("AB");
        assertInvalid("A");
        assertInvalid("ABHK1");
    }

    @Test
    public void testEquals() {
        UNLocode code1 = new UNLocode("cnhkg");
        UNLocode code2 = new UNLocode("CNHKG");
        assertEquals(code1, code2);
    }

    private void assertInvalid(String ulocode) {
        try {
            new UNLocode(ulocode);
            fail("Expected exception");
        } catch (IllegalArgumentException expected) {
        }
    }

    private void assertValid(String ulocode) {
        new UNLocode(ulocode);
    }
}
