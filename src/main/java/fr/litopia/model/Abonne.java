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

    /**
     * Constructeur par default de la classe Abonne
     */
    public Abonne() {
        this.dateFin = addOneYear();
        this.creditTemps = 0;
        this.renouvAuto = true;
        this.locationAbonnes = new LinkedHashSet<>();
    }

    /**
     * Permet de de savoir si l'abonne et en renouvellement automatique
     * @return True si le renouvellement automatique et activé, False sinon
     */
    public Boolean getRenouvAuto() {
        return renouvAuto;
    }

    /**
     * Permet de changer le statut de l'abonne
     * @param renouvAuto True si le renouvellement automatique est activé, False sinon
     */
    public void setRenouvAuto(Boolean renouvAuto) {
        this.renouvAuto = renouvAuto;
    }

    /**
     * Permet de récupérer les locations de l'abonne
     * @return les locations de l'abonne
     */
    public Set<LocationAbonne> getLocationAbonnes() {
        return locationAbonnes;
    }

    /**
     * Permet d'ajouter une location à l'abonne
     * Vas automatiquement ajouter un abonné à la location s'il n'est pas déjà dans la location
     * @param locationAbonne la location à ajouter
     */
    public void addLocationAbonne(LocationAbonne locationAbonne) {
        if (locationAbonne.getAbonne()!=this) locationAbonne.setAbonne(this);
        this.locationAbonnes.add(locationAbonne);
    }

    /**
     * Permet de récupérer la CB de l'abonne
     * @return la CB de l'abonne
     */
    public String getCb() {
        return cb;
    }

    /**
     * Permet de modifier la CB de l'abonne
     * @throws IllegalArgumentException si la CB n'est pas valide (16 chiffres)
     * @param cb la nouvelle CB de l'abonne
     */
    public void setCb(String cb) {
        if (!ReadingConsole.isNumeric(cb))throw new IllegalArgumentException("La CB doit être numérique");
        if (cb.length()!=16)throw new IllegalArgumentException("La CB doit faire exactement 16 caractères");
        this.cb = cb;
    }

    /**
     * Permet de récupérer le crédit de temps de l'abonne
     * @return crédit de temps de l'abonne
     */
    public Integer getCreditTemps() {
        return creditTemps;
    }

    /**
     * Permet de créditer l'abonne en temps
     * @param creditTemps le temps à créditer
     */
    public void addCreditTemps(Integer creditTemps) {
        this.creditTemps += creditTemps;
    }

    /**
     * Permet de débiter l'abonne en temps
     * @param creditTemps le temps à débiter
     */
    public void removeCreditTemps(Integer creditTemps){
        this.creditTemps -= creditTemps;
    }

    /**
     * Permet de récupérer la date de fin de l'abonne
     * @return la date de fin de l'abonne
     */
    public Date getDateFin() {
        return dateFin;
    }

    /**
     * Permet de renouveler l'abonne en ajoutant un an
     */
    public void renewAbo() {
        this.dateFin = this.addOneYear();
    }

    /**
     * Permet de récupérer le mdp de l'abonne
     * @return le mdp de l'abonne
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * Permet de modifier le mdp de l'abonne
     * @throws IllegalArgumentException si le mdp n'est pas valide (mdp>20 caractères)
     * @param code le nouveau mdp de l'abonne
     */
    public void setMdp(String code) {
        if (code.length()>20)throw new IllegalArgumentException("Le code doit faire moins de 20 caractères");
        this.mdp = code;
    }

    /**
     * Permet de récupérer l'adresse de l'abonne
     * @return l"adresse de l'abonne
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Permet de modifier l'adresse de l'abonne
     * @throws IllegalArgumentException si l'adresse n'est pas valide (adresse>255 caractères)
     * @param adresse la nouvelle adresse de l'abonne
     */
    public void setAdresse(String adresse) {
        if (adresse.length()>255)throw new IllegalArgumentException("L'adresse doit faire moins de 255 caractères");
        this.adresse = adresse;
    }

    /**
     * Permet de récupérer le prenom de l'abonne
     * @return le prenom de l'abonne
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Permet de modifier le prenom de l'abonne
     * @throws IllegalArgumentException si le prenom n'est pas valide (prenom>50 caractères)
     * @param prenom le nouveau prenom de l'abonne
     */
    public void setPrenom(String prenom) {
        if (prenom.length()>50)throw new IllegalArgumentException("Le prenom doit faire moins de 50 caractères");
        this.prenom = prenom;
    }

    /**
     * Permet de récupérer le nom de l'abonne
     * @return le nom de l'abonne
     */
    public String getNom() {
        return nom;
    }

    /**
     * Permet de modifier le nom de l'abonne
     * @throws IllegalArgumentException si le nom n'est pas valide (nom>50 caractères)
     * @param nom le nouveau nom de l'abonne
     */
    public void setNom(String nom) {
        if (nom.length()>50)throw new IllegalArgumentException("Le nom doit faire moins de 50 caractères");
        this.nom = nom;
    }

    /**
     * Permet de recuperer le login de l'abonne
     * @return le login de l'abonne
     */
    public String getLogin() {
        return login;
    }

    /**
     * Permet de modifier le login de l'abonne
     * @throws IllegalArgumentException si le login n'est pas valide (login>20 caractères)
     * @param login le nouveau login de l'abonne
     */
    public void setLogin(String login) {
        if (login.length()>20) throw new IllegalArgumentException("Le login doit faire moins de 20 caractères");
        this.login = login;
    }

    /**
     * Permet d'ajouter un ans à la date courante
     * @return la date courante + 1 an
     */
    private Date addOneYear(){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR,1);
        return new Date(c.getTimeInMillis());
    }
}