package fr.litopia.controler;

import fr.litopia.model.Abonne;
import fr.litopia.respository.api.AbonneRepository;
import fr.litopia.view.View;

public class AbonnementControler extends Controler{

    private AbonneRepository aboRepository;

    public AbonnementControler(View view) {
        super(view);
    }

    @Override
    public void init() {
        aboRepository = daoFactory.newAbonneRepository(entityManager);
    }

    public boolean LoginExists(String login) {
        return aboRepository.findById(login) != null;
    }

    public void createAbonne(Abonne abo) {
        this.aboRepository.save(abo);
    }
}
