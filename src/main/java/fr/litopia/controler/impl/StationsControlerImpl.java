package fr.litopia.controler.impl;

import fr.litopia.controler.api.StationsControler;
import fr.litopia.model.Station;
import fr.litopia.repository.api.StationRepository;

import java.util.Set;

public class StationsControlerImpl extends ControlerImpl implements StationsControler {

    private StationRepository stationRepository;

    public StationsControlerImpl() {
        super();
    }

    @Override
    public void init() {
        stationRepository = getRepositoryFactory().newStationRepository(getEntityManager());
    }

    @Override
    public Set<Station> getAllStations() {
        return stationRepository.getAll();
    }
}
