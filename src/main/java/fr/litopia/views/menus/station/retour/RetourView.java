package fr.litopia.views.menus.station.retour;

import fr.litopia.controler.ControlerFactory;
import fr.litopia.controler.api.RetraitControler;
import fr.litopia.model.Bornette;
import fr.litopia.model.Station;
import fr.litopia.utils.ReadingConsole;
import fr.litopia.views.struct.api.View;
import fr.litopia.views.struct.api.ViewContext;
import fr.litopia.views.struct.impl.ViewContextImpl;
import fr.litopia.views.struct.impl.ViewImpl;

import java.util.HashMap;

public class RetourView extends ViewImpl {
    private Station station;
    private Bornette bornette;
    private RetraitControler retraitControler;
    private RetourAboView retourAboView;
    private RetourNonAboView retourNonAboView;

    /**
     * @param parent la vue parente
     */
    public RetourView(View parent) {
        super(parent);
    }

    @Override
    protected void onContextSet() {
        this.station = (Station) this.viewContext.getContext().get("station");
        if(this.station == null) {
            System.out.println("Erreur : RetourView n'a pas pu récupérer la station");
            ReadingConsole.readLine();
            this.stop();
        }
    }

    @Override
    protected void init() {
        retraitControler = ControlerFactory.getRetraitControler();
        retourAboView = new RetourAboView(this);
        retourNonAboView = new RetourNonAboView(this);
    }

    @Override
    protected void display() {
        bornette = retraitControler.peutRendre(this.station);
        this.clean();
        if(bornette!=null){
            displayMenu();
        }else {
            displayError();
        }
    }

    private ViewContext createViewContext(){
        HashMap<String, Object> context = new HashMap<>();
        context.put("station", this.station);
        context.put("retraitControler", retraitControler);
        context.put("bornette",bornette);
        return new ViewContextImpl(this.name,context);
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
        retourAboView.setContext(createViewContext());
        retourNonAboView.setContext(createViewContext());
        switch (choice){
            case 1 -> retourAboView.run();
            case 2 -> retourNonAboView.run();
            case 3 -> this.stop();
        }
    }

    private void displayError(){
        System.out.println("==============");
        System.out.println("RENDRE UN VÉLO");
        System.out.println("===============");
        System.out.println("Vous ne pouvez plus rendre de vélo à cette station");
        System.out.println("Appuyez sur une touche pour revenir au menu");
        ReadingConsole.readLine();
        this.stop();
    }

    @Override
    protected void close() {

    }
}
