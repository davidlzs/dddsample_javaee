package com.dliu.dddsample.domain.model.voyage;

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

        CarrierMovement cm = new CarrierMovement(BEIJING, SHANGHAI, new Date(), new Date());
        assertEquals(BEIJING, cm.departureLocation());
        assertEquals(SHANGHAI, cm.destinationLocation());
    }
}
