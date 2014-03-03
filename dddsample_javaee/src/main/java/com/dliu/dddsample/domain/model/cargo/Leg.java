package com.dliu.dddsample.domain.model.cargo;

import com.dliu.dddsample.domain.model.location.Location;
import com.dliu.dddsample.domain.model.voyage.Voyage;
import org.apache.commons.lang.Validate;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 */
public class Leg {

    public Leg(Voyage voyage, Location loadLocation, Location unloadLocation, Date loadTime, Date unloadTime) {
        Validate.noNullElements(new Object[] {voyage, loadLocation, unloadLocation, loadTime, unloadTime});
    }
}
