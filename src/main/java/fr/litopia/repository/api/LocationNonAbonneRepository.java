package fr.litopia.repository.api;

import fr.litopia.model.LocationNonAbonne;

public interface LocationNonAbonneRepository extends Repository <LocationNonAbonne, Long> {

    /**
     * Verifie que le code généré est unique parmi les codes dans les locations qui ne sont pas terminées
     * renvoie True si le code est unique
     * @param code le code à vérifier
     * @return boolean true si le code existe
     */
    Boolean verifyCode(String code);

    /**
     * Permet de get la location non abonné voulus
     * @param code le code de location
     * @return LocationNonAbonne
     */
    LocationNonAbonne getLocNonAbonne(String code);
}
