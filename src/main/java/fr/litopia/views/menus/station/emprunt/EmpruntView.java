package fr.litopia.views.menus.station.emprunt;

import fr.litopia.controler.ControlerFactory;
import fr.litopia.controler.api.EmpruntControler;
import fr.litopia.model.Bornette;
import fr.litopia.model.Station;
import fr.litopia.utils.ReadingConsole;
import fr.litopia.views.struct.api.View;
import fr.litopia.views.struct.api.ViewContext;
import fr.litopia.views.struct.impl.ViewContextImpl;
import fr.litopia.views.struct.impl.ViewImpl;

import java.util.HashMap;

public class EmpruntView extends ViewImpl {
    private Station station;
    private EmpruntNonAboView empruntNonAboView;
    private EmpruntControler empruntControler;
    private EmpruntAboView empruntAboView;

    /**
     * @param parent la vue parente
     */
    public EmpruntView(View parent) {
        super(parent);
    }


    @Override
    protected void onContextSet() {
        this.station = (Station) this.viewContext.getContext().get("station");
        if(this.station == null) {
            System.out.println("Erreur : EmprunView n'a pas pu récupérer la station");
            ReadingConsole.readLine();
            this.stop();
        }
    }

    @Override
    protected void init() {
        empruntControler = ControlerFactory.getEmprunControler();
        empruntNonAboView = new EmpruntNonAboView(this);
        empruntAboView = new EmpruntAboView(this);
    }

    @Override
    protected void display() {
        Bornette bornette = empruntControler.peutEmprunter(this.station);
        if(bornette != null) {
            HashMap<String, Object> context = new HashMap<>();
            context.put("bornette", bornette);
            context.put("emprunControler", empruntControler);
            ViewContext viewContext = new ViewContextImpl(this.name,context);
            empruntNonAboView.setContext(viewContext);
            empruntAboView.setContext(viewContext);
            this.clean();
            displayEmprun();
        } else {
            this.clean();
            displayError();
        }
    }

    private void displayEmprun(){
        System.out.println("=================");
        System.out.println("EMPRUNTER UN VÉLO");
        System.out.println("==================");
        System.out.println("1. Vous êtes abonné(e) ?");
        System.out.println("2. Vous n'êtes pas abonné(e) ?");
        System.out.println("3. Retour");
        System.out.println("Votre choix : ");
        Integer choice = ReadingConsole.readInt(1,3);
        switch (choice){
            case 1 -> empruntAboView.run();
            case 2 -> empruntNonAboView.run();
            case 3 -> this.stop();
        }
    }

    private void displayError(){
        System.out.println("=================");
        System.out.println("EMPRUNTER UN VÉLO");
        System.out.println("==================");
        System.out.println("Vous ne pouvez plus emprunter de vélo à cette station");
        System.out.println("Appuyez sur une touche pour revenir au menu");
        ReadingConsole.readLine();
        this.stop();
    }

    @Override
    protected void close() {

    }
}
