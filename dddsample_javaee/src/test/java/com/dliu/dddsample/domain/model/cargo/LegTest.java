package com.dliu.dddsample.domain.model.cargo;

import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Created by IntelliJ IDEA.
 */
public class LegTest {
    @Test
    public void testConstructor() {
        try {
            new Leg(null, null, null, null, null);
            fail("Should not accept null arguments");
        } catch (IllegalArgumentException e) {}
//        final Leg leg = new Leg()
    }


}
