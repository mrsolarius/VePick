package fr.litopia.controller.api;

import fr.litopia.model.Station;

public interface RetraitControler extends Controler{
    boolean peutRetirer(Station station);
}
