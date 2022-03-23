package fr.litopia.controller.api;

import fr.litopia.model.*;

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
     * gère le dépot du vélo dans le cadre d'une location non abonné à la bornette spécifiée (calcul du prix, calcul du temps de trajet, cloture de la location)
     * @TODO possibilité à l'utilisateur de signaler une panne du vélo rendu.[A22]
     * @todo Si ce vélo est rendu depuis moins de  min, cela annule la location.[A23]
     * @param bornette la bornette qui attend le vélo
     * @param loc la location à cloturer
     */
    void clotureLocationNonAbonne(Bornette bornette, LocationNonAbonne loc);

    /**
     * @param abonne un abonné
     * @return un set des locations de l'abonné en cours. */
    Set<LocationAbonne> getLocationsEnCours(Abonne abonne);

    /**
     * gère le dépot du vélo dans le cadre d'une location abonné à la bornette spécifiée (calcul du prix, calcul du temps de trajet, cloture de la location)
     * @TODO possibilité à l'utilisateur de signaler une panne du vélo rendu.[A22]
     * @todo Si ce vélo est rendu depuis moins de  min, cela annule la location.[A23]
     * @param bornette la bornette qui attend le vélo
     * @param loc la location à cloturer
     */
    void clotureLocationAbonne(Bornette bornette, LocationAbonne loc);
}
