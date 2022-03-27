package fr.litopia.repository.api;

import fr.litopia.model.Abonne;
import fr.litopia.model.LocationAbonne;

import java.util.Set;

public interface LocationAbonneRepository extends Repository <LocationAbonne, Long> {
    /**
     * Retourne la liste des locations en cours d'un abonne
     * @param abonne l'abonne
     * @return Set<LocationAbonne>
     */
    Set<LocationAbonne> getLocationsEnCours(Abonne abonne);
}
