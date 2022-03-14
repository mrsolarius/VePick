package fr.litopia.model;

import fr.litopia.model.enums.Etat;

import javax.persistence.*;

@Entity
@Table(name = "LesBornettes")
public class Bornette {
    @EmbeddedId
    private BornettePK pk;

    @Enumerated(EnumType.STRING)
    @Column(name = "etat",length = 11, nullable = false)
    private Etat etat = Etat.OK;

    @OneToOne
    @JoinColumn(name = "velo_numero")
    private Velo velo;

    public Velo getVelo() {
        return velo;
    }

    public void setVelo(Velo velo) {
        this.velo = velo;
    }

    public Station getStation() {
        return pk.getStation();
    }

    public Long getNumero() {
        return pk.getNumero();
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public void setPk(BornettePK pk) {
        this.pk = pk;
    }
}