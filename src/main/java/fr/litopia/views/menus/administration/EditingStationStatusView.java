package fr.litopia.views.menus.administration;

import fr.litopia.controler.ControlerFactory;
import fr.litopia.controler.api.AdministrationControler;
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
    private Station station;
    public EditingStationStatusView(View parent) {
        super(parent);
    }

    @Override
    protected void onContextSet() {
        station = (Station) viewContext.getContext().get("station");


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
        System.out.println("veuillez choisir un  statut  \n\n");
        System.out.println("Selectionnez 1 pour VMoins");
        System.out.println("Selectionnez 2  pour VNul");
        System.out.println("Selectionnez 3 pour VPlus");



        System.out.println("================================");

       // this.stationStatusList = [VStatus.VMOINS,VStatus.VNUL,VStatus.VPLUS];

        System.out.println("0 pour quitter ");


        Integer selectedStatus = ReadingConsole.readInt(0, 3);
        if (selectedStatus == 0) {
            this.stop();
        } else {
            //comment recuperer la valeur associer a un nombre(choix)
            // recupérer la station actuelle dans laquelle on se trouve
            station.setVStatus(stationStatusControler.getStatusValueSelected(selectedStatus));
            System.out.println("le statut de la station a été mis à jour avec succès");
            System.out.println("Appuyez sur entrée pour continuer");
            ReadingConsole.readLine();

            this.stop().stop();

        }


    }

    @Override
    protected void close() {

    }
}
