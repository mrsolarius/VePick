package fr.litopia.views.menus.station.retour;

import fr.litopia.model.Abonne;
import fr.litopia.model.LocationAbonne;
import fr.litopia.model.enums.Etat;
import fr.litopia.utils.ReadingConsole;
import fr.litopia.views.struct.api.View;
import fr.litopia.views.tinyView.LoginTinyView;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class RetourAboView extends RetourComonContext {
    public RetourAboView(View view) {
        super(view);
    }

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
        Abonne abonne = loginTinyView.startAndGetValue();
        if(abonne == null){
            this.stop().stop();
            return;
        }
        ArrayList<LocationAbonne> locationsEnCours = new ArrayList<>(retourControler.getLocationsEnCours(abonne));

        this.clean();
        System.out.println("=================");
        System.out.println("VEUILLEZ SELECTIONNER LES LOCATIONS QUE VOUS SOUHAITEZ TERMINER :\n");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        for (int i = 0; i < locationsEnCours.size(); i++) {
            System.out.println("Location n°"+i+" démarrée le "+ locationsEnCours.get(i).getDepart().format(formatter)+" avec le vélo n°"+ locationsEnCours.get(i).getVelo().getNumero());
        }
        System.out.println("\n==========================");
        System.out.println("Entrez -1 pour quitter");
        int selection = ReadingConsole.readInt(-1, locationsEnCours.size()-1);
        if (selection == -1) {
            this.stop().stop();
            return;
        }
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
                retourControler.changeBikeState(locationAbonne, Etat.HS);
                if (retourControler.isUnderFiveMinutes(locationAbonne)) {
                    displayAnnulationEmprunt();
                }else {
                    displayPaiement();
                }
            }
            case 3 -> this.stop().stop();
        }
        System.out.println("==================");
    }

    private void displayPaiement() {
        Double prix = retourControler.clotureLocationAbonne(bornette, locationAbonne);
        DecimalFormat df = new DecimalFormat("#.###");
        String prixString = df.format(prix);
        this.clean();
        System.out.println("========================");
        System.out.println("PAIEMENT DE LA LOCATION");
        System.out.println("========================");
        System.out.println("VéPick vous remercie de votre Location");
        System.out.println("Vous avez été prélevé(e) de " + prixString + " euros");
        System.out.println("Toute l'équipe vous souhaite une bonne fin de journée");
        System.out.println("Appuyez sur entrée pour déposer votre vélo à la bornette n°" + this.bornette.getNumero());
        System.out.println("========================");
        ReadingConsole.readLine();
        //On stop cette vue
        this.stop().stop();
    }

    private void displayAnnulationEmprunt() {
        this.clean();
        System.out.println("========================");
        System.out.println("ANNULATION DE L'EMPRUNT");
        System.out.println("========================");
        System.out.println("Veuillez nous excuser");
        System.out.println("Vous ne serez pas prélevé");
        System.out.println("Appuyez sur entrée pour déposer votre vélo à la bornette n°"+this.bornette.getNumero());
        System.out.println("========================");
        ReadingConsole.readLine();
        retourControler.clotureLocationHSUnderFiveMinutesAbo(bornette,locationAbonne); //dépose le vélo sur une bornette et complète location sans calcul prix
        //On stop cette vue
        this.stop().stop();
    }

    @Override
    protected void close() {

    }
}
