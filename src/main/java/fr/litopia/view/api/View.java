package fr.litopia.view.api;

public interface View {
    /**
     * Permet de definir le contexte de la vue
     * @param context : ViewContext
     */
    void setContext(ViewContext context);


    /**
     * Permet de lancer une vue
     */
    void run();

    /**
     * Permet de stopper la vue
     */
    void stop();
}
