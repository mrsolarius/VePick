package fr.litopia.views.menus.administration;

import fr.litopia.utils.ReadingConsole;
import fr.litopia.views.struct.api.View;
import fr.litopia.views.struct.impl.ViewImpl;

public class AddBornetesView extends ViewImpl {
    /**
     * Constructeur de toutes vues
     * Inisialise le state a INIT
     * Appel la methode init
     * Nettoye la console
     *
     * @param parent
     */
    public AddBornetesView(View parent) {
        super(parent);
    }

    @Override
    protected void onContextSet() {

    }

    @Override
    protected void init() {

    }

    @Override
    protected void display() {
        System.out.println("================================");
        System.out.println("Bienvenue dans l'edition d'une station ");
        System.out.println("================================");
        System.out.println("\n Que voulez-vous faire ?\n");

        System.out.println("1. modifier le status");

        System.out.println("2. ajouter des bornettes");

        System.out.println("3. ajouter des velos");

        System.out.println("4. quitter");
        System.out.println("\nVotre choix : ");


        Integer choice = ReadingConsole.readInt(1,4);

    }

    @Override
    protected void close() {

    }
}
