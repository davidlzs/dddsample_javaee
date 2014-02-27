package com.dliu.dddsample.domain.model.voyage;

import com.dliu.dddsample.domain.model.location.Location;
import org.apache.commons.lang.Validate;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 */
public class CarrierMovement {
    private Location departureLocation;
    private Location destinationLocation;
    private Date departureTime;
    private Date arrivalTime;

    public CarrierMovement(Location departureLocation,
                           Location destinationLocation,
                           Date departureTime,
                           Date arrivalTime) {
        Validate.notNull(departureLocation);
        Validate.notNull(destinationLocation);
        this.departureLocation = departureLocation;
        this.destinationLocation = destinationLocation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Location departureLocation() {
        return departureLocation;
    }

    public Location destinationLocation() {
        return destinationLocation;
    }

    public Date departureTime() {
        return departureTime;
    }

    public Date arrivalTime() {
        return arrivalTime;
    }
}
