package fr.litopia.controler;

import fr.litopia.controler.impl.ControlerImp;
import fr.litopia.model.Station;
import fr.litopia.respository.api.StationRepository;
import fr.litopia.view.impl.ViewImpl;

import java.util.Set;

public class StationControler extends ControlerImp {

    private StationRepository stationRepository;

    public StationControler(ViewImpl view) {
        super(view);
    }

    @Override
    public void init() {
        stationRepository = getRepositoryFactory().newStationRepository(getEntityManager());
    }

    public Set<Station> getAllStations() {
        return stationRepository.getAll();
    }
}
