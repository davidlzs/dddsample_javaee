package com.dliu.dddsample.domain.model.voyage;

import com.dliu.dddsample.test.util.DateTestUtil;
import org.junit.Test;

import java.util.Date;
import static com.dliu.dddsample.domain.model.location.SampleLocation.BEIJING;
import static com.dliu.dddsample.domain.model.location.SampleLocation.SHANGHAI;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by IntelliJ IDEA.
 */
public class CarrierMovementTest {
    @Test
    public void testConstructor() {
        try  {
            new CarrierMovement(null, null, new Date(), new Date());
            fail ("Should not accept null arguments");
        } catch (IllegalArgumentException e) {}

        try {
            new CarrierMovement(BEIJING, null, new Date(), new Date());
            fail ("Should not accept null arguments");
        } catch (IllegalArgumentException e) {}

        CarrierMovement cm = new CarrierMovement(BEIJING, SHANGHAI,
                DateTestUtil.toDate("2011-01-01"), DateTestUtil.toDate("2011-02-01"));
        assertEquals(BEIJING, cm.departureLocation());
        assertEquals(SHANGHAI, cm.destinationLocation());
        assertEquals(DateTestUtil.toDate("2011-01-01"), cm.departureTime());
        assertEquals(DateTestUtil.toDate("2011-02-01"), cm.arrivalTime());
    }
}
