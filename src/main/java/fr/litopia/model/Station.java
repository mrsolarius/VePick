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

    public Station() {}

    public Station(String adresse){

        this.vStatus = VStatus.VNUL;
    }

    public Station (String adresse, VStatus vStatus){
        this.setAdresse(adresse);
        this.vStatus = vStatus;
    }

    private void setAdresse(String adresse){
        if(adresse.length()>255) throw new IllegalArgumentException("Adresse trop longue");
        this.adresse = adresse;
    }

    public Set<Bornette> getBornettes() {
        return bornettes;
    }

    public void setBornettes(Set<Bornette> bornettes) {
        this.bornettes = bornettes;
    }

    public VStatus getVStatus() {
        return vStatus;
    }

    public void setVStatus(VStatus vStatus) {
        this.vStatus = vStatus;
    }

    public String getAdresse() {
        return adresse;
    }

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