package fr.litopia.controller.api;

import fr.litopia.model.Station;

import java.util.Set;

public interface StationsControler extends Controler {
    /**
     * Permet de récupérer la liste des stations de la base de données
     * @return un set de la liste des stations
     */
    Set<Station> getAllStations();
}
