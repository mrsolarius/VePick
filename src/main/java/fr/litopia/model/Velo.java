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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "numero", nullable = false)
    private Long numero;

    @Column(name = "mise_en_service", nullable = false, updatable = false)
    //date par defaut
    private Date miseEnService= new Date(20210406);

    @Enumerated(EnumType.STRING)
    @Column(name = "etat",length = 11, nullable = false)
    private Etat etat;

    @OneToOne(mappedBy = "velo")
    private Bornette bornette;

    @OneToMany(mappedBy = "velo")
    private Set<Location> locations = new LinkedHashSet<>();

    @ManyToOne(optional = false)
    @JoinColumn(name = "modele_name", nullable = false)
    private Modele modele;

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }

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