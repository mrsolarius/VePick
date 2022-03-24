package fr.litopia;

import fr.litopia.model.Abonne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class AbonneTest {
    private Abonne abonne;

    @BeforeEach
    public void setUp() {
        abonne = new Abonne();
    }

    @Test
    public void testAbonneLoginEncapsulation() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> abonne.setLogin("fligastroenterologist"));
        assertEquals("Le login doit faire moins de 20 caractères", exception.getMessage());
    }

    @Test
    public void testAbonneNomEncapsulation() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> abonne.setNom("tres tres tres long nom car on peut trouver des nom de 50 charactères"));
        assertEquals("Le nom doit faire moins de 50 caractères", exception.getMessage());
    }

    @Test
    public void testAbonnePrenomEncapsulation() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> abonne.setPrenom("tres tres tres long prenom car on peut trouver des prenom de 50 charactères"));
        assertEquals("Le prenom doit faire moins de 50 caractères", exception.getMessage());
    }

    @Test
    public void testAbonneMdpEncapsulation() {
        Throwable exception = assertThrows(IllegalArgumentException.class,() -> abonne.setMdp("tres tres tres long mdp car on peut trouver des telephone de 50 charactères"));
        assertEquals("Le code doit faire moins de 20 caractères", exception.getMessage());
    }

    @Test
    public void testAbonneCBEncapsulation(){
        Throwable exception = assertThrows(IllegalArgumentException.class,() -> abonne.setCb("UNE CB N'EST PAS UN NUMERO ?!"));
        assertEquals("La CB doit être numérique", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class,() -> abonne.setCb("123456"));
        assertEquals("La CB doit faire exactement 16 caractères", exception.getMessage());
    }

}
