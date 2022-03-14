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
        entityManager.persist(entity);
    }

    @Override
    public void delete(Abonne entity) {
        entityManager.remove(entity);
    }

    @Override
    public Abonne findById(Long id) {
        return entityManager.find(Abonne.class,id);
    }

    @Override
    public Set<Abonne> getAll() {
        //ici on doit transformer en Set car notre modélisation se base dessus (pas de doublons et pas de supression)
        return Set.copyOf(
                entityManager.createQuery("SELECT Abonne FROM Abonne",Abonne.class)
                        .getResultList());
    }
}
