package fr.litopia.view;

import fr.litopia.controler.StationControler;
import fr.litopia.model.Station;
import fr.litopia.utils.ReadingConsole;
import fr.litopia.view.api.ViewContext;
import fr.litopia.view.impl.ViewContextImpl;
import fr.litopia.view.impl.ViewImpl;

import java.util.ArrayList;
import java.util.HashMap;

public class StationsChooserView extends ViewImpl {

    private ArrayList<Station> stationList;
    private StationView bornView;

    @Override
    protected void onContextSet() {

    }

    @Override
    protected void init() {
        StationControler controler = new StationControler();
        this.stationList = new ArrayList<>(controler.getAllStations());
        bornView = new StationView();
    }

    @Override
    protected void display() {
        System.out.println("==========================");
        System.out.println("Liste des stations");
        this.displayStation(this.stationList);
        System.out.println("A quelle station voulez-vous aller ? (-1 pour quitter)");
        Integer selectedStation = ReadingConsole.readInt(-1, this.stationList.size()-1);
        if (selectedStation == -1) {
            this.stop();
        }else {
            HashMap <String, Object> context = new HashMap<>();
            context.put("selectedStation", stationList.get(selectedStation));
            ViewContext viewContext = new ViewContextImpl(this.name,context);
            bornView.setContext(viewContext);
            bornView.run();
        }
    }

    private void displayStation(ArrayList<Station> stationList) {
        System.out.println("==========================\n");
        for (int i = 0; i < stationList.size(); i++) {
            System.out.println(i + " : " + stationList.get(i).getVStatus()+" "+stationList.get(i).getAdresse());
        }
        System.out.println("\n==========================");
    }

    @Override
    protected void close() {

    }
}
