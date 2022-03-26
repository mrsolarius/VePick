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

    @Column(name = "depart", updatable = false)
    private LocalDateTime depart = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "velo_numero")
    private Velo velo;

    public Velo getVelo() {
        return velo;
    }

    public void setVelo(Velo velo) {
        if(this.velo==null && velo==null) return;

        if (this.velo == null) {
            this.velo = velo;
            velo.addLocation(this);
        }
        this.velo = velo;
    }

    public LocalDateTime getDepart() {
        return depart;
    }

    public Double getPrix() {
        if (this.prix==null) throw new NullPointerException("Le prix de la location n'a pas été calculé");
        return prix;
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
        return toIntExact(ChronoUnit.MINUTES.between(depart,LocalDateTime.now()))<5;
    }

    public void clotureLocationHSUnderFiveMinutes(Bornette bornette){
        if(isUnderFiveMinutes()) {
            velo.setBornette(bornette);
            temps = toIntExact(ChronoUnit.MINUTES.between(depart, LocalDateTime.now()));
            prix = 0d;
        }else{
            throw new IllegalStateException("La location doit avoir commencer il y a moins de 5 minutes");
        }
    }
}