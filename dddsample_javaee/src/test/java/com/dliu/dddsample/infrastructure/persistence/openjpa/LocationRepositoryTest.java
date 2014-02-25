package com.dliu.dddsample.infrastructure.persistence.openjpa;

import com.dliu.dddsample.domain.model.location.Location;
import com.dliu.dddsample.domain.model.location.LocationTestdataBuilder;
import com.dliu.dddsample.domain.model.location.UNLocode;
import de.akquinet.jbosscc.needle.junit.DatabaseRule;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by IntelliJ IDEA.
 */
public class LocationRepositoryTest {
    @Rule
    public static DatabaseRule databaseRule = new DatabaseRule("dddsample_test_persistence");
    private static EntityManager entityManager = databaseRule.getEntityManager();
    private static LocationRepository locRepo = new LocationRepository();

    @BeforeClass
    public static void setUp() {
        locRepo.setEntityManager(entityManager);
        new LocationTestdataBuilder(entityManager).withName("HongKong").withUNLocode(new UNLocode("CHHKG")).buildAndSave();
        new LocationTestdataBuilder(entityManager).withName("ShangHai").withUNLocode(new UNLocode("CHSHA")).buildAndSave();
    }

    @Test
    public void testFind() {
        Location loc = locRepo.find(new UNLocode("CHHKG"));
        assertNotNull(loc);
    }


    @Test
    public void testFind_notFound() {
        Location loc = locRepo.find(new UNLocode("NOLOC"));
        assertNull("Should not find non existing location for : NOLOC", loc);
    }

    @Test
    public void findAll() {
        List<Location> allLocations = locRepo.findAll();
        assertEquals(2, allLocations.size());

    }

    @AfterClass
    public static void tearDown() {
        locRepo.setEntityManager(null);
    }
}
