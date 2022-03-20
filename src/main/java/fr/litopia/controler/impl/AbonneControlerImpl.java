package fr.litopia.controler.impl;

import fr.litopia.controler.api.AbonneControler;
import fr.litopia.model.Abonne;
import fr.litopia.respository.api.AbonneRepository;

public class AbonneControlerImpl extends ControlerImp implements AbonneControler {

    private AbonneRepository aboRepository;

    @Override
    public void init() {
        aboRepository = getRepositoryFactory().newAbonneRepository(getEntityManager());
    }

    @Override
    public boolean loginExist(String login) {
        return getAbonne(login) != null;
    }

    @Override
    public void saveAbonne(Abonne abo) {
        this.getEntityManager().getTransaction().begin();
        this.aboRepository.save(abo);
        this.getEntityManager().getTransaction().commit();
    }

    @Override
    public boolean checkPassword(String login, String password) {
        if (!loginExist(login))return false;
        return getAbonne(login).getMdp().equals(password);
    }

    @Override
    public Abonne getAbonne(String login) {
        return aboRepository.findById(login);
    }
}
