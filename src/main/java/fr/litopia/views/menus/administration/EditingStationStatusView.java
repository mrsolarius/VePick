package fr.litopia.views.menus.administration;

import fr.litopia.controller.ControlerFactory;
import fr.litopia.controller.api.AdministrationControler;
import fr.litopia.model.Station;
import fr.litopia.model.enums.VStatus;
import fr.litopia.utils.ReadingConsole;
import fr.litopia.views.struct.api.View;
import fr.litopia.views.struct.impl.ViewImpl;

import java.util.ArrayList;

public class EditingStationStatusView extends ViewImpl {
    /**
     * Constructeur de toutes vues
     * Inisialise le state a INIT
     * Appel la methode init
     * Nettoye la console
     *
     * @param parent
     */

    private AdministrationControler stationStatusControler;
    private ArrayList<VStatus> stationStatusList;
    private EditingStationStatusView editingStationStatusView;

    Station station =(Station) viewContext.getContext().get("station");

    public EditingStationStatusView(View parent) {
        super(parent);
    }

    @Override
    protected void onContextSet() {

        viewContext.getContext().get("context");


    }


    //System.out.println(station.getVStatus());

    @Override
    protected void init() {
        stationStatusControler = ControlerFactory.getAdministrationControler();
        this.editingStationStatusView = new EditingStationStatusView(this);

    }

    @Override
    protected void display() {

        System.out.println("================================");
        System.out.println("veuillez choisir un  status  ");
        System.out.println("================================");

        this.stationStatusList = new ArrayList<>(stationStatusControler.getStationStatusPossible());

        System.out.println("0 - quitter ");


        Integer selectedStatus = ReadingConsole.readInt(-1, this.stationStatusList.size() - 1);
        if (selectedStatus == 0) {
            this.stop();
        } else {
            //comment recuperer la valeur associer a un nombre(choix)
            // recupérer la station actuelle dans laquelle on se trouve
            station.setVStatus(stationStatusControler.getStatusValueSelected(selectedStatus));
            System.out.println("le status de la station a été modifier merci !!!!!");
            this.stop().stop();

        }


    }

    @Override
    protected void close() {

    }
}
