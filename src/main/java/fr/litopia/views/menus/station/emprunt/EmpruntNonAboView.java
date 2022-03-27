package fr.litopia.views.menus.station.emprunt;

import fr.litopia.model.LocationNonAbonne;
import fr.litopia.utils.ReadingConsole;
import fr.litopia.views.struct.api.View;

public class EmpruntNonAboView extends EmpruntComonContext {

    public EmpruntNonAboView(View view) {
        super(view);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void display() {
        System.out.println("=================");
        System.out.println("EMPRUNTER UN VÉLO");
        System.out.println("==================");
        System.out.println("Veuillez renseigner votre numéro de carte bancaire : ");
        String cb = ReadingConsole.readLineNumeric(16);
        LocationNonAbonne loc = this.empruntControler.emprunterVeloNonAbonne(this.bornette,cb);
        this.clean();
        System.out.println("=================");
        System.out.println("EMPRUNTER UN VÉLO");
        System.out.println("==================");
        System.out.println("Merci d'avoir choisi VePick !");
        System.out.println("Votre code d'emprunt est : "+loc.getCode());
        System.out.println("Veuillez le garder précieusement !");
        System.out.println("Il vous sera demandé lorsque vous retourner le vélo.");
        System.out.println("Appuyez sur entrée pour prendre votre vélo à la bornette n°"+loc.getVelo().getBornette().getNumero());
        System.out.println("==================");
        ReadingConsole.readLine();
        this.empruntControler.prendreVelo(this.bornette);
        //On stop cette vue ainsi que la vue du dessus d'emprunt de vélo
        this.stop().stop();
    }

    @Override
    protected void close() {

    }
}
