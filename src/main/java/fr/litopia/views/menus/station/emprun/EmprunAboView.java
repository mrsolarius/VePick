package fr.litopia.views.menus.station.emprun;

import fr.litopia.model.Abonne;
import fr.litopia.model.LocationAbonne;
import fr.litopia.utils.ReadingConsole;
import fr.litopia.views.struct.api.View;
import fr.litopia.views.tinyView.LoginTinyView;

public class EmprunAboView extends EmprunComonContext {
    private LoginTinyView login;

    public EmprunAboView(View view) {
        super(view);
    }

    @Override
    protected void init() {
        login = new LoginTinyView();
    }

    @Override
    protected void display() {
        Abonne abo = login.startAndGetValue();
        if (abo == null) {
            System.out.println("Echec de la connexion");
            System.out.println("Vous allez être redirigé vers la page d'accueil (appuyez sur entrée pour continuer)");
            ReadingConsole.readLine();
            this.stop().stop();
            return;
        }
        System.out.println("=================");
        System.out.println("EMPRUNTER UN VÉLO");
        System.out.println("==================");
        System.out.println("Vous êtes connecté en tant que " + abo.getLogin());
        System.out.println("Appuyez sur entrée pour louer un vélo");
        ReadingConsole.readLine();
        LocationAbonne loc = this.emprunControler.emprunterVeloAbonne(station, abo);

        System.out.println("Merci d'avoir choisie VePick !");
        System.out.println("Appuyez sur entrée pour prendre votre vélo à la bornette n°"+loc.getVelo().getBornette().getNumero());
        System.out.println("==================");
        ReadingConsole.readLine();
        this.emprunControler.prendreVelo(loc);
        this.stop().stop();
    }

    @Override
    protected void close() {

    }
}
