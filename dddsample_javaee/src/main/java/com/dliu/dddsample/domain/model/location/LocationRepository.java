package com.dliu.dddsample.domain.model.location;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Created by IntelliJ IDEA.
 */
public class LocationRepository {
    @PersistenceContext(unitName = "dddsample")
    private EntityManager em;

    public Location find(UNLocode unLocode) {
        TypedQuery<Location> query = em.createNamedQuery(Location.FIND_BY_UNLOCODE, Location.class);
        query.setParameter("unLocode", unLocode.getUnlocode());
        try {
            return query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }
}
