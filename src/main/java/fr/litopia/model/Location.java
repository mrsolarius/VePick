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

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "velo_numero")
    private Velo velo;

    /**
     * Récupère le vélo associé à la location
     * @return le vélo associé à la location
     */
    public Velo getVelo() {
        return velo;
    }

    /**
     * Change le vélo associé à la location
     * Vas ajouter un vélo à la location et vas ajouter une location à ce vélo si elle n'est pas déjà associée à un vélo
     * @param velo le nouveau vélo
     */
    public void setVelo(Velo velo) {
        if(this.velo==null && velo==null) return;

        if (this.velo == null) {
            this.velo = velo;
            velo.addLocation(this);
        }
        this.velo = velo;
    }

    /**
     * Récupère la date de départ de la location
     * @return la date de départ de la location
     */
    public LocalDateTime getDepart() {
        return depart;
    }

    /**
     * Récupère le prix de la location
     * @throws NullPointerException si la location n'a pas été clôturée et que le prix n'a pas été calculé
     * @return le prix de la location
     */
    public Double getPrix() {
        if (this.prix==null) throw new NullPointerException("Le prix de la location n'a pas été calculé");
        return prix;
    }

    /**
     * Récupère le temps de la location
     * @return le temps de la location 0 si la location n'a pas été clôturée
     */
    public Integer getTemps() {
        return temps;
    }

    /**
     * retourne le numéro de la location
     * @return le numéro de la location
     */
    public Long getId() {
        return id;
    }

    /**
     * Clôture la location
     * @param bornette ou le vélo sera rendu
     */
    public void cloreLocation(Bornette bornette) {
        velo.setBornette(bornette);
        temps=toIntExact(ChronoUnit.MINUTES.between(depart,LocalDateTime.now()));
        prix=temps*(velo.getModele().getPrixHoraire()/60);
    }

    /**
     * Permet de savoir si la location à était effectuer il y a moins de 5 minutes
     * @return true si la location à était effectuer il y a moins de 5 minutes false sinon
     */
    public Boolean isUnderFiveMinutes(){
        return toIntExact(ChronoUnit.MINUTES.between(depart,LocalDateTime.now()))<5;
    }

    /**
     * Permet de cloturer la location en cas de panne pour 0€ si le vélo et rendu hs moins de 5 minutes après la location
     * @throws IllegalStateException si la location n'a pas été clôturée
     * @param bornette ou le vélo sera rendu
     */
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