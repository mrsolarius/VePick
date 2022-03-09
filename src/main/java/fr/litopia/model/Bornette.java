package fr.litopia.model;

import fr.litopia.model.enums.State;

import javax.persistence.*;

@Entity
@Table(name = "LesBornettes")
public class Bornette {
    @Id
    @Column(name = "numero", nullable = false)
    private Long numero;

    @Enumerated
    @Column(name = "state", nullable = false)
    private State state;

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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}