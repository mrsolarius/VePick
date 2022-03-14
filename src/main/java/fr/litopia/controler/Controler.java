package fr.litopia.controler;

import fr.litopia.model.Station;
import fr.litopia.respository.RepositoryFactory;
import fr.litopia.view.View;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Set;

public abstract class Controler {
    protected EntityManager entityManager;
    protected RepositoryFactory daoFactory = new RepositoryFactory();
    private final View view;

    public Controler(View view) {
        entityManager = Persistence.createEntityManagerFactory("VePick").createEntityManager();
        this.view = view;
        this.init();
    }

    public abstract void init();
}
