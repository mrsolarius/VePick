package fr.litopia.views.tinyView;

import fr.litopia.controler.ControlerFactory;
import fr.litopia.controler.api.AbonneControler;
import fr.litopia.model.Abonne;
import fr.litopia.utils.ReadingConsole;
import fr.litopia.views.struct.impl.TinyViewImpl;

public class LoginTinyView extends TinyViewImpl<Abonne> {
    AbonneControler abonneControler;
    String login;
    private Abonne abonne;

    @Override
    protected void init() {
        abonneControler = ControlerFactory.getAbonneControler();
    }

    @Override
    protected void display() {
        System.out.println("==========================");
        System.out.println("Veuillez vous identifier");
        System.out.println("==========================");
        getLogin();
        checkPassword();
    }

    private void getLogin() {
        System.out.println("Login (-1 pour annuler) : ");
        login = ReadingConsole.readLine();
        if(login.equals("-1")) this.cancel();
        if(!abonneControler.loginExist(login)) {
            System.out.println("Login incorrect");
            getLogin();
        }
    }

    private void checkPassword() {
        System.out.println("Mot de passe (-1 pour annuler) : ");
        String password = ReadingConsole.readLine();
        if(password.equals("-1")) this.cancel();
        if(!abonneControler.checkPassword(login, password)) {
            System.out.println("Mot de passe incorrect");
            checkPassword();
        }else {
            this.abonne = abonneControler.getAbonne(login);
        }
    }

    @Override
    protected Abonne getValue(){
        return this.abonne;
    }
}
