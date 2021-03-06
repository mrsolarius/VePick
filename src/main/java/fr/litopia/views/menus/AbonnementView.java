package fr.litopia.views.menus;

import fr.litopia.controler.api.AbonneControler;
import fr.litopia.controler.ControlerFactory;
import fr.litopia.model.Abonne;
import fr.litopia.utils.ReadingConsole;
import fr.litopia.views.struct.api.View;
import fr.litopia.views.struct.impl.ViewImpl;

public class AbonnementView extends ViewImpl {

    private AbonneControler controler;

    /**
     * @param parent la vue parente
     */
    public AbonnementView(View parent) {
        super(parent);
    }

    @Override
    protected void onContextSet() {

    }

    @Override
    protected void init() {
        this.controler = ControlerFactory.getAbonneControler();
    }

    @Override
    protected void display() {
        Abonne abo = new Abonne();
        System.out.println("==========================");
        System.out.println("CREER UN COMPTE ABONNÉ");
        System.out.println("==========================");
        displayLogin(abo);
        displayNom(abo);
        displayPrenom(abo);
        displayAdresse(abo);
        displayMdp(abo);
        displayCb(abo);
        controler.saveAbonne(abo);
        this.stop();
    }

    private void displayLogin(Abonne abo) {
        System.out.println("Choisissez un login :");
        String login = ReadingConsole.readLineWithMaxChar(20);
        while (controler.loginExist(login)) {
            System.out.println("Ce login existe déjà, choisissez un nouveau login :");
            login = ReadingConsole.readLineWithMaxChar(20);
        }
        abo.setLogin(login);
    }

    private void displayNom(Abonne abo) {
        System.out.println("Rentrez votre nom de famille :");
        String nom = ReadingConsole.readLineWithMaxChar(50);
        abo.setNom(nom);
    }

    private void displayPrenom(Abonne abo) {
        System.out.println("Rentrez votre prenom :");
        String prenom = ReadingConsole.readLineWithMaxChar(50);
        abo.setPrenom(prenom);
    }

    private void displayAdresse(Abonne abo) {
        System.out.println("Rentrez votre adresse :");
        String adresse = ReadingConsole.readLineWithMaxChar(255);
        abo.setAdresse(adresse);
    }

    private void displayMdp(Abonne abo) {
        System.out.println("Rentrez votre mot de passe :");
        String mdp = ReadingConsole.readLineWithMaxChar(20);
        abo.setMdp(mdp);
    }

    private void displayCb(Abonne abo) {
        System.out.println("Rentrez votre code bancaire (non ceci n'est pas une arnaque) :");
        String cb = ReadingConsole.readLine(16);
        abo.setCb(cb);
    }

    @Override
    protected void close() {

    }
}
