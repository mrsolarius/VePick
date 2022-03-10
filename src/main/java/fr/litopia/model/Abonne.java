package fr.litopia.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "LesAbonnes")
public class Abonne {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "nom", length = 50)
    private String nom;

    @Column(name = "prenom", length = 50)
    private String prenom;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "mdp", length = 20)
    private String mdp;

    @Column(name = "date_fin")
    private Date dateFin;

    @Column(name = "credit_temps")
    private Integer creditTemps;

    @Column(name = "cb", length = 16)
    private String cb;

    @OneToMany(mappedBy = "abonne")
    private Set<LocationAbonne> locationAbonnes = new LinkedHashSet<>();

    @Column(name = "renouv_auto")
    private Boolean renouvAuto;

    public Boolean getRenouvAuto() {
        return renouvAuto;
    }

    public void setRenouvAuto(Boolean renouvAuto) {
        this.renouvAuto = renouvAuto;
    }

    public Set<LocationAbonne> getLocationAbonnes() {
        return locationAbonnes;
    }

    public void setLocationAbonnes(Set<LocationAbonne> locationAbonnes) {
        this.locationAbonnes = locationAbonnes;
    }

    public String getCb() {
        return cb;
    }

    public void setCb(String cb) {
        this.cb = cb;
    }

    public Integer getCreditTemps() {
        return creditTemps;
    }

    public void setCreditTemps(Integer creditTemps) {
        this.creditTemps = creditTemps;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String code) {
        this.mdp = code;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }
}