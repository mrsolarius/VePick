package fr.litopia;

import fr.litopia.view.MainMenuView;

import javax.persistence.Persistence;

public class Launch {
    public static void main(String[] args){
        Persistence.createEntityManagerFactory("VePick").createEntityManager();
        MainMenuView mainMenuView = new MainMenuView();
        mainMenuView.run();
    }
}
