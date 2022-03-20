package fr.litopia.controller.api;

import fr.litopia.model.Station;

public interface RetraitControler extends Controler{
    /**
     * Permet de savoir si le retrait est possible à la station
     * @param station la station ou se fait le retrait
     * @return true si le retrait est possible, false sinon
     */
    boolean peutRendre(Station station);
}
