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

    public Bornette(){

    }

    public Bornette(BornettePK pk){
        this.pk = pk;
    }

    public void setVelo(Velo velo) {
        if(this.velo == null) {
            if (velo.getBornette() != this) velo.setBornette(this);
            this.velo = velo;
        }else {
            throw new IllegalCallerException("La bornette possède déjà un velo");
        }
    }

    public void takeVelo(){
        if(this.velo != null) {
            Velo v = this.velo;
            this.velo = null;
            v.setBornette(null);
        }else {
            throw new IllegalCallerException("La bornette ne possède pas de velo");
        }
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
}