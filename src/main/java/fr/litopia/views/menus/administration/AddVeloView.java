package fr.litopia.views.menus.administration;

import fr.litopia.controler.api.AdministrationControler;
import fr.litopia.model.Velo;
import fr.litopia.views.struct.api.View;
import fr.litopia.views.struct.api.ViewContext;
import fr.litopia.views.struct.impl.ViewImpl;

public class AddVeloView extends ViewImpl {
    /**
     * Constructeur de toutes vues
     * Inisialise le state a INIT
     * Appel la methode init
     * Nettoye la console
     *
     * @param parent
     */
    private AddVeloView addVeloView;
    private AdministrationControler addVeloControler;
    private Velo velo;


    public AddVeloView(View parent) {
        super(parent);
    }

    @Override
    public void setContext(ViewContext context){

    }

    @Override
    protected void onContextSet() {


    }

    @Override
    public void run() {

    }

    @Override
    protected void init() {
        this.addVeloView= new AddVeloView(this);

    }

    @Override
    protected void display() {

    }

    @Override
    protected void close() {

    }

    @Override
    public View stop() {
        return null;
    }
}
