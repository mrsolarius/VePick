package fr.litopia.model;

import fr.litopia.repository.api.LocationNonAbonneRepository;
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

    /**
     * Constructeur par défaut de la classe LocationNonAbonne
     */
    public LocationNonAbonne() {
        super();
    }

    /**
     * Constructeur de la classe LocationNonAbonne
     * @param cb La CB de la location
     */
    public LocationNonAbonne(String cb) {
        super();
        this.setCb(cb);
    }

    /**
     * Retourne le code de la location
     * @return Le code de la location
     */
    public String getCode() {
        return code;
    }

    /**
     * Retourne la CB de la location
     * @return La CB de la location
     */
    public String getCb() {
        return cb;
    }

    /**
     * Générer le code de la location
     * @param locationNonAbonneRepository Le repository de la location pour ne pas générer deux fois le même code
     */
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

    /**
     * Setter de la CB de la location
     * @throws IllegalArgumentException Si la CB est invalide (ne contient pas 16 chiiffres)
     * @param cb La CB de la location
     */
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
