package fr.litopia.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.RoundingMode;
import java.text.DecimalFormat;

@Entity
public class LocationAbonne extends Location {
    static float REMISE_ABO=0.7f;

    @ManyToOne
    @JoinColumn(name = "abonne_id")
    private Abonne abonne;

    /**
     * Constructeur par défaut de la classe LocationAbonne
     */
    public LocationAbonne() {
        super();
    }

    /**
     * Constructeur de la classe LocationAbonne
     * @param abonne l'abonné qui loue
     */
    public LocationAbonne(Abonne abonne) {
        super();
        this.setAbonne(abonne);
    }

    /**
     * Retourne l'abonné qui loue
     * @return l'abonné qui loue
     */
    public Abonne getAbonne() {
        return abonne;
    }

    /**
     * Modifie l'abonné qui loue
     * Ajouter la location à l'abonné et définir l'abonné comme loueur
     * @param abonne l'abonné qui loue
     */
    protected void setAbonne(Abonne abonne) {
        if(this.abonne==null && abonne==null) return;

        if (this.abonne == null) {
            this.abonne = abonne;
            abonne.addLocationAbonne(this);
        }
    }

    /**
     * Retourne le prix de la location avec la remise abonne
     * @return le prix de la location
     */
    @Override
    public double calculerPrix() {
        return getTemps() * (getVelo().getModele().getPrixHoraire() / 60) * REMISE_ABO;
    }
}
