package fr.litopia;

import fr.litopia.view.VepickView;

import javax.persistence.Persistence;

public class Launch {
    public static void main(String[] args){
        Persistence.createEntityManagerFactory("VePick").createEntityManager();
        VepickView vepickView = new VepickView();
        vepickView.run();
    }
}
