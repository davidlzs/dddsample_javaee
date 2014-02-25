package com.dliu.dddsample.infrastructure.persistence.openjpa;

import com.dliu.dddsample.domain.model.location.Location;
import com.dliu.dddsample.domain.model.location.UNLocode;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

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

    public List<Location> findAll() {
        return  em.createNamedQuery(Location.FIND_ALL, Location.class).getResultList();
    }
}
