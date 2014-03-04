package com.dliu.dddsample.domain.model.cargo;

import com.dliu.dddsample.domain.model.location.SampleLocation;
import com.dliu.dddsample.domain.model.voyage.CarrierMovement;
import com.dliu.dddsample.domain.model.voyage.Voyage;
import com.dliu.dddsample.domain.model.voyage.VoyageNumber;
import org.junit.Test;

import java.util.Arrays;

import static com.dliu.dddsample.test.util.DateTestUtil.toDate;
import static junit.framework.Assert.assertEquals;
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

        Voyage voyage = new Voyage(new VoyageNumber("123"),
                Arrays.asList(new CarrierMovement.Builder().withDepartureLocation(SampleLocation.BEIJING)
                        .withArrivalLocation(SampleLocation.SHANGHAI)
                        .withDepartureTime(toDate("2011-01-01"))
                        .withArrivalTime(toDate("2011-01-02")).build()));
        final Leg leg = new Leg(voyage,
                SampleLocation.BEIJING,
                SampleLocation.SHANGHAI,
                toDate("2011-01-01"),
                toDate("2011-01-02")
                );
        assertEquals(voyage, leg.voyage());
        assertEquals(SampleLocation.BEIJING, leg.loadLocation());
        assertEquals(SampleLocation.SHANGHAI, leg.unloadLocation());
        assertEquals(toDate("2011-01-01"), leg.loadTime());
        assertEquals(toDate("2011-01-02"), leg.unloadTime());
    }
}
