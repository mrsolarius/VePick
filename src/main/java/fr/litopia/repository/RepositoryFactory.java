package fr.litopia.repository;

import fr.litopia.repository.api.*;
import fr.litopia.repository.impl.*;

import javax.persistence.EntityManager;

public class RepositoryFactory {

    public AbonneRepository newAbonneRepository(EntityManager entityManager) {
        return new AbonneRepositoryImpl(entityManager);
    }

    public BornetteRepository newBornetteRepository(EntityManager entityManager) {
        return new BornetteRepositoryImpl(entityManager);
    }

    public LocationAbonneRepository newLocationAbonneRepository(EntityManager entityManager) {
        return new LocationAbonneRepositoryImpl(entityManager);
    }

    public LocationNonAbonneRepository newLocationNonAbonneRepository(EntityManager entityManager) {
        return new LocationNonAbonneRepositoryImpl(entityManager);
    }

    public ModeleRepository newModeleRepository(EntityManager entityManager) {
        return new ModeleRepositoryImpl(entityManager);
    }

    public StationRepository newStationRepository(EntityManager entityManager) {
        return new StationRepositoryImpl(entityManager);
    }

    public VeloRepository newVeloRepository(EntityManager entityManager) {
        return new VeloRepositoryImpl(entityManager);
    }

}
