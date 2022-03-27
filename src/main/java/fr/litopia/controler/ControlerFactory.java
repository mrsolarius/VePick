package fr.litopia.controler;

import fr.litopia.controler.api.*;
import fr.litopia.controler.impl.*;

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

    public static RetourControler getRetraitControler(){
        return new RetourControlerImpl();
    }

    public static AdministrationControler getAdministrationControler(){
        return new AdministartionControlerImpl();
    }
}
