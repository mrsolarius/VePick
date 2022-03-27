package fr.litopia.repository.impl;

import javax.persistence.EntityManager;

/**
 * Class definissant ce qu'est une implementation de repository de base.
 * A dériver pour chaque type de repository.
 */
public abstract class BaseRepositoryImpl {

    protected final EntityManager entityManager;

    /**
     * Build a base repository
     * @param entityManager the entity manager
     */
    protected BaseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
