package fr.litopia.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class LocationNonAbonne extends Location{
    @Column(name = "cb", length = 16,updatable = false)
    private String cb;

    @Column(name = "code",updatable = false)
    private String code;

    public String getCode() {
        return code;
    }

    public String getCb() {
        return cb;
    }
}
