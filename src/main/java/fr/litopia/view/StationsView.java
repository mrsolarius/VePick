package fr.litopia.view;

import fr.litopia.controler.StationControler;
import fr.litopia.model.Station;
import fr.litopia.utils.ReadingConsole;
import fr.litopia.view.impl.ViewImpl;

import java.util.ArrayList;
import java.util.Set;

public class StationsView extends ViewImpl {

    private Set<Station> stationSet;
    private BornView bornView;
    private StationControler controler;

    @Override
    protected void init() {
        this.controler = new StationControler(this);
        this.stationSet = this.controler.getAllStations();
        bornView = new BornView();
    }

    @Override
    protected void display() {
        System.out.println("==========================");
        System.out.println("Liste des stations");
        System.out.println("==========================\n");
        ArrayList<Station> stationList = new ArrayList<>(this.stationSet);
        for (int i = 0; i < stationList.size(); i++) {
            System.out.println(i + " : " + stationList.get(i).getVStatus()+" "+stationList.get(i).getAdresse());
        }
        System.out.println("\n==========================");
        System.out.println("A quelle station voulez-vous aller ? (-1 pour quitter)");
        Integer selectedStation = ReadingConsole.readInt(-1, stationList.size()-1);
        if (selectedStation == -1) {
            this.stop();
        }else {
            bornView.setStation(stationList.get(selectedStation));
            bornView.run();
        }
    }

    @Override
    protected void close() {

    }
}
