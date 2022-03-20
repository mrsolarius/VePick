package fr.litopia.views.menus;

import fr.litopia.utils.ReadingConsole;
import fr.litopia.views.struct.api.View;
import fr.litopia.views.struct.api.ViewContext;
import fr.litopia.views.struct.enums.ViewStates;
import fr.litopia.views.struct.impl.ViewContextImpl;
import fr.litopia.views.struct.impl.ViewImpl;

public class VepickView extends ViewImpl {

    private StationsChooserView stationView;
    private AbonnementView abonnementView;
    private DataBDDView dataBDDView;

    /**
     * @param parent la vue parente
     */
    public VepickView(View parent) {
        super(parent);
    }

    @Override
    protected void onContextSet() {

    }

    @Override
    protected void init() {
        ViewContext context = new ViewContextImpl(this.name);
        stationView = new StationsChooserView(this);
        abonnementView = new AbonnementView(this);
        dataBDDView = new DataBDDView(this);
        stationView.setContext(context);
        abonnementView.setContext(context);
        dataBDDView.setContext(context);
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
