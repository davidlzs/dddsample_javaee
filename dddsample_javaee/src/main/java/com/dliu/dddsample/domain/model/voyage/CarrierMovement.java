package com.dliu.dddsample.domain.model.voyage;

import com.dliu.dddsample.domain.model.location.Location;
import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 */
@Entity
@Table(name = "CARRIER_MOVEMENT")
public class CarrierMovement {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne//(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "DEPARTURE_LOCATION_ID", referencedColumnName = "ID")
    private Location departureLocation;
    @ManyToOne//(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ARRIVAL_LOCATION_ID",referencedColumnName = "ID")
    private Location arrivalLocation;
    @Column(name = "DEPARTURE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureTime;
    @Column(name = "ARRIVAL_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalTime;

    public CarrierMovement(Location departureLocation,
                           Location destinationLocation,
                           Date departureTime,
                           Date arrivalTime) {
        Validate.notNull(departureLocation);
        Validate.notNull(destinationLocation);
        this.departureLocation = departureLocation;
        this.arrivalLocation = destinationLocation;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    public Location departureLocation() {
        return departureLocation;
    }

    public Location arrivalLocation() {
        return arrivalLocation;
    }

    public Date departureTime() {
        return departureTime;
    }

    public Date arrivalTime() {
        return arrivalTime;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(departureLocation)
                .append(arrivalLocation)
                .append(departureTime)
                .append(arrivalTime).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if ( other == null || other.getClass() != getClass()) return false;

        final CarrierMovement that = (CarrierMovement) other;
        return sameValueOf(that);
    }

    public boolean sameValueOf(CarrierMovement that) {
        return (that != null && new EqualsBuilder()
                .append(departureLocation, that.departureLocation)
                .append(arrivalLocation, that.arrivalLocation)
                .append(departureTime, that.departureTime)
                .append(arrivalTime, that.arrivalTime).isEquals());
    }
}