package fr.litopia.controler;

import fr.litopia.model.Station;
import fr.litopia.respository.RepositoryFactory;
import fr.litopia.respository.api.StationRepository;
import fr.litopia.view.View;

import java.util.Set;

public class StationControler extends Controler {

    private StationRepository stationRepository;

    public StationControler(View view) {
        super(view);
    }

    @Override
    public void init() {
        stationRepository = daoFactory.newStationRepository(entityManager);
    }

    public Set<Station> getAllStations() {
        return stationRepository.getAll();
    }
}
