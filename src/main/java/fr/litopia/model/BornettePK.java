package fr.litopia.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class BornettePK implements Serializable {
    @ManyToOne(optional = false)
    @JoinColumn(name = "station_adresse", nullable = false)
    private Station station;

    @Column(name = "numero", nullable = false, updatable = false)
    private Long numero;

    public Station getStation() {
        return this.station;
    }

    public Long getNumero() {
        return this.numero;
    }
}