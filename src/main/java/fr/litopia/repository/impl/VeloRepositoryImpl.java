package fr.litopia.repository.impl;

import fr.litopia.model.Velo;
import fr.litopia.repository.api.VeloRepository;

import javax.persistence.EntityManager;
import java.util.Set;

public class VeloRepositoryImpl extends BaseRepositoryImpl implements VeloRepository {

    public VeloRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(Velo entity) {
        entityManager.persist(entity);
    }

    @Override
    public void delete(Velo entity) {
        entityManager.remove(entity);
    }

    @Override
    public Velo findById(Long id) {
        return entityManager.find(Velo.class,id);
    }

    @Override
    public Set<Velo> getAll() {
        return Set.copyOf(
                entityManager.createQuery("SELECT Velo FROM Velo ",Velo.class)
                        .getResultList());
    }
}
