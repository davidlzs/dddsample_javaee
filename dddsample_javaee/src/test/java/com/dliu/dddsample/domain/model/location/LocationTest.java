package com.dliu.dddsample.domain.model.location;

import com.dliu.dddsample.domain.model.location.Location;
import com.dliu.dddsample.domain.model.location.UNLocode;
import org.junit.Ignore;
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
        new Location(null, "Beijing");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_whenNameIsNull() {
        new Location(new UNLocode("CNBEJ"), null);
    }

    @Test
    //@Ignore
    public void testConstructor_AllGood() {
        Location loc = new Location(new UNLocode("CNBEJ"), "Beijing");
        assertEquals(new UNLocode("CNBEJ"), loc.getUNLocode());
    }
}
