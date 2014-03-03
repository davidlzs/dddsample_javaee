package com.dliu.dddsample.domain.model.location;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by IntelliJ IDEA.
 */
public class LocationTest {
    @Test
    public void testEquals() {
        assertEquals(Location.UNKNOWN, Location.UNKNOWN);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_whenUnLocodeIsNull() {
        new Location.Builder().withUnLocode(null).withName("Beijing").build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_whenNameIsNull() {
        new Location.Builder().withUnLocode(new UNLocode("CNBEJ")).withName(null).build();
    }

    @Test
    //@Ignore
    public void testConstructor_AllGood() {
        Location loc = new Location.Builder().withUnLocode(new UNLocode("CNBEJ")).withName("Beijing").build();
        assertEquals(new UNLocode("CNBEJ"), loc.getUNLocode());
    }
}
