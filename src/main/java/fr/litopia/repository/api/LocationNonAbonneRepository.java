package fr.litopia.repository.api;

import fr.litopia.model.LocationNonAbonne;

public interface LocationNonAbonneRepository extends Repository <LocationNonAbonne, Long> {
    //@Todo ajouter des methods utiles pour la gestion des locations non abonnes
    /**
     * Verifie que le code généré est unique parmi les codes dans les locations qui ne sont pas terminées
     * renvoie True si le code est unique
     */
    Boolean verifyCode(String code);

    /**
     * Permet de get la location non abonné voulus
     * @param code le code de location
     * @return LocationNonAbonne
     */
    LocationNonAbonne getLocNonAbonne(String code);
}
