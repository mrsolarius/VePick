package fr.litopia.model;

import fr.litopia.respository.api.LocationNonAbonneRepository;
import fr.litopia.utils.RandomString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class LocationNonAbonne extends Location {
    @Column(name = "cb", length = 16, updatable = false)
    private String cb;

    @Column(name = "code", length = 20, updatable = false)
    private String code;

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

    public void setCb(String cb) {
        if(this.cb == null)
            this.cb = cb;
    }
}
