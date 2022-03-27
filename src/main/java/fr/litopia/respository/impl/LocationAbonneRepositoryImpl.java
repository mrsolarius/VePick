package fr.litopia.respository.impl;

import fr.litopia.model.Abonne;
import fr.litopia.model.LocationAbonne;
import fr.litopia.respository.api.LocationAbonneRepository;

import javax.persistence.EntityManager;
import java.util.Set;

public class LocationAbonneRepositoryImpl extends BaseRepositoryImpl implements LocationAbonneRepository {

    public LocationAbonneRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(LocationAbonne entity) {
        entityManager.persist(entity);
    }

    @Override
    public void delete(LocationAbonne entity) {
        entityManager.remove(entity);
    }

    @Override
    public LocationAbonne findById(Long id) {
        return entityManager.find(LocationAbonne.class,id);
    }

    @Override
    public Set<LocationAbonne> getAll() {
        return Set.copyOf(
                entityManager.createQuery("SELECT LocationAbonne FROM LocationAbonne ",LocationAbonne.class)
                        .getResultList());
    }

    @Override
    public Set<LocationAbonne> getLocationsEnCours(Abonne abonne) {
        return Set.copyOf(
                entityManager.createQuery("SELECT la FROM LocationAbonne la WHERE la.abonne = :abonne AND la.temps IS NULL",LocationAbonne.class)
                        .setParameter("abonne",abonne)
                        .getResultList());
    }
}
