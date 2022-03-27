package fr.litopia.controler;

import fr.litopia.controler.api.AbonneControler;
import fr.litopia.controler.api.EmpruntControler;
import fr.litopia.controler.api.RetourControler;
import fr.litopia.controler.api.StationsControler;
import fr.litopia.controler.impl.AbonneControlerImpl;
import fr.litopia.controler.impl.EmpruntControlerImpl;
import fr.litopia.controler.impl.RetourControlerImpl;
import fr.litopia.controler.impl.StationsControlerImpl;

public class ControlerFactory {
    public static EmpruntControler getEmprunControler(){
        return new EmpruntControlerImpl();
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
}
