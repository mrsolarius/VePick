package fr.litopia.repository.api;

import fr.litopia.model.Bornette;
import fr.litopia.model.BornettePK;
import fr.litopia.model.Station;
import fr.litopia.model.enums.Etat;

import java.util.Set;

public interface BornetteRepository extends Repository<Bornette, BornettePK> {
    /**
     * Renvois le dernier numéro de bornette utilisé pour une station donnée
     * @param s la station
     * @return le dernier numéro de bornette utilisé pour une station donnée
     */
    long getLastIdInStation(Station s);

    /**
     * renvoie les bornettes d'une station
     * @param s la station
     * @return les bornettes d'une station
     */
    Set<Bornette> getBornettesStationWithBike(Station s);

    /**
     * Renvoie les bornettes à l'état e qui contiennent des vélos à l'état e
     * @param s la station
     * @param e l'état
     * @return les bornettes à l'état e qui contiennent des vélos à l'état e
     */
    Set<Bornette> getBornettesStationWithBike(Station s, Etat e);

    /**
     * renvoie les bornettes à l'état e qui contiennent des vélos à l'état e
     * @param e l'état
     * @param s la station
     * @return les bornettes à l'état e qui contiennent des vélos à l'état e
     */
    Set<Bornette> getBornettesStationWithoutBike(Station s, Etat e);

}
