package fr.litopia.model;

import fr.litopia.utils.ReadingConsole;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "LesAbonnes")
public class Abonne {

    @Id
    @Column(name = "login", nullable = false, updatable = false, length = 20)
    private String login;

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
    private final Set<LocationAbonne> locationAbonnes;

    @Column(name = "renouv_auto")
    private Boolean renouvAuto;


    /**
     * Constructeur de la classe Abonne
     * @param login login de l'abonne
     * @param mdp mot de passe de l'abonne
     * @param nom nom de l'abonne
     * @param prenom prenom de l'abonne
     * @param adresse adresse de l'abonne
     * @param cb carte bancaire de l'abonne
     */
    public Abonne(String login, String mdp, String nom, String prenom, String adresse, String cb) {
        this();
        this.setLogin(login);
        this.setMdp(mdp);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setAdresse(adresse);
        this.setCb(cb);
    }

    public Abonne() {
        this.dateFin = addOneYear();
        this.creditTemps = 0;
        this.renouvAuto = true;
        this.locationAbonnes = new LinkedHashSet<>();
    }

    public Boolean getRenouvAuto() {
        return renouvAuto;
    }

    public void setRenouvAuto(Boolean renouvAuto) {
        this.renouvAuto = renouvAuto;
    }

    public Set<LocationAbonne> getLocationAbonnes() {
        return locationAbonnes;
    }

    public void addLocationAbonne(LocationAbonne locationAbonne) {
        if (locationAbonne.getAbonne()!=this) locationAbonne.setAbonne(this);
        this.locationAbonnes.add(locationAbonne);
    }

    public String getCb() {
        return cb;
    }

    public void setCb(String cb) {
        if (!ReadingConsole.isNumeric(cb))throw new IllegalArgumentException("La CB doit être numérique");
        if (cb.length()!=16)throw new IllegalArgumentException("La CB doit faire exactement 16 caractères");
        this.cb = cb;
    }

    public Integer getCreditTemps() {
        return creditTemps;
    }

    public void addCreditTemps(Integer creditTemps) {
        this.creditTemps += creditTemps;
    }

    public void removeCreditTemps(Integer creditTemps){
        this.creditTemps -= creditTemps;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void renewAbo() {
        this.dateFin = this.addOneYear();
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String code) {
        if (code.length()>20)throw new IllegalArgumentException("Le code doit faire moins de 20 caractères");
        this.mdp = code;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        if (adresse.length()>255)throw new IllegalArgumentException("L'adresse doit faire moins de 255 caractères");
        this.adresse = adresse;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        if (prenom.length()>50)throw new IllegalArgumentException("Le prenom doit faire moins de 50 caractères");
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if (nom.length()>50)throw new IllegalArgumentException("Le nom doit faire moins de 50 caractères");
        this.nom = nom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login.length()>20) throw new IllegalArgumentException("Le login doit faire moins de 20 caractères");
        this.login = login;
    }

    private Date addOneYear(){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR,1);
        return new Date(c.getTimeInMillis());
    }
}