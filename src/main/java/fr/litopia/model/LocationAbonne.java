package fr.litopia.model;

import fr.litopia.model.Location;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LocationAbonne extends Location {
    static float REMISE_ABO=0.7f;

    @ManyToOne
    @JoinColumn(name = "abonne_id")
    private Abonne abonne;

    public Abonne getAbonne() {
        return abonne;
    }

    public void setAbonne(Abonne abonne) {
        this.abonne = abonne;
    }

    @Override
    public Double getPrix() {
        return super.getPrix()*REMISE_ABO;
    }
}
