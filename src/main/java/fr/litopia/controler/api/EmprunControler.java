package fr.litopia.controler.api;

import fr.litopia.model.*;

public interface EmprunControler extends Controler{
    /**
     * Permet de savoir si l'emprunt est possible
     * Dans la station passer en parametre
     * @param station la station ou l'on veut emprunter
     * @return true si l'emprunt est possible false sinon
     */
    boolean peutEmprunter(Station station);

    /**
     * Permet de créer une location NonAbonne
     * @param station la station ou l'on veut emprunter
     * @param cb carte bancaire de l'usager
     * @return la location créée
     */
    LocationNonAbonne emprunterVeloNonAbonne(Station station, String cb);

    /**
     * Permet de prendre le vélo de la station
     * @param loc la location
     */
    void prendreVelo(Location loc);

    /**
     * Permet de crée une location Abonne
     * @param station la station ou l'on veut emprunter
     * @param abo l'abonne qui emprunte
     * @return la location créée
     */
    LocationAbonne emprunterVeloAbonne(Station station, Abonne abo);
}
