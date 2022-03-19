package fr.litopia.controler;

import fr.litopia.model.*;
import fr.litopia.model.enums.Etat;
import fr.litopia.model.enums.VStatus;
import fr.litopia.respository.api.*;
import fr.litopia.view.View;
import org.h2.engine.Mode;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class DataBDDControler extends Controler {
    private AbonneRepository abonneRepository;
    private BornetteRepository bornetteRepository;
    private LocationAbonneRepository locationAbonneRepository;
    private LocationNonAbonneRepository locationNonAbonneRepository;
    private ModeleRepository modeleRepository;
    private StationRepository stationRepository;
    private VeloRepository veloRepository;


    public DataBDDControler(View view) {
        super(view);
    }


    @Override

    public void init() {
        abonneRepository = daoFactory.newAbonneRepository(entityManager);
        bornetteRepository = daoFactory.newBornetteRepository(entityManager);
        locationAbonneRepository = daoFactory.newLocationAbonneRepository(entityManager);
        locationNonAbonneRepository = daoFactory.newLocationNonAbonneRepository(entityManager);
        modeleRepository = daoFactory.newModeleRepository(entityManager);
        stationRepository = daoFactory.newStationRepository(entityManager);
        veloRepository = daoFactory.newVeloRepository(entityManager);
    }

    /*-------------------------------------------------------------------------------------------------------------*/
    /*---------------------------------Les Bornettes---------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------------*/

    private Set<Bornette> getBornettes(int nb, Station s) {
        Set<Bornette> lesBornettes = new HashSet<>();
        for (int i = 0; i < nb; i++) {
            Bornette b = new Bornette();
            BornettePK bpk = new BornettePK();
            bpk.setStation(s);
            bpk.autoGenerateNumero(this.entityManager);
            b.setPk(bpk);
            System.out.println("Id " + b.getNumero());
            lesBornettes.add(b);
        }
        return lesBornettes;
    }



    /*-------------------------------------------------------------------------------------------------------------*/
    /*---------------------------------Les Stations---------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------------*/


    public Set<Station> allStations() {

        Set<Station> stations = new HashSet<>();
        Station victor_hugo = new Station();

        victor_hugo.setVStatus(VStatus.VMOINS);
        victor_hugo.setAdresse("12 place felix poulat 38000");


        victor_hugo.setBornettes(this.getBornettes(3, victor_hugo));
        stations.add(victor_hugo);


        Station malherbe = new Station();
        malherbe.setAdresse("7 rue des invalide 38000");
        malherbe.setVStatus(VStatus.VNUL);
        malherbe.setBornettes(this.getBornettes(6, malherbe));
        stations.add(malherbe);


        Station gare = new Station();
        gare.setVStatus(VStatus.VPLUS);
        gare.setAdresse("19 rue paul janet 38000");
        gare.setBornettes(this.getBornettes(10, gare));

        stations.add(gare);


        return stations;
    }

    /*--------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------------Velo---------------------------------------------------*/
    /*--------------------------------------------------------------------------------------------------------------*/

    private Set<Velo> getVelos(int nb, Modele m) {
        Set<Velo> lesVelos = new HashSet<>();
        for (int i = 0; i < nb; i++) {
            Velo v = new Velo();
            int t = new Random().nextInt(Etat.values().length);
            v.setEtat(Etat.values()[t]);
            lesVelos.add(v);
        }
        return lesVelos;
    }






    /*--------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------Modele-------------------------------------------------------*/
    /*--------------------------------------------------------------------------------------------------------------*/


    public Set<Modele> allModele() {

        Set<Modele> velo_modeles = new HashSet<>();
        double  val_non_null_prix=5.0;
        int val_non_null_velo =5;
        String tupeModels[] = {"Vélo électrique", "velo tout terrain", "",
                "Vélo de ville", "vélo pour enfant", "vélo de descente"};

        for (int i = 0; i < tupeModels.length; i++) {
            Modele model = new Modele();

            model.setName(tupeModels[i]);
            model.setPrixHoraire(i * 2 + val_non_null_prix);
            model.setVelos(this.getVelos(i + val_non_null_velo, model));
            velo_modeles.add(model);
        }

        return velo_modeles;
    }



    public void initializeData() {
        System.out.println("Là");
        //@TODO initialize toutes les données de la BDD

        entityManager.getTransaction().begin();
        System.out.println("allStation : " + allStations().size());

        //les stations

        for (Station stat : allStations()) {
            System.out.println("Station : " + stat.getAdresse() + " nb:" + stat.getBornettes().size());
            stationRepository.save(stat);


        }

        for (Modele mod : allModele()) {
            modeleRepository.save(mod);
        }


        entityManager.getTransaction().commit();
    }

    public void deleteData() {
        //@TODO delete toutes les données de la BDD
    }








    /*-------------------------------------------------------------------------------------------------------------*/
    //---------------------------------Location---------------------------------------------------------------------
    /*--------------------------------------------------------------------------------------------------------------*/

    public Set<Location> allLocations() {

        Set<Location> locations = new HashSet<>();
        Location location_1 = new Location();
        Location location_2 = new Location();
        Location location_3 = new Location();

        LocalDateTime now = LocalDateTime.now();
        location_1.setDepart(now);
        location_1.setPrix(22.0);
        location_1.setTemps(12);


        locations.add(location_1);

        return locations;

    }


}

