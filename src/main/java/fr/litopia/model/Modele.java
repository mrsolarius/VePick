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
    private Set<Velo> velos = new LinkedHashSet<>();

    @Column(name = "prix_horaire")
    private Double prixHoraire;

    public Modele() {
        velos = new LinkedHashSet<>();
    }

    public Modele(String name, Double prixHoraire) {
        velos = new LinkedHashSet<>();
        this.name = name;
        this.prixHoraire = prixHoraire;
    }

    public Double getPrixHoraire() {
        return prixHoraire;
    }

    public void setPrixHoraire(Double prixHoraire) {
        this.prixHoraire = prixHoraire;
    }

    public Set<Velo> getVelos() {
        return velos;
    }

    public void addVelo(Velo velo) {
        velos.add(velo);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}