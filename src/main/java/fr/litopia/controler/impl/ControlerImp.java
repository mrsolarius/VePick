package fr.litopia.controler.impl;

import fr.litopia.controler.api.Controler;
import fr.litopia.repository.RepositoryFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public abstract class ControlerImp implements Controler {
    private final EntityManager entityManager;
    private final RepositoryFactory daoFactory = new RepositoryFactory();

    public ControlerImp() {
        entityManager = Persistence.createEntityManagerFactory("VePick").createEntityManager();
        this.init();
    }

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public RepositoryFactory getRepositoryFactory() {
        return this.daoFactory;
    }

    public abstract void init();
}
