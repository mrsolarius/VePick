package fr.litopia.views.struct.api;

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
     * @return View : lui meme pour chainage
     */
    View stop();
}
