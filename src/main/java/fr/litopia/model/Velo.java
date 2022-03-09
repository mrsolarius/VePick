package fr.litopia.model;

import fr.litopia.model.enums.Etat;

import javax.persistence.*;
import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "LesVelos")
public class Velo {
    @Id
    @Column(name = "numero", nullable = false)
    private Long numero;

    @Column(name = "mise_en_service", nullable = false, updatable = false)
    private Date miseEnService;

    @Enumerated
    @Column(name = "etat", nullable = false)
    private Etat etat;

    @Column(name = "modele", nullable = false)
    private String modele;

    @OneToOne(mappedBy = "velo")
    private Bornette bornette;

    @OneToMany(mappedBy = "velo")
    private Set<Location> locations = new LinkedHashSet<>();

    public Set<Location> getLocations() {
        return locations;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }

    public Bornette getBornette() {
        return bornette;
    }

    public void setBornette(Bornette bornette) {
        this.bornette = bornette;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public Date getMiseEnService() {
        return miseEnService;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }
}