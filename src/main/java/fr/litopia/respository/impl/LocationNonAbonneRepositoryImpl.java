package fr.litopia.respository.impl;

import fr.litopia.model.LocationAbonne;
import fr.litopia.respository.api.LocationNonAbonneRepository;

import javax.persistence.EntityManager;
import java.util.Set;

public class LocationNonAbonneRepositoryImpl extends BaseRepositoryImpl implements LocationNonAbonneRepository {

    public LocationNonAbonneRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(LocationAbonne entity) {

    }

    @Override
    public void delete(LocationAbonne entity) {

    }

    @Override
    public LocationAbonne findById(Long id) {
        return null;
    }

    @Override
    public Set<LocationAbonne> getAll() {
        return null;
    }
}
