package fr.litopia;

import fr.litopia.model.Abonne;
import fr.litopia.model.LocationAbonne;
import fr.litopia.model.Modele;
import fr.litopia.model.Velo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocationAbonneTest {
    private LocationAbonne locationAbonne;
    private Abonne abonne;
    @BeforeEach
    public void setUp() {
        locationAbonne = new LocationAbonne();
        abonne = new Abonne("login", "mdp", "nom", "prenom", "adresse", "1111111111111111");
    }

    @Test
    public void testLocationLocSet() {
        locationAbonne.setAbonne(abonne);

        assertTrue(abonne.getLocationAbonnes().contains(locationAbonne));
        assertEquals(locationAbonne.getAbonne(), abonne);
    }

    @Test
    public void testLocationAbonneSet(){
        abonne.addLocationAbonne(locationAbonne);

        assertTrue(abonne.getLocationAbonnes().contains(locationAbonne));
        assertEquals(locationAbonne.getAbonne(), abonne);
    }

    @Test
    public void testLocationPrice(){
        //@TODO lorsque modele et vélo serons refait
    }

}
