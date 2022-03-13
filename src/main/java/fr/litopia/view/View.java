package fr.litopia.view;
import fr.litopia.controler.Controler;

public abstract class View {
    private ViewState state;
    protected Controler controler;

    /**
     * Constructeur de toutes vue necessite un controlleur permettant d'interagir avec le model
     * @param controler controller de la vue
     */
    public View(Controler controler){
        this.state = ViewState.INIT;
        this.controler = controler;
        this.init();
    }

    /**
     * Permet de lancer la vue
     */
    private void run(){
        this.state = ViewState.RUNNING;
        while (this.state != ViewState.END){
            this.display();
            this.update();
        }
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
     * Permet de mettre a jour la vue
     */
    protected abstract void update();

    /**
     * Permet de fermer la vue
     */
    protected abstract void close();
}
