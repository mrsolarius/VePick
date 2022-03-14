package fr.litopia.view;

import fr.litopia.view.enums.ViewStates;

public abstract class View {
    protected ViewStates state;

    /**
     * Constructeur de toutes vue necessite un controlleur permettant d'interagir avec le model
     */
    public View(){
        this.state = ViewStates.INIT;
        this.init();
        this.clean();
    }

    /**
     * Permet de lancer la vue
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
