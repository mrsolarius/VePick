package fr.litopia.respository.impl;

import fr.litopia.model.Station;
import fr.litopia.respository.api.StationRepository;

import javax.persistence.EntityManager;
import java.util.Set;

public class StationRepositoryImpl extends BaseRepositoryImpl implements StationRepository {

    public StationRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(Station entity) {
        entityManager.persist(entity);
    }

    @Override
    public void delete(Station entity) {
        entityManager.remove(entity);
    }

    @Override
    public Station findById(String adresse)
    {
        return entityManager.find(Station.class, adresse);
    }

    @Override
    public Set<Station> getAll() {
        return Set.copyOf(entityManager.createQuery("SELECT s FROM Station s", Station.class).getResultList());
    }
}
