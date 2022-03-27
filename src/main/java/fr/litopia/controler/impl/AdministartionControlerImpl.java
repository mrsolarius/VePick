package fr.litopia.controller.impl;

import fr.litopia.controller.api.AdministrationControler;
import fr.litopia.model.Station;
import fr.litopia.model.enums.VStatus;

import java.util.Set;

public class AdministartionControlerImpl extends  ControlerImp implements AdministrationControler {
    @Override
    public Set<VStatus> getStationStatusPossible() {
        return null;
    }

    @Override
    public void setStationStatus(Station station, VStatus vStatus) {

    }

    @Override
    public VStatus getStatusValueSelected(int number) {
        return null;
    }

    @Override
    public void init() {

    }
}
