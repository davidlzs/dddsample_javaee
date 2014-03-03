package com.dliu.dddsample.domain.model.location;

import de.akquinet.jbosscc.needle.db.testdata.AbstractTestdataBuilder;

import javax.persistence.EntityManager;

/**
 * Created by IntelliJ IDEA.
 */
public class LocationTestdataBuilder extends AbstractTestdataBuilder<Location> {
    private UNLocode unLocode;
    private String name;

    public LocationTestdataBuilder(EntityManager entityManager) {
        super(entityManager);
    }

    public LocationTestdataBuilder withUNLocode( UNLocode unLocode) {
        this.unLocode = unLocode;
        return this;
    }

    public LocationTestdataBuilder withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Location build() {
        Location loc = new Location.Builder().withUnLocode(unLocode).withName(name).build();
        return loc;
    }
}
