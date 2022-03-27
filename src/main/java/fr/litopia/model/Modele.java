package fr.litopia.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "LesModeles")
public class Modele {
    @Id
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "modele", orphanRemoval = true)
    private Set<Velo> velos;

    @Column(name = "prix_horaire")
    private Double prixHoraire;

    /**
     * Constructeur vide pour la persistance
     */
    public Modele() {
        velos = new LinkedHashSet<>();
    }

    /**
     * Constructeur de Modele
     * @param name Nom du modèle
     * @param prixHoraire Prix horaire du modèle
     */
    public Modele(String name, Double prixHoraire) {
        velos = new LinkedHashSet<>();
        this.name = name;
        this.prixHoraire = prixHoraire;
    }

    /**
     * Getter du prix horaire
     * @return prix horaire
     */
    public Double getPrixHoraire() {
        return prixHoraire;
    }

    /**
     * Setter du prix horaire
     * @param prixHoraire prix horaire (oui on peut mettre un prix négatif donnons de l'argent à nos usagers !)
     */
    public void setPrixHoraire(Double prixHoraire) {
        this.prixHoraire = prixHoraire;
    }

    /**
     * Getter de la liste des velos du modèle
     * @return liste des velos du modèle
     */
    public Set<Velo> getVelos() {
        return velos;
    }

    /**
     * Ajoute un velo au modèle
     * @param velo velo à ajouter
     */
    public void addVelo(Velo velo) {
        velos.add(velo);
    }

    /**
     * Getter du nom du modèle
     * @return nom du modèle
     */
    public String getName() {
        return name;
    }

    /**
     * Setter du nom du modèle
     * @param name nom du modèle
     */
    public void setName(String name) {
        this.name = name;
    }
}