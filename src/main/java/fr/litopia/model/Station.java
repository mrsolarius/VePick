package fr.litopia.model;

import fr.litopia.model.enums.VStatus;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "LesStations")
public class Station {
    @Id
    @Column(name = "adresse", nullable = false)
    private String adresse;

    @Enumerated(EnumType.STRING)
    @Column(name = "v_status", length = 6,nullable = false)
    private VStatus vStatus;
    @OneToMany(mappedBy = "pk.station", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Bornette> bornettes = new LinkedHashSet<>();

    /**
     * Constructeur de vide de la classe Station
     */
    public Station() {}

    /**
     * Constructeur de la classe Station
     * @param adresse adresse de la station
     */
    public Station(String adresse){
        this.vStatus = VStatus.VNUL;
    }

    /**
     * Constructeur de la classe Station
     * @param adresse adresse de la station
     * @param vStatus status de la station
     */
    public Station (String adresse, VStatus vStatus){
        this.setAdresse(adresse);
        this.vStatus = vStatus;
    }

    /**
     * Setter de l'adresse de la station
     * @throws IllegalArgumentException si l'adresse est trop longue (plus de 255 caractères)
     * @param adresse adresse de la station
     */
    private void setAdresse(String adresse){
        if(adresse.length()>255) throw new IllegalArgumentException("Adresse trop longue");
        this.adresse = adresse;
    }

    /**
     * Getter de la liste des bornettes de la station
     * @return liste des bornettes de la station
     */
    public Set<Bornette> getBornettes() {
        return bornettes;
    }

    /**
     * Setter de la liste des bornettes de la station
     * @param bornettes liste des bornettes de la station
     */
    public void setBornettes(Set<Bornette> bornettes) {
        this.bornettes = bornettes;
    }

    /**
     * Getter du status de la station
     * @return status de la station
     */
    public VStatus getVStatus() {
        return vStatus;
    }

    /**
     * Setter du status de la station
     * @param vStatus status de la station
     */
    public void setVStatus(VStatus vStatus) {
        this.vStatus = vStatus;
    }

    /**
     * Getter de l'adresse de la station
     * @return adresse de la station
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Redéfinition de la méthode equals
     * @param obj l'objet à comparer
     * @return true si les objets sont égaux, false sinon
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Station other = (Station) obj;
        return Objects.equals(this.adresse, other.adresse);
    }
}