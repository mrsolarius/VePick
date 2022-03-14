package fr.litopia.respository.impl;

import fr.litopia.model.Abonne;
import fr.litopia.respository.api.AbonneRepository;

import javax.persistence.EntityManager;
import java.util.Set;

public class AbonneRepositoryImpl extends BaseRepositoryImpl implements AbonneRepository {

    public AbonneRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(Abonne entity) {

    }

    @Override
    public void delete(Abonne entity) {

    }

    @Override
    public Abonne findById(String id) {
        return null;
    }

    @Override
    public Set<Abonne> getAll() {
        return null;
    }
}
