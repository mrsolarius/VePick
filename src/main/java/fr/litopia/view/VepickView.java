package fr.litopia.view;

import fr.litopia.utils.ReadingConsole;
import fr.litopia.view.enums.ViewStates;
import fr.litopia.view.impl.ViewImpl;

public class VepickView extends ViewImpl {

    private StationsView stationView;
    private AbonnementView abonnementView;
    private DataBDDView dataBDDView;

    @Override
    protected void init() {
        stationView = new StationsView();
        abonnementView = new AbonnementView();
        dataBDDView = new DataBDDView();
    }

    @Override
    protected void display() {
        System.out.println("================================");
        System.out.println("Bienvenue dans le system VePick");
        System.out.println("================================");
        System.out.println("\n Que voulez-vous faire ?\n");
        //**[B1][B2][B3][B4][B5][B6]**[B8][B9]
        System.out.println("1. vous rendre à une station pour louer ou rendre un vélo");
        //**[B7]**
        System.out.println("2. vous abonné au service VePick");
        //[B10][A31][A32]
        System.out.println("3. administrer les stations");
        System.out.println("4. administrer les jeux de données");
        System.out.println("5. quitter");
        System.out.println("\nVotre choix : ");
        Integer choice = ReadingConsole.readInt(1,5);

        switch (choice) {
            case 1 -> stationView.run();
            /*case 2 -> {
                //@TODO Faire la vue d'abonnement
                this.clean();
                System.out.println("Vous êtes désormais abonné au service VePick (c'est faux)");
                System.out.println("Appuyer sur enter pour continuer");
                ReadingConsole.readLine();
            }*/
            case 2 -> abonnementView.run();
            case 3 -> {
                //@TODO Faire la vue d'administration
                this.clean();
                System.out.println("Vous êtes désormais administrateur (c'est faux)");
                System.out.println("Appuyer sur enter pour continuer");
                ReadingConsole.readLine();
            }
            case 4 -> dataBDDView.run();
            case 5 -> this.state = ViewStates.END;
        }
    }

    @Override
    protected void close() {

    }
}
