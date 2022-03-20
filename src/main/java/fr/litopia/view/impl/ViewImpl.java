package fr.litopia.view.impl;

import fr.litopia.view.api.View;
import fr.litopia.view.api.ViewContext;
import fr.litopia.view.enums.ViewStates;

public abstract class ViewImpl implements View {
    protected ViewStates state;
    protected ViewContext viewContext;
    protected final String name;



    /**
     * Constructeur de toutes vues
     * Inisialise le state a INIT
     * Appel la methode init
     * Nettoye la console
     */
    public ViewImpl(){
        this.name = this.getClass().getSimpleName();
        this.state = ViewStates.INIT;
        this.init();
        this.clean();
    }

    /**
     * Permet de definir le context de la vue
     * Ne peut etre appele que lors de l'initialisation
     * @param viewContext le context de la vue
     */
    public void setContext(ViewContext viewContext){
        if (this.state == ViewStates.INIT) {
            this.viewContext = viewContext;
            this.onContextSet();
        }
    }

    protected abstract void onContextSet();

    /**
     * Permet de lancer la vue
     * La vue reste active tant que le state est different de END
     */
    public void run(){
        this.state = ViewStates.RUNNING;
        while (this.state != ViewStates.END){
            this.clean();
            this.display();
        }
        this.close();
    }

    /**
     * Permet de nettoyer la console
     */
    protected void clean(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Permet d'initialiser la vue
     */
    protected abstract void init();

    /**
     * Permet d'afficher la vue
     */
    protected abstract void display();

    /**
     * Permet de fermer la vue
     */
    protected abstract void close();

    /**
     * Permet de stopper la vue
     */
    public void stop(){
        this.state = ViewStates.END;
    }
}
