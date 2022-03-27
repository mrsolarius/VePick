package fr.litopia.views.menus.station.retour;

import fr.litopia.controler.api.RetourControler;
import fr.litopia.model.Bornette;
import fr.litopia.model.Station;
import fr.litopia.utils.ReadingConsole;
import fr.litopia.views.struct.api.View;
import fr.litopia.views.struct.impl.ViewImpl;

public abstract class RetourComonContext extends ViewImpl {
    protected Station station;
    protected RetourControler retourControler;
    protected Bornette bornette;

    public RetourComonContext(View view) {
        super(view);
    }

    @Override
    protected void onContextSet() {
        this.station = (Station) this.viewContext.getContext().get("station");
        this.retourControler = (RetourControler) this.viewContext.getContext().get("retourControler");
        this.bornette = (Bornette) this.viewContext.getContext().get("bornette");
        if(this.station == null || this.retourControler == null || this.bornette == null) {
            System.out.println("Erreur : RetourComonContext n'a pas pu récupérer le contexte");
            ReadingConsole.readLine();
            this.stop();
        }
    }
}