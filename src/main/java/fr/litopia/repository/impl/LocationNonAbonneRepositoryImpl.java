package fr.litopia.repository.impl;

import fr.litopia.model.LocationNonAbonne;
import fr.litopia.repository.api.LocationNonAbonneRepository;

import javax.persistence.EntityManager;
import java.util.Set;

public class LocationNonAbonneRepositoryImpl extends BaseRepositoryImpl implements LocationNonAbonneRepository {

    public LocationNonAbonneRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(LocationNonAbonne entity) {
        entityManager.persist(entity);
    }

    @Override
    public void delete(LocationNonAbonne entity) {
        entityManager.remove(entity);
    }

    @Override
    public LocationNonAbonne findById(Long id) {
        return entityManager.find(LocationNonAbonne.class,id);
    }

    @Override
    public Set<LocationNonAbonne> getAll() {
        return Set.copyOf(
                entityManager.createQuery("SELECT LocationNonAbonne FROM LocationNonAbonne ",LocationNonAbonne.class)
                        .getResultList());
    }

    @Override
    public Boolean verifyCode(String c) {
        return entityManager.createQuery("SELECT l FROM LocationNonAbonne l WHERE l.code = :code AND l.temps is null")
                .setParameter("code", c)
                .getResultList().isEmpty();
    }

    @Override
    public LocationNonAbonne getLocNonAbonne(String code){
        return (LocationNonAbonne) entityManager.createQuery("SELECT l FROM LocationNonAbonne l WHERE l.code = :code and l.temps is null")
                .setParameter("code", code)
                .getSingleResult();
    }
}
