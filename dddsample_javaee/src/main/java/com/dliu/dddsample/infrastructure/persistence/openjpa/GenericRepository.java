package com.dliu.dddsample.infrastructure.persistence.openjpa;

import javax.persistence.EntityManager;

/**
 * Created by IntelliJ IDEA.
 */
public abstract class GenericRepository<T> {
    protected EntityManager em;

    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
}
