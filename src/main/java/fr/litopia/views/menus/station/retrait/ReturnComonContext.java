package fr.litopia.views.menus.station.retrait;

import fr.litopia.controler.api.RetraitControler;
import fr.litopia.model.Bornette;
import fr.litopia.model.Station;
import fr.litopia.utils.ReadingConsole;
import fr.litopia.views.struct.api.View;
import fr.litopia.views.struct.impl.ViewImpl;

public abstract class ReturnComonContext extends ViewImpl {
    protected Station station;
    protected RetraitControler retraitControler;
    protected Bornette bornette;

    public ReturnComonContext(View view) {
        super(view);
    }

    @Override
    protected void onContextSet() {
        this.station = (Station) this.viewContext.getContext().get("station");
        this.retraitControler = (RetraitControler) this.viewContext.getContext().get("retraitControler");
        this.bornette = (Bornette) this.viewContext.getContext().get("bornette");
        if(this.station == null || this.retraitControler == null || this.bornette == null) {
            System.out.println("Erreur : ReturnComonContext n'a pas pu récupérer le contexte");
            ReadingConsole.readLine();
            this.stop();
        }
    }
}