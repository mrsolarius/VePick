package fr.litopia.views.struct.api;

public interface TinyView<T> {
    /**
     * Permet de démarer et récupérer le contenue de la tinyView
     * @return T la valeur attendue ou null si la valeurs na pas étais trouvé
     */
    T startAndGetValue();
}
