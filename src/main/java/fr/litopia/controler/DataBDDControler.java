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

    public Set<Velo> getVelos(int nb, Modele m) {
        Set<Velo> lesVelos = new HashSet<>();
        for (int i = 0; i < nb; i++) {
            Velo v = new Velo();
            int t = new Random().nextInt(Etat.values().length);
            v.setEtat(Etat.values()[t]);
            v.setModele(m);
            lesVelos.add(v);
        }
        return lesVelos;
    }






    /*--------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------Modele-------------------------------------------------------*/
    /*--------------------------------------------------------------------------------------------------------------*/


    public Set<Modele> allModele() {

        Set<Modele> velo_modeles = new HashSet<>();
        double val_non_null_prix = 5.0;
        String tupeModels[] = {"Velo électrique", "velo tout terrain",
                "Velo de ville", "velo pour enfant", "velo de descente"};

        for (int i = 0; i < tupeModels.length; i++) {
            Modele model = new Modele();

            model.setName(tupeModels[i]);
            model.setPrixHoraire(i * 2 + val_non_null_prix);
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
            //System.out.println("Station : " + stat.getAdresse() + " nb:" + stat.getBornettes().size());
            stationRepository.save(stat);
        }

        for (Modele mod : allModele()) {
            modeleRepository.save(mod);
            for (Velo v : getVelos(10, mod)) {
                veloRepository.save(v);
            }
        }

        Set<Abonne> abos = lesAbonnees(15);
        for (Abonne abo : abos) {
            abonneRepository.save(abo);
        }
        for (LocationAbonne locAbo : allLocationsAbonne(11,abos)) {
            locationAbonneRepository.save(locAbo);

        }
        /*for (LocationNonAbonne locNonAbo : allLocationsNonAbonne(11)) {
            locationNonAbonneRepository.save(locNonAbo);
        }*/



        entityManager.getTransaction().commit();
    }

    public void deleteData() {
        //@TODO delete toutes les données de la BDD
    }



    /*-------------------------------------------------------------------------------------------------------------*/
    /*---------------------------------les abonnées-----------------------------------------------------------------*/
    /*-------------------------------------------------------------------------------------------------------------*/






    /*-------------------------------------------------------------------------------------------------------------*/
    //---------------------------------Location---------------------------------------------------------------------
    /*--------------------------------------------------------------------------------------------------------------*/

    public Set<LocationAbonne> allLocationsAbonne(int n, Set<Abonne> lesAbos  ) {


        Set<LocationAbonne> locations = new HashSet<>();

        for(Abonne abo: lesAbos){
            LocationAbonne locAbo=new LocationAbonne();
            locAbo.setAbonne(abo);
            LocalDateTime now = LocalDateTime.now();
            locAbo.setDepart(now);
            locAbo.setPrix(22.0);
            locAbo.setTemps(12);
            locations.add(locAbo);
        }

        return locations;
    }


    /*public Set<LocationNonAbonne> allLocationsNonAbonne(int n) {

        Set<LocationNonAbonne> locations = new HashSet<>();
        LocationNonAbonne locNonAbo_1 = new LocationNonAbonne();
        Velo velo = new Velo();
        Abonne abonne = new Abonne();

        abonne.setCb("67555387638763");
        abonne.setMdp("68T8355395579");


        LocalDateTime now = LocalDateTime.now();
        locNonAbo_1.setDepart(now);
        locNonAbo_1.setPrix(22.0);
        locNonAbo_1.setTemps(12);

        locNonAbo_1.setVelo(velo);

        locations.add(locNonAbo_1);


        return locations;
    }*/

    /*-------------------------------------------------------------------------------------------------------------*/
    //---------------------------------les Abonnée---------------------------------------------------------------------
    /*--------------------------------------------------------------------------------------------------------------*/

    public Set<Abonne> lesAbonnees(int n) {
        Set<Abonne> abonnes = new HashSet<>();


        for (int i = 0; i < n; i++) {
            Abonne abo = new Abonne();
            abo.setLogin("0"+i);
            abo.setMdp(i + "vepikOk" + i + 1 + "--");
            abo.setAdresse(i + "12 rue des calendars 38000");
            abo.setCreditTemps(3 + i);
            abo.setNom(i + i + i + "Macron" + i + i);
            abo.setPrenom(i + i + i + "thomas" + i + i);
            abo.setCb("8785765326986980");

            abonnes.add(abo);
        }


        return abonnes;
    }


}

