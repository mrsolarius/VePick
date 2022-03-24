package fr.litopia;

import fr.litopia.model.Abonne;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AbonneTest {

    @Test
    public void testAbonneEncapsulation() {
        Abonne abonne = new Abonne();
        assertThatThrownBy(() -> abonne.setLogin("gastroenterologist1")).isInstanceOf(Error.class)
                .hasMessageContaining("Le login doit faire moins de 20 caractères");
        assertThatThrownBy(() -> abonne.setAdresse("Une tres tres tres long adresse mega mega long car elle nécécite l'apport de plus de 255 caracter ce qui et en soit particuliermenet long alors j'écrit du text sans réfléchire jusqu'à arriver à cette imposant nombre en terme de caractères je vous remerci de votre attention si vous avez lu ce message en entier")).isInstanceOf(Error.class)
                .hasMessageContaining("L'adresse doit faire moins de 255 caractères");
        assertThatThrownBy(() -> abonne.setNom("tres tres tres long nom car on peut trouver des nom de 50 charactères")).isInstanceOf(Error.class)
                .hasMessageContaining("Le nom doit faire moins de 50 caractères");
        assertThatThrownBy(() -> abonne.setPrenom("tres tres tres long prenom car on peut trouver des prenom de 50 charactères")).isInstanceOf(Error.class)
                .hasMessageContaining("Le prenom doit faire moins de 50 caractères");
        assertThatThrownBy(() -> abonne.setMdp("tres tres tres long mdp1")).isInstanceOf(Error.class)
                .hasMessageContaining("Le code doit faire moins de 20 caractères");
        assertThatThrownBy(() -> abonne.setCb("UNE CB N'EST PAS UN NUMERO ?!")).isInstanceOf(Error.class)
                .hasMessageContaining("La CB doit être numérique");
        assertThatThrownBy(() -> abonne.setCb("123456")).isInstanceOf(Error.class)
                .hasMessageContaining("La CB doit faire exactement 16 caractères");
    }

}
