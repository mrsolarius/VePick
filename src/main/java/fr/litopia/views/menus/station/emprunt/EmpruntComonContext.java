package fr.litopia.views.menus.station.emprunt;

import fr.litopia.controler.api.EmpruntControler;
import fr.litopia.model.Bornette;
import fr.litopia.utils.ReadingConsole;
import fr.litopia.views.struct.api.View;
import fr.litopia.views.struct.impl.ViewImpl;

public abstract class EmpruntComonContext extends ViewImpl {
    protected Bornette bornette;
    protected EmpruntControler empruntControler;

    public EmpruntComonContext(View view) {
        super(view);
    }

    @Override
    protected void onContextSet() {
        this.bornette = (Bornette) this.viewContext.getContext().get("bornette");
        this.empruntControler = (EmpruntControler) this.viewContext.getContext().get("emprunControler");
        if(this.bornette == null || this.empruntControler == null) {
            System.out.println("Erreur : EmprunComonContext n'a pas pu récupérer le contexte");
            ReadingConsole.readLine();
            this.stop();
        }
    }
}
