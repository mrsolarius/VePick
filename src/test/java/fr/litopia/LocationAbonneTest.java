package fr.litopia;

import fr.litopia.model.Abonne;
import fr.litopia.model.LocationAbonne;
import fr.litopia.model.Modele;
import fr.litopia.model.Velo;
import fr.litopia.model.enums.Etat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocationAbonneTest {
    private LocationAbonne locationAbonne;
    private Velo velo;
    @BeforeEach
    public void setUp() {
        Abonne abonne = new Abonne("login", "mdp", "nom", "prenom", "adresse", "1111111111111111");
        locationAbonne = new LocationAbonne(abonne);
        Modele modele = new Modele("VTT", 1.8d);
        velo = new Velo(new Date(LocalDateTime.now().getLong(ChronoField.NANO_OF_SECOND)), Etat.OK, modele);
    }

    @Test
    public void testLocationVeloSet(){
        locationAbonne.setVelo(velo);

        assertTrue(velo.getLocations().contains(locationAbonne));
        assertEquals(locationAbonne.getVelo(), velo);
    }

    @Test
    public void testVeloLocationSet(){
        velo.addLocation(locationAbonne);

        assertTrue(velo.getLocations().contains(locationAbonne));
        assertEquals(locationAbonne.getVelo(), velo);
    }

}
