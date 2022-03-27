package fr.litopia.model;

import fr.litopia.model.enums.Etat;

import javax.persistence.*;
import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "LesVelos")
public class Velo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "numero", nullable = false)
    private Long numero;

    @Column(name = "mise_en_service", nullable = false, updatable = false)
    //date par defaut
    private Date miseEnService= new Date(20210406);

    @Enumerated(EnumType.STRING)
    @Column(name = "etat",length = 11, nullable = false)
    private Etat etat;

    @OneToOne(mappedBy = "velo")
    private Bornette bornette;

    @OneToMany(mappedBy = "velo")
    private Set<Location> locations = new LinkedHashSet<>();

    @ManyToOne(optional = false)
    @JoinColumn(name = "modele_name", nullable = false, updatable = false)
    private Modele modele;

    /**
     * Constructeur par défaut de la classe Velo
     */
    public Velo() {
        locations = new LinkedHashSet<>();
    }

    /**
     * Constructeur de la classe Velo
     * @param miseEnService date de mise en service du velo
     * @param etat état du velo
     * @param modele modèle du velo
     */
    public Velo(Date miseEnService, Etat etat, Modele modele) {
        locations = new LinkedHashSet<>();
        this.miseEnService = miseEnService;
        this.etat = etat;
        this.modele = modele;
        modele.addVelo(this);
    }

    /**
     * Getter du modèle du velo
     * @return modèle du velo
     */
    public Modele getModele() {
        return modele;
    }

    /**
     * getter de la liste des locations utilisant ce velo
     * @return set des locations utilisant ce velo
     */
    public Set<Location> getLocations() {
        return locations;
    }

    /**
     * getter de la bornette du velo
     * @return bornette sur laquelle le velo est rangé ou null si le velo n'est pas rangé
     */
    public Bornette getBornette() {
        return bornette;
    }

    /**
     * Setter de la bornette du velo mes à jour la bornette avec le vélo
     * @param bornette bornette sur laquelle le velo est rangé
     */
    public void setBornette(Bornette bornette) {
        if(this.bornette==null){
            this.bornette = bornette;
            bornette.setVelo(this);
        }
        if(bornette==null){
            if(this.bornette.getVelo()!=null)this.bornette.takeVelo();
            this.bornette = null;
        }
    }

    /**
     * Getter du numéro du velo
     * @return numéro du velo
     */
    public Etat getEtat() {
        return etat;
    }

    /**
     * Setter de l'état du velo
     * @param etat état du velo
     */
    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    /**
     * Getter de la date de mise en service du velo
     * @return date de mise en service du velo
     */
    public Date getMiseEnService() {
        return miseEnService;
    }

    /**
     * Getter du numéro du velo
     * @return numéro du velo
     */
    public Long getNumero() {
        return numero;
    }

    /**
     * Ajoute une location au velo
     * @param location location à ajouter
     */
    public void addLocation(Location location) {
        if (location.getVelo()!=this) location.setVelo(this);
        this.locations.add(location);
    }
}