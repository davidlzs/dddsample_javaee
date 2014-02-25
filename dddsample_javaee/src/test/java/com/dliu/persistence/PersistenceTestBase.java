package com.dliu.persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by IntelliJ IDEA.
 */
public abstract class PersistenceTestBase {
    protected static EntityManagerFactory emf;
    protected static EntityManager em;

    @BeforeClass
    public static void setUpFixture() {
        emf = Persistence.createEntityManagerFactory("dddsample_test_persistence");
        em = emf.createEntityManager();
    }

    @AfterClass
    public static void tearDownFixture() {
        em.close();
        emf.close();
        em = null;
        emf = null;
    }
}
