package fr.litopia.views.menus.station.retrait;

import fr.litopia.controller.ControlerFactory;
import fr.litopia.controller.api.RetraitControler;
import fr.litopia.model.Station;
import fr.litopia.utils.ReadingConsole;
import fr.litopia.views.struct.api.View;
import fr.litopia.views.struct.api.ViewContext;
import fr.litopia.views.struct.impl.ViewContextImpl;
import fr.litopia.views.struct.impl.ViewImpl;

import java.util.HashMap;

public class ReturnView extends ViewImpl {
    private Station station;
    private RetraitControler retraitControler;
    private ReturnAboView returnAboView;
    private ReturnNonAboView returnNonAboView;

    /**
     * @param parent la vue parente
     */
    public ReturnView(View parent) {
        super(parent);
    }

    @Override
    protected void onContextSet() {
        this.station = (Station) this.viewContext.getContext().get("station");
        if(this.station == null) {
            System.out.println("Erreur : ReturnView n'a pas pu récupérer la station");
            ReadingConsole.readLine();
            this.stop();
        }
    }

    @Override
    protected void init() {
        retraitControler = ControlerFactory.getRetraitControler();

        HashMap<String, Object> context = new HashMap<>();
        context.put("station", this.station);
        context.put("retraitControler", retraitControler);

        ViewContext viewContext = new ViewContextImpl(this.name,context);

        returnAboView = new ReturnAboView(this);
        returnAboView.setContext(viewContext);

        returnNonAboView = new ReturnNonAboView(this);
        returnNonAboView.setContext(viewContext);
    }

    @Override
    protected void display() {
        if(retraitControler.peutRendre(this.station)){
            displayMenu();
        }else {
            displayError();
        }
    }

    private void displayMenu(){
        System.out.println("==============");
        System.out.println("RENDRE UN VÉLO");
        System.out.println("===============");
        System.out.println("1. Vous êtes abonné ?");
        System.out.println("2. Vous n'êtes pas abonné ?");
        System.out.println("3. Retour");
        System.out.println("Votre choix : ");
        Integer choice = ReadingConsole.readInt(1,3);
        switch (choice){
            case 1 -> returnAboView.run();
            case 2 -> returnNonAboView.run();
            case 3 -> this.stop();
        }
    }

    private void displayError(){
        System.out.println("==============");
        System.out.println("RENDRE UN VÉLO");
        System.out.println("===============");
        System.out.println("Vous ne pouvez plus emprunter de vélo à cette station");
        System.out.println("Appuyez sur une touche pour revenir au menu");
        ReadingConsole.readLine();
        this.stop();
    }

    @Override
    protected void close() {

    }
}
