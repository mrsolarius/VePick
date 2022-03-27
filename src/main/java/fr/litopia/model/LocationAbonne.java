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

    public LocationAbonne() {
        super();
    }

    public LocationAbonne(Abonne abonne) {
        super();
        this.setAbonne(abonne);
    }

    public Abonne getAbonne() {
        return abonne;
    }

    protected void setAbonne(Abonne abonne) {
        if(this.abonne==null && abonne==null) return;

        if (this.abonne == null) {
            this.abonne = abonne;
            abonne.addLocationAbonne(this);
        }
    }

    @Override
    public double calculerPrix() {
        return getTemps() * (getVelo().getModele().getPrixHoraire() / 60) * REMISE_ABO;
    }
}
