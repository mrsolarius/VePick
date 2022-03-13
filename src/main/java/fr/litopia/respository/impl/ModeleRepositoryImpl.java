package fr.litopia.respository.impl;

import fr.litopia.model.Modele;
import fr.litopia.respository.api.ModeleRepository;

import javax.persistence.EntityManager;
import java.util.Set;

public class ModeleRepositoryImpl extends BaseRepositoryImpl implements ModeleRepository {

    public ModeleRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(Modele entity) {

    }

    @Override
    public void delete(Modele entity) {

    }

    @Override
    public Modele findById(String id) {
        return null;
    }

    @Override
    public Set<Modele> getAll() {
        return null;
    }
}
