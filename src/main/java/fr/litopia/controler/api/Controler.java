package fr.litopia.controler.api;

import fr.litopia.respository.RepositoryFactory;

import javax.persistence.EntityManager;

public interface Controler {
    /**
     * Permet de récupérer l'EntityManager afin de pouvoir effectuer des
     * requêtes sur la base de données.
     * @return entityManager
     */
    EntityManager getEntityManager();

    /**
     * Permet de récupérer l'usine de repository afin de pouvoir créer des
     * objets de type Repository.
     * @return repositoryFactory
     */
    RepositoryFactory getRepositoryFactory();

    /**
     * Permet d'initialiser le controleur.
     */
    void init();
}
