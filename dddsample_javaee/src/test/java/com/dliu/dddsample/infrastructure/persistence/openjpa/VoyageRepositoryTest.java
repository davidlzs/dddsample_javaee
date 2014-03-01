package com.dliu.dddsample.infrastructure.persistence.openjpa;

import com.dliu.dddsample.domain.model.location.Location;
import com.dliu.dddsample.domain.model.location.LocationTestdataBuilder;
import com.dliu.dddsample.domain.model.location.UNLocode;
import com.dliu.dddsample.domain.model.voyage.CarrierMovement;
import com.dliu.dddsample.domain.model.voyage.Voyage;
import com.dliu.dddsample.domain.model.voyage.VoyageNumber;
import de.akquinet.jbosscc.needle.db.transaction.Runnable;
import de.akquinet.jbosscc.needle.junit.DatabaseRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import javax.persistence.EntityManager;

import java.util.Arrays;

import static com.dliu.dddsample.test.util.DateTestUtil.toDate;

/**
 * Created by IntelliJ IDEA.
 */
public class VoyageRepositoryTest {
    @Rule
    public DatabaseRule databaseRule = new DatabaseRule("dddsample_test_persistence");
    private EntityManager em = databaseRule.getEntityManager();
    private VoyageRepository voyageRepo = new VoyageRepository();
    private Location hongKong;
    private Location shangHai;
    @Before
    public void setUp() {
        voyageRepo.setEntityManager(em);
        hongKong = new LocationTestdataBuilder(em).withName("HongKong").withUNLocode(new UNLocode("CHHKG")).buildAndSave();
        shangHai = new LocationTestdataBuilder(em).withName("ShangHai").withUNLocode(new UNLocode("CHSHA")).buildAndSave();
    }

    @Test
    public void testSave() throws Exception {
        final Voyage voyage = new Voyage(new VoyageNumber("123")
                , Arrays.asList(new CarrierMovement(hongKong, shangHai, toDate("2011-01-01"), toDate("2011-01-02"))));
        databaseRule.getTransactionHelper().executeInTransaction(new Runnable<Object>() {
            @Override
            public Object run(EntityManager entityManager) throws Exception {
                em.persist(voyage);
                em.flush();
                return null;
            }
        });
    }
}
