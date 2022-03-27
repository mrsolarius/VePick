package fr.litopia.controler.api;

import fr.litopia.model.Station;
import fr.litopia.model.enums.VStatus;

import java.util.Set;

public interface AdministrationControler extends Controler {
    /*-----------------------------------------------------------------------------------*/
    /*------------------------Vstatus----------------------------------------------------*/
    /**
     * @return la liste des status  possible d'une station sauf la courante.
     */

    Set<VStatus> getStationStatusPossible();

    /**
     * @param station (station courante)
     * @param vStatus (satus selectionné dans la vue)
     *  met à jour le status de la station
     */

    void setStationStatus(Station station, VStatus vStatus);

    /**
     *
     * @param number (l'entier selectionner)
     * @return la valeur du status associer au @number
     */
   VStatus getStatusValueSelected(int number);


    /*-----------------------------------------------------------------------------------*/
    /*------------------------bornettes----------------------------------------------------*/





    /*-----------------------------------------------------------------------------------*/
    /*------------------------velo-------------------------------------------------------*/

}
