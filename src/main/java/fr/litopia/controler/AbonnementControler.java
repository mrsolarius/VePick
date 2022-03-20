package fr.litopia.controler;

import fr.litopia.controler.impl.ControlerImp;
import fr.litopia.model.Abonne;
import fr.litopia.respository.api.AbonneRepository;
import fr.litopia.view.impl.ViewImpl;

public class AbonnementControler extends ControlerImp {

    private AbonneRepository aboRepository;

    public AbonnementControler() {
        super();
    }

    @Override
    public void init() {
        aboRepository = getRepositoryFactory().newAbonneRepository(getEntityManager());
    }

    public boolean LoginExists(String login) {
        return aboRepository.findById(login) != null;
    }

    public void createAbonne(Abonne abo) {
        this.getEntityManager().getTransaction().begin();
        this.aboRepository.save(abo);
        this.getEntityManager().getTransaction().commit();
    }
}
