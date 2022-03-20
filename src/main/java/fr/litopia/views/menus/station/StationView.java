package fr.litopia.views.menus.station;

import fr.litopia.model.Station;
import fr.litopia.utils.ReadingConsole;
import fr.litopia.views.menus.station.emprun.EmprunView;
import fr.litopia.views.struct.api.View;
import fr.litopia.views.struct.api.ViewContext;
import fr.litopia.views.struct.impl.ViewContextImpl;
import fr.litopia.views.struct.impl.ViewImpl;

import java.util.HashMap;

public class StationView extends ViewImpl {
    private Station station;
    private EmprunView emprunView;

    /**
     * @param parent la vue parente
     */
    public StationView(View parent) {
        super(parent);
    }


    @Override
    protected void onContextSet() {
        if(this.viewContext.getName().equals("StationsChooserView")) {
            this.station = (Station) this.viewContext.getContext().get("station");
        }

        if(this.station == null) {
            System.out.println("Erreur : StationView n'a pas pu se lier à la vue StationsChooserView");
            ReadingConsole.readLine();
            this.stop();
        }
    }

    @Override
    protected void init() {
        HashMap<String, Object> context = new HashMap<>();
        context.put("station", this.station);
        ViewContext viewContext = new ViewContextImpl(this.name, context);

        emprunView = new EmprunView(this);
        emprunView.setContext(viewContext);
    }

    @Override
    protected void display() {
        System.out.println("====================");
        System.out.println("Station : "+this.station.getAdresse());
        System.out.println("====================");
        System.out.println("1. Emprunter un vélo");
        System.out.println("2. Retourner un vélo");
        System.out.println("3. Retour");
        System.out.println("Votre choix : ");
        Integer choice = ReadingConsole.readInt(1,3);
        switch (choice) {
            case 1 -> emprunView.run();
            case 2 -> this.stop();
            case 3 -> this.stop();
        }
    }

    @Override
    protected void close() {

    }
}
