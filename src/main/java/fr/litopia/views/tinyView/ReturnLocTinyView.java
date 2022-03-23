package fr.litopia.views.tinyView;

import fr.litopia.controller.ControlerFactory;
import fr.litopia.controller.api.RetraitControler;
import fr.litopia.model.LocationNonAbonne;
import fr.litopia.utils.ReadingConsole;
import fr.litopia.views.struct.impl.TinyViewImpl;

public class ReturnLocTinyView extends TinyViewImpl<LocationNonAbonne> {
    private RetraitControler retraitControler;
    private String code;

    @Override
    protected void init() {
        retraitControler = ControlerFactory.getRetraitControler();
    }

    @Override
    protected void display() {
        System.out.println("==================");
        System.out.println("Veuillez renseigner votre code (-1 pour annuler): ");
        code = ReadingConsole.readLineNumeric(20);
        if (code.equals("-1")) this.cancel();
    }

    @Override
    protected LocationNonAbonne getValue() {
        LocationNonAbonne loc = retraitControler.checkCode(code);
        if (loc==null){
            System.out.println("=================");
            System.out.println("CODE INCORRECT, VEUILLEZ SAISIR A NOUVEAU ou -1 pour anuler");
            System.out.println("==================");
        }
        return loc;
    }

}
