package fr.litopia.controler;

import fr.litopia.controler.api.AbonneControler;
import fr.litopia.controler.api.EmprunControler;
import fr.litopia.controler.api.RetraitControler;
import fr.litopia.controler.api.StationsControler;
import fr.litopia.controler.impl.AbonneControlerImpl;
import fr.litopia.controler.impl.EmprunControlerImpl;
import fr.litopia.controler.impl.RetraitControlerImpl;
import fr.litopia.controler.impl.StationsControlerImpl;

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
        return new RetraitControlerImpl();
    }
}
