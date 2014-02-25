package com.dliu.dddsample.domain.model.location;

import de.akquinet.jbosscc.needle.junit.DatabaseRule;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import javax.persistence.EntityManager;

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
        Location loc = locRepo.find(new UNLocode("CHSHA"));
        assertNull("Should not find non existing location for : CHSHA", loc);
    }

    @AfterClass
    public static void tearDown() {
        locRepo.setEntityManager(null);

    }
}
