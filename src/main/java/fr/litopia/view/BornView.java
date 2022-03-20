package fr.litopia.view;

import fr.litopia.controler.BornControler;
import fr.litopia.model.LocationNonAbonne;
import fr.litopia.model.Station;
import fr.litopia.utils.ReadingConsole;
import fr.litopia.view.enums.BornViewStates;
import fr.litopia.view.impl.ViewImpl;

public class BornView extends ViewImpl {
    BornControler controler;
    BornViewStates localState;

    @Override
    protected void init() {
        this.controler = new BornControler(this);
        this.controler.init();
        this.localState = BornViewStates.MAIN_MENU;
    }

    public void setStation(Station station) {
        this.controler.setStation(station);
    }

    @Override
    protected void display() {
        switch (this.localState) {
            case MAIN_MENU -> this.displayMainMenu();
            case EMPRUNTER_VELO -> this.emprunterVelo();
            case EMPRUNTER_VELO_ABONNE -> this.emprunterVeloAbonne();
            case EMPRUNTER_VELO_NON_ABONNE -> this.emprunterVeloNonAbonne();
        }
    }

    private void displayMainMenu() {
        System.out.println("====================");
        System.out.println("Station : "+this.controler.getStation().getAdresse());
        System.out.println("====================");
        System.out.println("1. Emprunter un vélo");
        System.out.println("2. Retourner un vélo");
        System.out.println("3. Retour");
        System.out.println("Votre choix : ");
        Integer choice = ReadingConsole.readInt(1,3);
        switch (choice) {
            case 1 -> this.localState = BornViewStates.EMPRUNTER_VELO;
            case 2 -> this.localState = BornViewStates.RETOURNER_VELO;
            case 3 -> this.stop();
        }
    }


    private void emprunterVelo() {
        System.out.println("=================");
        System.out.println("EMPRUNTER UN VÉLO");
        System.out.println("==================");
        System.out.println("1. Vous êtes abonné ?");
        System.out.println("2. Vous n'êtes pas abonné ?");
        System.out.println("3. Retour");
        System.out.println("Votre choix : ");
        Integer choice = ReadingConsole.readInt(1,3);
        switch (choice) {
            case 1 -> this.localState = BornViewStates.EMPRUNTER_VELO_ABONNE;
            case 2 -> this.localState = BornViewStates.EMPRUNTER_VELO_NON_ABONNE;
            case 3 -> this.localState = BornViewStates.MAIN_MENU;
        }
    }

    private void emprunterVeloNonAbonne() {
        System.out.println("=================");
        System.out.println("EMPRUNTER UN VÉLO");
        System.out.println("==================");
        System.out.println("Veuillez renseigner votre numéro de carte bancaire : ");
        String cb = ReadingConsole.readLineNumeric(16);
        LocationNonAbonne loc = this.controler.emprunterVeloNonAbonne(cb);
        this.clean();
        System.out.println("=================");
        System.out.println("EMPRUNTER UN VÉLO");
        System.out.println("==================");
        System.out.println("Merci d'avoir choisie VePick !");
        System.out.println("Votre code d'emprunt est : "+loc.getCode());
        System.out.println("Veuillez le garder précieusement !");
        System.out.println("Il vous sera demandé lorsque vous retourner le vélo.");
        System.out.println("Appuyez sur entrée pour prendre votre vélo à la bornette n°"+loc.getVelo().getBornette().getNumero());
        System.out.println("==================");
        ReadingConsole.readLine();
        this.controler.prendreVelo(loc);
        this.clean();
        this.localState = BornViewStates.MAIN_MENU;
        System.out.println("=================");
        System.out.println("EMPRUNTER UN VÉLO");
        System.out.println("==================");
        System.out.println("Votre vélo est pris !");
        System.out.println("Veuillez le garder précieusement !");
        System.out.println("Appuyer sur entrée pour revenir au menu de la station.");
        System.out.println("==================");
        ReadingConsole.readLine();
        this.localState = BornViewStates.MAIN_MENU;
    }

    private void emprunterVeloAbonne() {
        //@todo
    }

    @Override
    protected void close() {

    }
}
