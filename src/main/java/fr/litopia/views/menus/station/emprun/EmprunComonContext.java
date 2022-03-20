package fr.litopia.views.menus.station.emprun;

import fr.litopia.controller.api.EmprunControler;
import fr.litopia.model.Station;
import fr.litopia.utils.ReadingConsole;
import fr.litopia.views.struct.api.View;
import fr.litopia.views.struct.impl.ViewImpl;

public abstract class  EmprunComonContext extends ViewImpl {
    protected Station station;
    protected EmprunControler emprunControler;

    public EmprunComonContext(View view) {
        super(view);
    }

    @Override
    protected void onContextSet() {
        this.station = (Station) this.viewContext.getContext().get("station");
        this.emprunControler = (EmprunControler) this.viewContext.getContext().get("emprunControler");
        if(this.station == null || this.emprunControler == null) {
            System.out.println("Erreur : EmprunNonAboView n'a pas pu récupérer le contexte");
            ReadingConsole.readLine();
            this.stop();
        }
    }
}
