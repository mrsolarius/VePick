package fr.litopia.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "LesLocations")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Location {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "temps")
    private Integer temps;

    @Column(name = "prix")
    private Double prix;

    @Column(name = "depart")
    private LocalDateTime depart;

    @ManyToOne
    @JoinColumn(name = "velo_numero")
    private Velo velo;

    public Velo getVelo() {
        return velo;
    }

    public void setVelo(Velo velo) {
        this.velo = velo;
    }

    public LocalDateTime getDepart() {
        return depart;
    }

    public void setDepart(LocalDateTime depart) {
        this.depart = depart;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Integer getTemps() {
        return temps;
    }

    public void setTemps(Integer temps) {
        this.temps = temps;
    }

    public Long getId() {
        return id;
    }
}