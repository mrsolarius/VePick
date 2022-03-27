package fr.litopia.repository.api;

import java.util.Set;

/**
 * Un repository de base qui permet de faire toutes les opérations de CURD
 * @param <T> Le type de l'entité
 * @param <I> Le type de l'identifiant
 */
public interface Repository<T, I> {

    /**
     * Sauvegarder ou mettre à jour une entité.
     * @param entity l'entité à sauvegarder
     */
    void save(T entity);

    /**
     * Supprimer une entité.
     * @param entity  entity à supprimer
     */
    void delete(T entity);

    /**
     * Recuperer une entité par son identifiant
     * @param id identifiant de l'entité
     * @return l'entité ou null si elle n'existe pas
     */
    T findById(I id);

    /**
     * Recuperer toutes les entités du type de la classe
     * @return toutes les entités stocker en BDD dans un set
     */
    Set<T> getAll();

}