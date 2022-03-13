package fr.litopia.respository.impl;

import fr.litopia.model.Velo;
import fr.litopia.respository.api.VeloRepository;

import javax.persistence.EntityManager;
import java.util.Set;

public class VeloRepositoryImpl extends BaseRepositoryImpl implements VeloRepository {

    public VeloRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(Velo entity) {

    }

    @Override
    public void delete(Velo entity) {

    }

    @Override
    public Velo findById(Long id) {
        return null;
    }

    @Override
    public Set<Velo> getAll() {
        return null;
    }
}
