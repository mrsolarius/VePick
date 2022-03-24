package fr.litopia.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import static java.lang.Math.toIntExact;

@Entity
@Table(name = "LesLocations")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Location {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "temps")
    private Integer temps;

    @Column(name = "prix")
    private Double prix;

    @Column(name = "depart")
    private LocalDateTime depart = LocalDateTime.now();

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

    public Long getId() {
        return id;
    }

    public void cloreLocation(Bornette bornette) {
        velo.setBornette(bornette);
        temps=toIntExact(ChronoUnit.MINUTES.between(depart,LocalDateTime.now()));
        prix=temps*(velo.getModele().getPrixHoraire()/60);
    }

    public Boolean isUnderFiveMinutes(){
        return toIntExact(ChronoUnit.MINUTES.between(depart,LocalDateTime.now()))<5
    }

    public void clotureLocationHSUnderFiveMinutes(Bornette bornette){
        velo.setBornette(bornette);
        temps=toIntExact(ChronoUnit.MINUTES.between(depart,LocalDateTime.now()));
        prix=0d;
    }
}