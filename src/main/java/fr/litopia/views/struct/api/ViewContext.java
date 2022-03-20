package fr.litopia.views.struct.api;

import java.util.HashMap;

public interface ViewContext {
    /**
     * Permet de récupérer une valeur dans le contexte
     * @return Le nom de la vue courante
     */
    String getName();

    /**
     * Permet de récupérer une valeur dans le contexte
     * Chaque clé est unique et est associée à une valeur
     * qui peut être de n'importe quel type
     * @return Les données du contextes
     */
    HashMap<String,Object> getContext();

}
