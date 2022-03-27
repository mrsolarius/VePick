package fr.litopia.controler.impl;

import fr.litopia.controler.api.AdministrationControler;
import fr.litopia.model.Station;
import fr.litopia.model.enums.VStatus;

import java.util.Set;

public class AdministartionControlerImpl extends  ControlerImpl implements AdministrationControler {
    @Override
    public Set<VStatus> getStationStatusPossible() {
        return null;
    }

    @Override
    public void setStationStatus(Station station, VStatus vStatus) {

    }

    @Override
    public VStatus getStatusValueSelected(int number) {
        VStatus statut = null;
        switch (number){
            case 1:
                statut = VStatus.VMOINS;
                break;
            case 2:
                statut = VStatus.VNUL;
                break;
            case 3:
                statut = VStatus.VPLUS;
        }

        return statut;
    }

    @Override
    public void init() {

    }
}
