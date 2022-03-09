package fr.litopia.model;

import fr.litopia.model.Location;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LocationAbonne extends Location {
    @ManyToOne
    @JoinColumn(name = "abonne_id")
    private Abonne abonne;

    public Abonne getAbonne() {
        return abonne;
    }

    public void setAbonne(Abonne abonne) {
        this.abonne = abonne;
    }
}
