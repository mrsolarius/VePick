package fr.litopia.controler.impl;

import fr.litopia.controler.api.EmprunControler;
import fr.litopia.model.*;
import fr.litopia.model.enums.Etat;
import fr.litopia.repository.RepositoryFactory;
import fr.litopia.repository.api.BornetteRepository;
import fr.litopia.repository.api.LocationAbonneRepository;
import fr.litopia.repository.api.LocationNonAbonneRepository;

import java.util.Set;

public class EmprunControlerImpl extends ControlerImp implements EmprunControler {

    private BornetteRepository bornette;
    private LocationNonAbonneRepository locationNonAbonneRepository;
    private LocationAbonneRepository locationAbonneRepository;
    private BornetteRepository bornetteRepository;

    @Override
    public void init() {
        RepositoryFactory repositoryFactory = new RepositoryFactory();
        bornette = repositoryFactory.newBornetteRepository(getEntityManager());
        locationNonAbonneRepository = repositoryFactory.newLocationNonAbonneRepository(getEntityManager());
        locationAbonneRepository = repositoryFactory.newLocationAbonneRepository(getEntityManager());
        bornetteRepository = repositoryFactory.newBornetteRepository(getEntityManager());
    }

    @Override
    public Bornette peutEmprunter(Station station) {
        Set<Bornette> bornettesOK = bornette.getBornettesStationWithBike(station, Etat.OK);
        if(bornettesOK.isEmpty()) return null;
        return bornettesOK.iterator().next();
    }

    @Override
    public LocationNonAbonne emprunterVeloNonAbonne(Bornette bornette, String cb) {
        LocationNonAbonne loc = new LocationNonAbonne(cb);
        loc.setVelo(bornette.getVelo());
        loc.generateCode(this.locationNonAbonneRepository);
        this.getEntityManager().getTransaction().begin();
        this.locationNonAbonneRepository.save(loc);
        this.getEntityManager().getTransaction().commit();
        return loc;
    }

    @Override
    public void prendreVelo(Bornette bornette) {
        this.getEntityManager().getTransaction().begin();
        bornette.takeVelo();
        bornetteRepository.save(bornette);
        this.getEntityManager().getTransaction().commit();
    }

    @Override
    public LocationAbonne emprunterVeloAbonne(Bornette bornette, Abonne abo) {
        LocationAbonne loc = new LocationAbonne(abo);
        loc.setVelo(bornette.getVelo());
        this.getEntityManager().getTransaction().begin();
        this.locationAbonneRepository.save(loc);
        this.getEntityManager().getTransaction().commit();
        return loc;
    }
}
