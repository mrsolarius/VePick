package fr.litopia.controler;

import fr.litopia.model.LocationNonAbonne;
import fr.litopia.model.Station;
import fr.litopia.view.View;

public class BornControler extends Controler{
    private Station station;
    public BornControler(View view) {
        super(view);
    }

    public void init() {
    }

    public void setStation(Station station){
        this.station = station;
    }

    public Station getStation(){
        return this.station;
    }


    public LocationNonAbonne emprunterVeloNonAbonne(String cb) {
        //@TODO : implementer
        return null;
    }

    public boolean emprunterVeloAbonne(String mdp) {
        //@TODO : implementer
        return true;
    }

    public void prendreVelo(LocationNonAbonne loc) {
    }
}
