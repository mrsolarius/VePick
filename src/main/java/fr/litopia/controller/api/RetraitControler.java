package fr.litopia.controller.api;

import fr.litopia.model.*;
import fr.litopia.model.enums.Etat;

import java.util.Set;

public interface RetraitControler extends Controler{
    /**
     * Permet de savoir si le retrait est possible à la station
     * @param station la station ou se fait le retrait
     * @return une bornette disponible s'il y en a une, null sinon.
     */
    Bornette peutRendre(Station station);

    /**
     * permet d'identifier le vélo rendu
     * @param code le code de la location non abonné
     * @return la location correspondante au code si elle existe, null sinon.
     * */
    LocationNonAbonne checkCode(String code);

    /**
     * permet de vérifier si le vélo est rendu moins de 5 minutes après son emprunt
     * @param loc la location (abonné ou non) qui contient la date de départ (d'emprunt)
     * @return vrai si le rendu est fait en moins de 5 minutes, faux sinon
     */
    Boolean isUnderFiveMinutes(Location loc);

    /**
     * gère le dépot du vélo dans le cadre d'une location non abonné à la bornette spécifiée (calcul du prix, calcul du temps de trajet, cloture de la location)
     * @param bornette la bornette qui attend le vélo
     * @param loc la location à cloturer
     * @return le prix calculé de la location
     */
    Double clotureLocationNonAbonne(Bornette bornette, LocationNonAbonne loc);

    /**
     * @param abonne un abonné
     * @return un set des locations de l'abonné en cours. */
    Set<LocationAbonne> getLocationsEnCours(Abonne abonne);

    /**
     * gère le dépot du vélo dans le cadre d'une location abonné à la bornette spécifiée (calcul du prix, calcul du temps de trajet, cloture de la location)
     * @param bornette la bornette qui attend le vélo
     * @param loc la location à cloturer
     * @return le prix calculé de la location
     */
    Double clotureLocationAbonne(Bornette bornette, LocationAbonne loc);

    /**
     * gère le dépot du vélo dans le cadre d'un vélo HS moins de 5 minutes après l'emprunt (calcul du prix à ne pas faire donc !)
     * @param bornette la bornette qui attend le vélo
     * @param loc la location à cloturer
     */
    void clotureLocationHSUnderFiveMinutes(Bornette bornette, Location loc);

    void changeBikeState(Location location, Etat state);
}
