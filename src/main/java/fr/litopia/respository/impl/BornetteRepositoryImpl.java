package fr.litopia.respository.impl;

import fr.litopia.model.Bornette;
import fr.litopia.model.BornettePK;
import fr.litopia.respository.api.BornetteRepository;

import javax.persistence.EntityManager;
import java.util.Set;

public class BornetteRepositoryImpl extends BaseRepositoryImpl implements BornetteRepository {

    public BornetteRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(Bornette entity) {

    }

    @Override
    public void delete(Bornette entity) {

    }

    @Override
    public Bornette findById(BornettePK id) {
        return null;
    }

    @Override
    public Set<Bornette> getAll() {
        return null;
    }
}
