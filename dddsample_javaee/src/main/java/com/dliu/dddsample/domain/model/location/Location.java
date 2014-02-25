package com.dliu.dddsample.domain.model.location;

import org.apache.commons.lang.Validate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Created by IntelliJ IDEA.
 */
@Entity
@Table(name = "LOCATION")
@NamedQueries(@NamedQuery(name = Location.FIND_BY_UNLOCODE, query = "SELECT l FROM com.dliu.dddsample.domain.model.location.Location l WHERE l.unLocode.unlocode = :unLocode "))
public class Location {
    public static final Location UNKNOWN = new Location(new UNLocode("XXXXX"), "Unknown Location");
    public static final String FIND_BY_UNLOCODE = "com.dliu.dddsample.domain.model.location.Location.FIND_BY_UNLOCODE";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Embedded
    private UNLocode unLocode;

    @Column(name = "NAME")
    private String name;

    public Location() {
    }

    public Location(UNLocode unLocode, String name) {
        Validate.notNull(unLocode);
        Validate.notNull(name);
        this.unLocode = unLocode;
        this.name = name;
    }

    public long getID() {
        return id;
    }

    public UNLocode getUNLocode() {
        return unLocode;
    }
}
