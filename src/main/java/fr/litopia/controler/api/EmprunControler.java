package fr.litopia.controler.api;

import fr.litopia.model.*;

public interface EmprunControler extends Controler{
    /**
     * Permet de savoir si l'emprunt est possible
     * Dans la station passer en parametre
     * @param station la station ou l'on veut emprunter
     * @return bornette si l'emprunt est possible null sinon
     */
    Bornette peutEmprunter(Station station);

    /**
     * Permet de créer une location NonAbonne
     * @param bornette la bornette ou l'on va emprunter un vélo
     * @param cb carte bancaire de l'usager
     * @return la location créée
     */
    LocationNonAbonne emprunterVeloNonAbonne(Bornette bornette, String cb);

    /**
     * Permet de prendre le vélo de la bornette
     * @param bornette la bornette
     */
    void prendreVelo(Bornette bornette);

    /**
     * Permet de crée une location Abonne
     * @param bornette la bornette ou l'on va emprunter un vélo
     * @param abo l'abonne qui emprunte
     * @return la location créée
     */
    LocationAbonne emprunterVeloAbonne(Bornette bornette, Abonne abo);
}
