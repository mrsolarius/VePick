package fr.litopia.views.menus.station.retrait;

import fr.litopia.controller.ControlerFactory;
import fr.litopia.controller.api.RetraitControler;
import fr.litopia.model.Bornette;
import fr.litopia.model.LocationNonAbonne;
import fr.litopia.utils.ReadingConsole;
import fr.litopia.views.struct.api.View;
import fr.litopia.views.tinyView.ReturnLocTinyView;

import javax.persistence.ManyToOne;

public class ReturnNonAboView extends ReturnComonContext{
    @ManyToOne
    private LocationNonAbonne locationNonAbonne;
    private ReturnLocTinyView returnLocTinyView;

    public LocationNonAbonne getLocationNonAbonne() {
        return locationNonAbonne;
    }

    public ReturnNonAboView(View view) {
        super(view);
    }

    @Override
    protected void init() {
        returnLocTinyView = new ReturnLocTinyView();
    }

    @Override
    protected void display() {
        System.out.println("=================");
        System.out.println("RENDRE UN VÉLO");
        System.out.println("==================");
        locationNonAbonne = returnLocTinyView.startAndGetValue();
        if (locationNonAbonne==null){
            this.stop().stop();
        }
        this.clean();
        System.out.println("=================");
        System.out.println("CODE CORRECT, VEUILLEZ POSER VOTRE VELO SUR LA BORNETTE N°"+this.bornette.getNumero());
        System.out.println("==================");
        retraitControler.clotureLocation(bornette,locationNonAbonne);

    }

    @Override
    protected void close() {

    }
}
