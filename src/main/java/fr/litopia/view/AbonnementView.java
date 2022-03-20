package fr.litopia.view;

import fr.litopia.controler.AbonnementControler;
import fr.litopia.model.Abonne;
import fr.litopia.utils.ReadingConsole;
import fr.litopia.view.impl.ViewImpl;

public class AbonnementView extends ViewImpl {

    private AbonnementControler controler;
    @Override
    protected void init() {
        this.controler = new AbonnementControler(this);
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
        controler.createAbonne(abo);
        this.stop();
    }

    private void displayLogin(Abonne abo) {
        System.out.println("Choisissez un login :");
        String login = ReadingConsole.readLine();
        while (controler.LoginExists(login)) {
            System.out.println("Ce login existe déjà, choisissez un nouveau login :");
            login = ReadingConsole.readLine();
        }
        abo.setLogin(login);
    }

    private void displayNom(Abonne abo) {
        System.out.println("Rentrez votre nom de famille :");
        String nom = ReadingConsole.readLine();
        abo.setNom(nom);
    }

    private void displayPrenom(Abonne abo) {
        System.out.println("Rentrez votre prenom :");
        String prenom = ReadingConsole.readLine();
        abo.setPrenom(prenom);
    }

    private void displayAdresse(Abonne abo) {
        System.out.println("Rentrez votre adresse :");
        String adresse = ReadingConsole.readLine();
        abo.setAdresse(adresse);
    }

    private void displayMdp(Abonne abo) {
        System.out.println("Rentrez votre mot de passe :");
        String mdp = ReadingConsole.readLine();
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
