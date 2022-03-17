package fr.litopia.respository.api;

import fr.litopia.model.Bornette;
import fr.litopia.model.BornettePK;
import fr.litopia.model.Station;

public interface BornetteRepository extends Repository<Bornette, BornettePK> {
    //@Todo ajouter des methods utiles pour la gestion des bornettes
    long getLastIdInStation(Station s);
}
