package fr.litopia.controller.impl;

import fr.litopia.controller.api.EmprunControler;
import fr.litopia.model.*;
import fr.litopia.model.enums.Etat;
import fr.litopia.respository.RepositoryFactory;
import fr.litopia.respository.api.BornetteRepository;
import fr.litopia.respository.api.StationRepository;
import fr.litopia.respository.api.VeloRepository;
import fr.litopia.respository.impl.BornetteRepositoryImpl;

import java.util.Set;

public class EmprunControlerImpl extends ControlerImp implements EmprunControler {

    private BornetteRepository bornette;
    private VeloRepository velo;

    @Override
    public void init() {
        RepositoryFactory repositoryFactory = new RepositoryFactory();
        bornette = repositoryFactory.newBornetteRepository(getEntityManager());
        velo = repositoryFactory.newVeloRepository(getEntityManager());
    }

    @Override
    public boolean peutEmprunter(Station station) {
        Set<Bornette> bornettesOK = bornette.getBornettesStation(station, Etat.OK);
        return !bornettesOK.isEmpty();
    }

    @Override
    public LocationNonAbonne emprunterVeloNonAbonne(Station station, String cb) {
        return null;
    }

    @Override
    public void prendreVelo(Location loc) {

    }

    @Override
    public LocationAbonne emprunterVeloAbonne(Station station, Abonne abo) {
        return null;
    }
}
