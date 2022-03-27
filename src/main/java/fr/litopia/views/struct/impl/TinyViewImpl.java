package fr.litopia.views.struct.impl;

import fr.litopia.views.struct.api.TinyView;

public abstract class TinyViewImpl<T> implements TinyView<T> {
    private boolean cancele = false;

    public TinyViewImpl() {
        init();
    }

    @Override
    public T startAndGetValue(){
        T value = null;
        while (value==null && !cancele){
            display();
            value = getValue();
            clean();
        }
        if (cancele){
            value = null;
        }
        clean();
        return value;
    }

    /**
     * Fonction d'initialisation
     * Appelé au début de l'execution de la fonction startAndGetValue
     */
    protected abstract void init();

    /**
     * Fonction de mise à jour de l'affichage
     * Appelé à chaque tour de boucle de l'execution de la fonction startAndGetValue
     */
    protected abstract void display();

    /**
     * Fonction de récupération de la valeur
     * Appelé à la fin de l'execution de la fonction startAndGetValue
     * @return la valeur ou null si non valide
     */
    protected abstract T getValue();

    /**
     * Fonction de nettoyage
     * Permet de nettoyer la console
     * Peut être appelé à tous moments
     * Appelé à la fin de l'execution de la fonction startAndGetValue
     *
     */
    protected void clean(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Fonction d'annulation de la saisie
     * Permet d'annuler l'execution de la fonction startAndGetValue
     * Si la fonction est appelée, la fonction getValue renverra null
     */
    protected void cancel(){
        System.out.println("Canceled");
        cancele = true;
    }
}
