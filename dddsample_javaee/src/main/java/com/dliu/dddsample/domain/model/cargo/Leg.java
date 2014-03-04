package com.dliu.dddsample.domain.model.cargo;

import com.dliu.dddsample.domain.model.location.Location;
import com.dliu.dddsample.domain.model.voyage.Voyage;
import org.apache.commons.lang.Validate;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 */
public class Leg {

    private Voyage voyage;
    private Location loadLocation;
    private Location unloadLocation;
    private Date loadTime;
    private Date unloadTime;

    public Leg(Voyage voyage, Location loadLocation, Location unloadLocation, Date loadTime, Date unloadTime) {
        Validate.noNullElements(new Object[] {voyage, loadLocation, unloadLocation, loadTime, unloadTime});
        this.voyage = voyage;
        this.loadLocation = loadLocation;
        this.unloadLocation = unloadLocation;
        this.loadTime = loadTime;
        this.unloadTime = unloadTime;
    }

    public Voyage voyage() {
        return voyage;
    }

    public Location loadLocation() {
        return loadLocation;
    }

    public Location unloadLocation() {
        return unloadLocation;
    }

    public Date loadTime() {
        return loadTime;
    }

    public Date unloadTime() {
        return unloadTime;
    }
}
