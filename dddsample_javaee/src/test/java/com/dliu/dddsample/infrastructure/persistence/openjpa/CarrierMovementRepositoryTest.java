package com.dliu.dddsample.infrastructure.persistence.openjpa;

import com.dliu.dddsample.domain.model.location.Location;
import com.dliu.dddsample.domain.model.location.LocationTestdataBuilder;
import com.dliu.dddsample.domain.model.location.UNLocode;
import com.dliu.dddsample.domain.model.voyage.CarrierMovement;
import de.akquinet.jbosscc.needle.db.transaction.*;
import de.akquinet.jbosscc.needle.db.transaction.Runnable;
import de.akquinet.jbosscc.needle.junit.DatabaseRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import javax.persistence.EntityManager;

import static com.dliu.dddsample.test.util.DateTestUtil.toDate;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 */
public class CarrierMovementRepositoryTest {
    @Rule
    public DatabaseRule databaseRule = new DatabaseRule("dddsample_test_persistence");
    private EntityManager entityManager = databaseRule.getEntityManager();
    private CarrierMovementRepository carrierMovementRepo = new CarrierMovementRepository();

    @Before
    public void setUp() {
        carrierMovementRepo.setEntityManager(entityManager);
    }

    @Test
    public void testSave() throws Exception {
        final Location HongKong = new LocationTestdataBuilder(entityManager).withName("HongKong").withUNLocode(new UNLocode("CHHKG")).buildAndSave();
        final Location ShangHai = new LocationTestdataBuilder(entityManager).withName("ShangHai").withUNLocode(new UNLocode("CHSHA")).buildAndSave();

        databaseRule.getTransactionHelper().executeInTransaction(new Runnable<Object>() {
            @Override
            public Object run(EntityManager entityManager) {
                entityManager.persist(new CarrierMovement(HongKong, ShangHai, toDate("2011-01-01"), toDate("2011-01-02")));
                entityManager.flush();
                return null;
            }
        });

        assertNotNull(entityManager.find(CarrierMovement.class, 1L));
    }
}
