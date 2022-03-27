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

    /**
     * Constructeur par défaut de la classe Bornette
     */
    public Bornette(){

    }

    /**
     * Constructeur de la classe Bornette
     * @param pk la clé primaire de la bornette
     */
    public Bornette(BornettePK pk){
        this.pk = pk;
    }


    /**
     * Retourne le velo présent sur la bornette
     * @return le velo présent sur la bornette null si aucun velo n'est présent
     */
    public Velo getVelo() {
        return velo;
    }

    /**
     * Modifie le velo présent sur la bornette
     * @param velo le velo à placer sur la bornette
     */
    public void setVelo(Velo velo) {
        if(this.velo == null) {
            if (velo.getBornette() != this) velo.setBornette(this);
            this.velo = velo;
        }else {
            throw new IllegalCallerException("La bornette possède déjà un velo");
        }
    }

    /**
     * Permet prendre le velo de la bornette
     * Si le velo se trouve sur la bornette, il est retiré de la bornette,
     * et l'attribue borette du velo et mis à null
     */
    public void takeVelo(){
        if(this.velo != null) {
            Velo v = this.velo;
            this.velo = null;
            v.setBornette(null);
        }else {
            throw new IllegalCallerException("La bornette ne possède pas de velo");
        }
    }

    /**
     * Permet de récupérer la station de la bornette
     * @return la station de la bornette
     */
    public Station getStation() {
        return pk.getStation();
    }

    /**
     * Permet de récupérer le numéro de la bornette
     * @return le numéro de la bornette
     */
    public Long getNumero() {
        return pk.getNumero();
    }

    /**
     * Permet de récupérer l'état de la bornette
     * @return l'état de la bornette
     */
    public Etat getEtat() {
        return etat;
    }

    /**
     * Permet de modifier l'état de la bornette
     * @param etat l'état à modifier
     */
    public void setEtat(Etat etat) {
        this.etat = etat;
    }
}