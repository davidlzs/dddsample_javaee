package com.dliu.dddsample.domain.model.location;

import com.dliu.persistence.PersistenceTestBase;
import org.junit.Test;

import javax.persistence.EntityTransaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by IntelliJ IDEA.
 */
public class LocationPersistenceTest extends PersistenceTestBase {
    @Test
    public void testPersistence() {
        // setup
        Location loc1 = new Location();
        EntityTransaction txn = em.getTransaction();
        try {
            txn.begin();
            em.persist(loc1);
            em.flush();
            // execute
            Location loc = em.find(Location.class, 1);
            // assert
            assertEquals(1L, loc.getID());
        } finally {
            txn.rollback();
        }
    }
}
