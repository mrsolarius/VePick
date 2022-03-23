package fr.litopia.respository.impl;

import fr.litopia.model.Bornette;
import fr.litopia.model.BornettePK;
import fr.litopia.model.Station;
import fr.litopia.model.enums.Etat;
import fr.litopia.respository.api.BornetteRepository;

import javax.persistence.EntityManager;
import java.util.Set;

public class BornetteRepositoryImpl extends BaseRepositoryImpl implements BornetteRepository {

    public BornetteRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void save(Bornette entity) {
        entityManager.persist(entity);
    }

    @Override
    public void delete(Bornette entity) {
        entityManager.remove(entity);
    }

    @Override
    public Bornette findById(BornettePK id) {
        return entityManager.find(Bornette.class,id);
    }

    @Override
    public Set<Bornette> getAll() {
        return Set.copyOf(
                entityManager.createQuery("SELECT Bornette FROM Bornette ",Bornette.class)
                        .getResultList());
    }

    @Override
    public long getLastIdInStation(Station s) {
        return entityManager.createQuery("SELECT b.pk.numero from Bornette b where b.pk.station = :station order by b.pk.numero desc")
                .setParameter("station", s)
                .getFirstResult();
    }

    @Override
    public Set<Bornette> getBornettesStation(Station s) {
        return Set.copyOf(
                entityManager.createQuery("SELECT Bornette FROM Bornette WHERE Bornette.pk.station = :station")
                        .setParameter("station", s)
                        .getResultList()
        );
    }

    @Override
    public Set<Bornette> getBornettesStation(Station s, Etat e) {
        return Set.copyOf(
                entityManager.createQuery("SELECT b FROM Bornette b JOIN b.velo v WHERE b.pk.station.adresse = :station AND b.etat = :etat AND v.etat = :etat")
                        .setParameter("station", s.getAdresse())
                        .setParameter("etat", e)
                        .getResultList()
        );
    }

}
