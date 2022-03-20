package fr.litopia.controler.impl;

import fr.litopia.controler.api.EmprunControler;
import fr.litopia.model.*;

public class EmprunControlerImpl extends ControlerImp implements EmprunControler {
    @Override
    public void init() {

    }

    @Override
    public boolean peutEmprunter(Station station) {
        return true;
    }

    @Override
    public LocationNonAbonne emprunterVeloNonAbonne(Station station, String cb) {
        return null;
    }

    @Override
    public void prendreVelo(Location loc) {

    }

    @Override
    public LocationAbonne emprunterVeloAbonne(Station station, Abonne abo) {
        return null;
    }
}
