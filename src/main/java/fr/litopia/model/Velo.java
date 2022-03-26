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

    @Enumerated(EnumType.STRING)
    @Column(name = "etat",length = 11, nullable = false)
    private Etat etat;

    @OneToOne(mappedBy = "velo")
    private Bornette bornette;

    @OneToMany(mappedBy = "velo")
    private Set<Location> locations = new LinkedHashSet<>();

    @ManyToOne(optional = false)
    @JoinColumn(name = "modele_name", nullable = false, updatable = false)
    private Modele modele;

    public Velo() {
        locations = new LinkedHashSet<>();
    }

    public Velo(Date miseEnService, Etat etat, Modele modele) {
        locations = new LinkedHashSet<>();
        this.miseEnService = miseEnService;
        this.etat = etat;
        this.modele = modele;
        modele.addVelo(this);
    }

    public Modele getModele() {
        return modele;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public Bornette getBornette() {
        return bornette;
    }

    public void setBornette(Bornette bornette) {
        if(this.bornette==null){
            this.bornette = bornette;
            bornette.setVelo(this);
        }
        if(bornette==null){
            if(this.bornette.getVelo()!=null)this.bornette.takeVelo();
            this.bornette = null;
        }
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

    public void addLocation(Location location) {
        if (location.getVelo()!=this) location.setVelo(this);
        this.locations.add(location);
    }
}