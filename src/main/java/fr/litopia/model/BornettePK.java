package fr.litopia.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class BornettePK implements Serializable {
    @ManyToOne(optional = false)
    @JoinColumn(name = "station_adresse", nullable = false)
    private Station station;

    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "numero", nullable = false, updatable = false)
    private Long numero;

    public Station getStation() {
        return this.station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Long getNumero() {
        return this.numero;
    }


}