package fr.litopia.views.menus.administration;

import fr.litopia.controler.ControlerFactory;
import fr.litopia.controler.api.AdministrationControler;
import fr.litopia.model.Station;
import fr.litopia.utils.ReadingConsole;
import fr.litopia.views.struct.api.View;
import fr.litopia.views.struct.api.ViewContext;
import fr.litopia.views.struct.impl.ViewContextImpl;
import fr.litopia.views.struct.impl.ViewImpl;


import java.util.HashMap;

public class EditionStationView extends ViewImpl {

    /**
     * Constructeur de toutes vues
     * Inisialise le state a INIT
     * Appel la methode init
     * Nettoye la console
     *
     * @param parent
     */
    public String whereWeGo;
    private AddVeloView addVeloView;
    private AddBornetesView addBornetesView;
    private EditingStationStatusView editingStationStatusView;
    private AdministrationControler administrationControler;
    private Station station;

    public EditionStationView(View parent) {
        super(parent);
    }

    @Override
    protected void onContextSet() {
        station = (Station) viewContext.getContext().get("station");
    }

    @Override
    protected void init() {
        administrationControler = ControlerFactory.getAdministrationControler();
    }

    @Override
    protected void display() {

        System.out.println("================================");
        System.out.println("Bienvenue dans l'edition d'une station ");
        System.out.println("================================");
        System.out.println("\n Que voulez-vous faire ?\n");

        System.out.println("1. modifier le status");

        System.out.println("2. ajouter des bornettes");

        System.out.println("3. ajouter des velos");

        System.out.println("4. quitter");
        System.out.println("\nVotre choix : ");


        Integer choice = ReadingConsole.readInt(1,4);

        switch (choice){

            case 1 -> {
                //change status view(VPLUS VMOINS VNULL)

                editingStationStatusView = new EditingStationStatusView(this);
                editingStationStatusView.setContext(getContext());
                editingStationStatusView.run();
            }
            case 2 -> {
                //add bornette at  this sattion view

                addBornetesView =  new AddBornetesView(this);
                addBornetesView.setContext(getContext());
                addVeloView.run();
            }
            case 3 -> {
                //add velo at this station
                addVeloView=new AddVeloView(this);
                addVeloView.setContext(getContext());
                addVeloView.run();

            }

            case 4 -> {
                // return at the administation station view or station choose view
                this.stop();
            }
        }
    }




    ViewContext getContext(){
        HashMap<String ,Object> context = new HashMap<>();
        context.put("station",station);
        return  new ViewContextImpl(this.name,context);
    }


    @Override
    protected void close() {

    }
}
