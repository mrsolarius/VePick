package fr.litopia.controller.api;

import fr.litopia.model.Bornette;
import fr.litopia.model.LocationNonAbonne;
import fr.litopia.model.Station;

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
     * gère le dépot du vélo à la bornette spécifiée
     * @TODO possibilité à l'utilisateur de signaler une panne du vélo rendu.[A22]
     * @todo Si ce vélo est rendu depuis moins de  min, cela annule la location.[A23]
     * @param bornette la bornette qui attend le vélo
     * @param loc la location à cloturer
     */
    void clotureLocation(Bornette bornette, LocationNonAbonne loc);
}
