package com.dliu.dddsample.domain.model.voyage;

import com.dliu.dddsample.domain.model.location.SampleLocation;
import org.junit.Test;

import java.util.Arrays;

import static com.dliu.dddsample.test.util.DateTestUtil.toDate;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by IntelliJ IDEA.
 */
public class VoyageTest {
    @Test
    public void testConstructor() {
        try {
            new Voyage(null, null);
            fail("Should not accept null arguments");
        } catch (IllegalArgumentException e) {}
        try {
            new Voyage(new VoyageNumber("123"), null);
            fail("Should not accept null argument");
        } catch (IllegalArgumentException e) {}
        try {
            new Voyage(null, Arrays.asList(new CarrierMovement(SampleLocation.BEIJING, SampleLocation.SHANGHAI, toDate("2011-01-01"), toDate("2011-01-02"))));
            fail("Should not accept null argument");
        } catch (IllegalArgumentException e) {}

        try {
            new Voyage(new VoyageNumber("123"), Arrays.asList((CarrierMovement)null));
            fail("Should not accept null element");
        } catch (IllegalArgumentException e) {}

        final Voyage voyage =  new Voyage(new VoyageNumber("123"),
                Arrays.asList(new CarrierMovement(SampleLocation.BEIJING, SampleLocation.SHANGHAI, toDate("2011-01-01"), toDate("2011-01-02"))));
        assertEquals(new VoyageNumber("123"), voyage.voyageNumber());
        assertEquals(Arrays.asList(new CarrierMovement(SampleLocation.BEIJING, SampleLocation.SHANGHAI, toDate("2011-01-01"), toDate("2011-01-02"))), voyage.carrierMovements());
    }

    @Test
    public void testSameIdentityAs() {
        final Voyage voyage1 = new Voyage(new VoyageNumber("123"), Arrays.asList(new CarrierMovement(SampleLocation.BEIJING, SampleLocation.SHANGHAI, toDate("2011-01-01"), toDate("2011-01-02"))));
        final Voyage voyage2 = new Voyage(new VoyageNumber("123"), Arrays.asList(new CarrierMovement(SampleLocation.BEIJING, SampleLocation.SHANGHAI, toDate("2011-01-01"), toDate("2011-01-02"))));
        assertTrue("Should have the same identity", voyage1.sameIdentityAs(voyage2));
    }
    @Test
    public void testEquals() {
        final Voyage voyage1 = new Voyage(new VoyageNumber("123"), Arrays.asList(new CarrierMovement(SampleLocation.BEIJING, SampleLocation.SHANGHAI, toDate("2011-01-01"), toDate("2011-01-02"))));
        final Voyage voyage2 = new Voyage(new VoyageNumber("123"), Arrays.asList(new CarrierMovement(SampleLocation.SHANGHAI, SampleLocation.BEIJING, toDate("2011-01-01"), toDate("2011-01-02"))));
        assertEquals("Should be equal", voyage1, voyage2);
    }
}
