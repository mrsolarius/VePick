package fr.litopia.views.menus.station.retrait;

import fr.litopia.model.Abonne;
import fr.litopia.model.LocationAbonne;
import fr.litopia.model.LocationNonAbonne;
import fr.litopia.model.enums.Etat;
import fr.litopia.utils.ReadingConsole;
import fr.litopia.views.struct.api.View;
import fr.litopia.views.tinyView.LoginTinyView;
import fr.litopia.views.tinyView.ReturnLocTinyView;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ReturnAboView extends ReturnComonContext{
    private Abonne abonne;
    public ReturnAboView(View view) {
        super(view);
    }

    private ArrayList<LocationAbonne> locationsEnCours;
    private LoginTinyView loginTinyView;
    private LocationAbonne locationAbonne;

    @Override
    protected void init() {
        loginTinyView = new LoginTinyView();
    }

    @Override
    protected void display() {
        System.out.println("=================");
        System.out.println("RENDRE UN VÉLO");
        System.out.println("==================");
        abonne = loginTinyView.startAndGetValue();
        if(abonne == null){
            this.stop().stop();
        }
        locationsEnCours = new ArrayList<>(retraitControler.getLocationsEnCours(abonne)) ;


        //@TODO gérer le fait de rendre plusieurs vélos à la fois (optionnel si on a le temps)
        System.out.println("=================");
        System.out.println("VEUILLEZ SELECTIONNER LES LOCATIONS QUE VOUS SOUHAITEZ TERMINER :");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        for (int i = 0; i < locationsEnCours.size(); i++) {
            System.out.println("Location n°"+i+" démarrée le "+locationsEnCours.get(i).getDepart().format(formatter)+" avec le vélo n°"+locationsEnCours.get(i).getVelo().getNumero());
        }
        System.out.println("\n==========================");
        System.out.println("Entrez 0 pour quitter");
        int selection = ReadingConsole.readInt(0,locationsEnCours.size());
        if (selection == 0) this.stop();
        this.clean();
        locationAbonne = locationsEnCours.get(selection);
        System.out.println("=================");
        System.out.println("VEUILLEZ RENSEIGNER L'ETAT DE VOTRE VÉLO :");
        System.out.println("==================");
        System.out.println("1. OK");
        System.out.println("2. HS");
        System.out.println("3. Retour");
        System.out.println("Votre choix : ");
        Integer choice = ReadingConsole.readInt(1,3);
        switch (choice) {
            case 1 -> displayPaiement();
            case 2 -> {
                locationAbonne.getVelo().setEtat(Etat.HS);   // On passe l'état du vélo à HS
                if (retraitControler.isUnderFiveMinutes(locationAbonne)) {
                    displayAnnulationEmprunt();
                }
                displayPaiement();
            }
            case 3 -> this.stop();
        }
        System.out.println("==================");
    }

    private void displayPaiement() {
        this.clean();
        System.out.println("========================");
        System.out.println("PAIEMENT DE LA LOCATION");
        System.out.println("========================");
        System.out.println("VéPick vous remercie de votre Location");
        Double prix = retraitControler.clotureLocationAbonne(bornette, locationAbonne);
        System.out.println("Vous avez été prélevé de " + prix + " euros");
        System.out.println("Toute l'équipe vous souhaite une bonne fin de journée");
        System.out.println("Appuyez sur entrée pour déposer votre vélo à la bornette n°" + this.bornette.getNumero());
        System.out.println("========================");
        ReadingConsole.readLine();
        //On stop cette vue
        this.stop();
    }

    private void displayAnnulationEmprunt() {
        this.clean();
        System.out.println("========================");
        System.out.println("ANNULATION DE L'EMPRUNT");
        System.out.println("========================");
        System.out.println("Veuillez nous excuser de l'état du vélo que vous avez emprunté");
        System.out.println("Vous ne serez pas prélevé");
        System.out.println("Appuyez sur entrée pour déposer votre vélo à la bornette n°"+this.bornette.getNumero());
        System.out.println("========================");
        ReadingConsole.readLine();
        retraitControler.clotureLocationHSUnderFiveMinutes(bornette,locationAbonne); //dépose le vélo sur une bornette et complète location sans calcul prix
        //On stop cette vue
        this.stop();
    }

    @Override
    protected void close() {

    }
}
