package fr.litopia.model;

import fr.litopia.respository.api.LocationNonAbonneRepository;
import fr.litopia.utils.RandomString;
import fr.litopia.utils.ReadingConsole;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class LocationNonAbonne extends Location {
    @Column(name = "cb", length = 16, updatable = false)
    private String cb;

    @Column(name = "code", length = 20, updatable = false)
    private String code;

    public LocationNonAbonne() {
        super();
    }

    public LocationNonAbonne(String cb) {
        super();
        this.setCb(cb);
    }

    public String getCode() {
        return code;
    }

    public String getCb() {
        return cb;
    }

    public void generateCode(LocationNonAbonneRepository locationNonAbonneRepository) {
        //generate an insecure random string with 20 characters
        RandomString gen = new RandomString(20);
        String code = gen.nextString();
        // Tant que le code n'est pas unique
        while (!locationNonAbonneRepository.verifyCode(code)) {
            code = gen.nextString();
        }
        this.code = code;
    }

    private void setCb(String cb) {
        if (!ReadingConsole.isNumeric(cb))throw new IllegalArgumentException("La CB doit être numérique");
        if (cb.length()!=16)throw new IllegalArgumentException("La CB doit faire exactement 16 caractères");
        this.cb = cb;
    }

    @Override
    public double calculerPrix() {
        return getTemps() * (getVelo().getModele().getPrixHoraire() / 60);
    }
}
