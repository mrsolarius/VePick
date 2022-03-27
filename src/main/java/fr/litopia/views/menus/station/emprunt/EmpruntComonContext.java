package fr.litopia.views.menus.station.emprunt;

import fr.litopia.controler.api.EmprunControler;
import fr.litopia.model.Bornette;
import fr.litopia.utils.ReadingConsole;
import fr.litopia.views.struct.api.View;
import fr.litopia.views.struct.impl.ViewImpl;

public abstract class EmpruntComonContext extends ViewImpl {
    protected Bornette bornette;
    protected EmprunControler emprunControler;

    public EmpruntComonContext(View view) {
        super(view);
    }

    @Override
    protected void onContextSet() {
        this.bornette = (Bornette) this.viewContext.getContext().get("bornette");
        this.emprunControler = (EmprunControler) this.viewContext.getContext().get("emprunControler");
        if(this.bornette == null || this.emprunControler == null) {
            System.out.println("Erreur : EmprunComonContext n'a pas pu récupérer le contexte");
            ReadingConsole.readLine();
            this.stop();
        }
    }
}
