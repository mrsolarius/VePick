package fr.litopia.controller.api;

import fr.litopia.model.Abonne;

public interface AbonneControler extends Controler {
    /**
     * Permet de sauvegarder un abonne dans la base de données
     * @param abonne l'abonne à sauvegarder
     */
    void saveAbonne(Abonne abonne);

    /**
     * Permet de verifier que le login n'est pas déjà utilisé
     * @param login le login à vérifier
     * @return true si le login est disponible, false sinon
     */
    boolean loginExist(String login);

    /**
     * Permet de verifier le mot de passe d'un abonne en fonction de son login
     * @param login le login de l'abonne
     * @param password le mot de passe de l'abonne
     * @return true si le mot de passe est correct, false sinon ou si le login n'existe pas
     */
    boolean checkPassword(String login, String password);

    /**
     * Permet de récupérer un abonne en fonction de son login
     * @param login le login de l'abonne
     * @return l'abonne correspondant au login
     */
    Abonne getAbonne(String login);
}
