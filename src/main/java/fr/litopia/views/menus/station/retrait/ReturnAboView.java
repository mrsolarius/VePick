package fr.litopia.views.menus.station.retrait;

import fr.litopia.model.Abonne;
import fr.litopia.model.LocationAbonne;
import fr.litopia.model.LocationNonAbonne;
import fr.litopia.utils.ReadingConsole;
import fr.litopia.views.struct.api.View;
import fr.litopia.views.tinyView.LoginTinyView;
import fr.litopia.views.tinyView.ReturnLocTinyView;

import java.util.ArrayList;
import java.util.Set;

public class ReturnAboView extends ReturnComonContext{
    private Abonne abonne;
    public ReturnAboView(View view) {
        super(view);
    }

    private ArrayList<LocationAbonne> locationsEnCours;
    private LoginTinyView loginTinyView;

    @Override
    protected void init() {
        loginTinyView = new LoginTinyView();
    }

    @Override
    protected void display() {
        System.out.println("=================");
        System.out.println("RENDRE UN VÉLO");
        System.out.println("==================");
        abonne = loginTinyView.startAndGetValue();
        if(abonne == null){
            this.stop().stop();
        }
        locationsEnCours = new ArrayList<>(retraitControler.getLocationsEnCours(abonne)) ;


        //@TODO gérer le fait de rendre plusieurs vélos à la fois
        System.out.println("=================");
        System.out.println("VEUILLEZ SELECTIONNER LES LOCATIONS QUE VOUS SOUHAITEZ TERMINER :");
        for (int i = 0; i < locationsEnCours.size(); i++) {
            System.out.println("Location N°"+i+" démarrée à "+locationsEnCours.get(i).getDepart()+" avec le vélo n°"+locationsEnCours.get(i).getVelo().getNumero());

        }
        System.out.println("\n==========================");
        int selection = ReadingConsole.readInt(0,locationsEnCours.size());
        retraitControler.clotureLocationAbonne(bornette, locationsEnCours.get(selection));

    }

    @Override
    protected void close() {

    }
}
