package fr.litopia.views.menus.station.retour;

import fr.litopia.model.LocationNonAbonne;
import fr.litopia.model.enums.Etat;
import fr.litopia.utils.ReadingConsole;
import fr.litopia.views.struct.api.View;
import fr.litopia.views.tinyView.RetourLocTinyView;

import java.text.DecimalFormat;

public class RetourNonAboView extends RetourComonContext {
    private LocationNonAbonne locationNonAbonne;
    private RetourLocTinyView retourLocTinyView;

    public LocationNonAbonne getLocationNonAbonne() {
        return locationNonAbonne;
    }

    public RetourNonAboView(View view) {
        super(view);
    }

    @Override
    protected void init() {
        retourLocTinyView = new RetourLocTinyView();
    }

    @Override
    protected void display() {
        System.out.println("=================");
        System.out.println("RENDRE UN VÉLO");
        System.out.println("==================");
        locationNonAbonne = retourLocTinyView.startAndGetValue();
        System.out.println("Vélo retourné "+locationNonAbonne);
        if (locationNonAbonne==null){
            this.stop().stop();
            return;
        }
        this.clean();
        System.out.println("=================");
        System.out.println("CODE CORRECT, VEUILLEZ RENSEIGNER L'ETAT DE VOTRE VÉLO :");
        System.out.println("==================");
        System.out.println("1. OK");
        System.out.println("2. HS");
        System.out.println("3. Retour");
        System.out.println("Votre choix : ");
        Integer choice = ReadingConsole.readInt(1,3);
        switch (choice) {
            case 1 -> displayPaiement();
            case 2 -> {
                retourControler.changeBikeState(locationNonAbonne, Etat.HS);
                if (retourControler.isUnderFiveMinutes(locationNonAbonne)) {
                    displayAnnulationEmprunt();
                    return;
                }
                displayPaiement();
            }
            case 3 -> this.stop().stop();
        }
        System.out.println("==================");
    }

    private void displayPaiement() {
        Double prix = retourControler.clotureLocationNonAbonne(bornette,locationNonAbonne);
        //formatage du prix à 3 chiffres après la virgule
        DecimalFormat df = new DecimalFormat("#.###");
        String prixString = df.format(prix);
        this.clean();
        System.out.println("========================");
        System.out.println("PAIEMENT DE LA LOCATION");
        System.out.println("========================");
        System.out.println("VéPick vous remercie de votre Location");
        System.out.println("Vous avez été prélevé(e) de "+prixString+" euros");
        System.out.println("Toute l'équipe vous souhaite une bonne fin de journée");
        System.out.println("Appuyez sur entrée pour déposer votre vélo à la bornette n°"+this.bornette.getNumero());
        System.out.println("========================");
        ReadingConsole.readLine();
        //On stop cette vue ainsi que la vue du dessus de retour vélo
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
        retourControler.clotureLocationHSUnderFiveMinutesNonAbo(bornette,locationNonAbonne); //dépose le vélo sur une bornette et complète location sans calcul prix
        //On stop cette vue ainsi que la vue du dessus de retour vélo
        this.stop().stop();
    }

    @Override
    protected void close() {

    }
}
