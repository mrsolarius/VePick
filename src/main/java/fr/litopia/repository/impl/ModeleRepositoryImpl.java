package fr.litopia.repository.impl;

import fr.litopia.model.Modele;
import fr.litopia.repository.api.ModeleRepository;

import javax.persistence.EntityManager;
import java.util.Set;

public class ModeleRepositoryImpl extends BaseRepositoryImpl implements ModeleRepository {

    public ModeleRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(Modele entity) {
        entityManager.persist(entity);
    }

    @Override
    public void delete(Modele entity) {
        entityManager.remove(entity);
    }

    @Override
    public Modele findById(String id) {
        return entityManager.find(Modele.class,id);
    }

    @Override
    public Set<Modele> getAll() {
        return Set.copyOf(
                entityManager.createQuery("SELECT Modele FROM Modele ",Modele.class)
                        .getResultList());
    }
}
