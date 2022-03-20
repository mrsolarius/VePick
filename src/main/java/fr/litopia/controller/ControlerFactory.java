package fr.litopia.controller;

import fr.litopia.controller.api.AbonneControler;
import fr.litopia.controller.api.EmprunControler;
import fr.litopia.controller.api.RetraitControler;
import fr.litopia.controller.api.StationsControler;
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
}
