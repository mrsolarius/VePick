package fr.litopia.model;

import fr.litopia.model.enums.Etat;

import javax.persistence.*;

@Entity
@Table(name = "LesBornettes")
public class Bornette {
    @Id
    @Column(name = "numero", nullable = false)
    private Long numero;

    @Enumerated
    @Column(name = "etat", nullable = false)
    private Etat etat;

    @ManyToOne(optional = false)
    @JoinColumn(name = "station_adresse", nullable = false)
    private Station station;

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }
}