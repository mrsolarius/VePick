package fr.litopia.controller;

import fr.litopia.controller.api.*;
import fr.litopia.controller.impl.AbonneControlerImpl;
import fr.litopia.controller.impl.EmprunControlerImpl;
import fr.litopia.controller.impl.StationsControlerImpl;

public class ControlerFactory {
    public static EmprunControler getEmprunControler(){
        return new EmprunControlerImpl();
    }

    public static AbonneControler getAbonneControler(){
        return new AbonneControlerImpl();
    }

    public static StationsControler getStationsControler(){
        return new StationsControlerImpl();
    }

    public static RetraitControler getRetraitControler(){
        return null;
    }

    public static AdministrationControler getAdministrationControler(){return null;}
}
