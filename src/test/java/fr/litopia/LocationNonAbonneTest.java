package fr.litopia;

import fr.litopia.model.*;
import fr.litopia.model.enums.Etat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocationNonAbonneTest {
    private LocationNonAbonne locationNonAbonne;
    private Velo velo;

    @BeforeEach
    public void setUp() {
        locationNonAbonne = new LocationNonAbonne("1111111111111111");
        Modele modele = new Modele("VTT", 1.8d);
        velo = new Velo(new Date(LocalDateTime.now().getLong(ChronoField.NANO_OF_SECOND)), Etat.OK, modele);
    }

    @Test
    public void testLocationVeloSet(){
        locationNonAbonne.setVelo(velo);

        assertTrue(velo.getLocations().contains(locationNonAbonne));
        assertEquals(locationNonAbonne.getVelo(), velo);
    }

    @Test
    public void testVeloLocationSet(){
        velo.addLocation(locationNonAbonne);

        assertTrue(velo.getLocations().contains(locationNonAbonne));
        assertEquals(locationNonAbonne.getVelo(), velo);
    }

}
